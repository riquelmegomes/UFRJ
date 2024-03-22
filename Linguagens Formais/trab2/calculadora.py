from math import sqrt
import sys
from sys import argv
import re

# Definindo classes de Token, Expressão e Parser

class Token():
    def __init__(self, tokenType, tokenValue):
        self.tokenType = tokenType
        self.tokenValue = tokenValue

class ExpNum():
    def __init__(self, value):
        self.tag = 'EXPNUM'
        self.value = value

class ExpVar():
    def __init__(self, var):
        self.tag = 'EXPVAR'
        self.var = var

class ExpNeg():
    def __init__(self, exp):
        self.tag = 'EXPNEG'
        self.exp = exp  # exp pode ser ExpNum, ExpVar, ExpSqrt, ExpParenthesis

class ExpSqrt():
    def __init__(self, exp):
        self.tag = 'EXPSQRT'
        self.exp = exp

class ExpPar():
    def __init__(self, exp):
        self.tag = 'EXPPAR'
        self.exp = exp

class ExpBin():
    def __init__(self, exp1, operator, exp2):
        self.tag = 'EXPBIN'
        self.exp1 = exp1
        self.operator = operator
        self.exp2 = exp2

class ExpAssign():
    def __init__(self, prevAssign, var, exp):
        self.tag = 'EXPASSIGN'
        self.prevAssign = prevAssign
        self.var = var
        self.exp = exp

class ExpPrint():
    def __init__(self, prevPrint, exp):
        self.tag = 'EXPPRINT'
        self.prevPrint = prevPrint
        self.exp = exp

class ExpTotal():
    def __init__(self, expassign, expprint):
        self.tag = 'EXPTOTAL'
        self.expassign = expassign
        self.expprint = expprint

class Parser:
    def __init__(self, tokens):
        self.tokens = tokens
        self.index = 0

    def peek(self, token_type):
        # Verifica se o próximo token corresponde ao tipo esperado
        if self.index < len(self.tokens) and self.tokens[self.index].tokenType == token_type:
            return True
        return False

    def consume(self, token_type):
        # Consome o próximo token se for do tipo esperado
        if self.peek(token_type):
            token = self.tokens[self.index]
            self.index += 1
            return token.tokenValue
        else:
            raise SyntaxError(f"Expected token type '{token_type}', but got '{self.tokens[self.index].tokenType}'.")

    def parseS(self):
        while self.index < len(self.tokens):
            
            # Realiza o parsing de uma atribuição
            if self.peek('VARIABLE'):
                varAssign = self.parseVS()
            
            # Realiza o parsing de um cálculo
            elif self.peek('ARROBA'):
                calcPrint = self.parsePS()
            
            # Consome NEWLINE após atribuição ou print
            elif self.peek('NEWLINE'):
                self.consume('NEWLINE')
            
            # Finaliza o parsing no EOF
            elif self.peek('EOF'):
                self.consume('EOF')

            # Trata erro de sintaxe
            else:
                raise SyntaxError(f"Unexpected token type: '{self.tokens[self.index].tokenType}'.")

        return ExpTotal(varAssign, calcPrint)

    def parseVS(self):
        # Realiza o parsing de uma atribuição
        var = self.consume('VARIABLE')
        self.consume('EQUALS')
        exp = self.parseE()
        prev = ExpAssign(None, var, exp)
        
        while self.peek('NEWLINE'):
            self.consume('NEWLINE')
            if self.peek('VARIABLE'):
                var = self.consume('VARIABLE')
                self.consume('EQUALS')
                exp = self.parseE()
                prev = ExpAssign(prev, var, exp)

        return prev
    
    def parsePS(self):
        # Realiza o parsing de um cálculo para impressão na tela
        self.consume('ARROBA')
        calc = self.parseE()
        prev = ExpPrint(None, calc)
        
        while self.peek('NEWLINE'):
            self.consume('NEWLINE')
            if self.peek('ARROBA'):
                self.consume('ARROBA')
                calc = self.parseE()
                prev = ExpPrint(prev, calc)

        return prev

    def parseE(self):
        # Realiza o parsing de uma expressão aritmética
        e = self.parseT()

        while self.peek('PLUS') or self.peek('MINUS'):
            if self.peek('PLUS'):
                self.consume('PLUS')
                t = self.parseT()
                e = ExpBin(e, '+', t)
        
            elif self.peek('MINUS'):
                self.consume('MINUS')
                t = self.parseT()
                e = ExpBin(e, '-', t)

        return e

    def parseT(self):
        # Realiza o parsing de um termo aritmético
        t = self.parseF()

        while self.peek('ASTERISK') or self.peek('SLASH'):
            if self.peek('ASTERISK'):
                self.consume('ASTERISK')
                f = self.parseF()
                t = ExpBin(t, '*', f)
        
            elif self.peek('SLASH'):
                self.consume('SLASH')
                f = self.parseF()
                t = ExpBin(t, '/', f)

        return t

    def parseF(self):
        # Realiza o parsing de um fator aritmético
        if self.peek('MINUS'):
            self.consume('MINUS')
            f = self.parseF()
            return ExpNeg(f)
    
        elif self.peek('NUMBER'):
            num = self.consume('NUMBER')
            return ExpNum(float(num))
    
        elif self.peek('VARIABLE'):
            var = self.consume('VARIABLE')
            return ExpVar(var)
    
        elif self.peek('SQRT'):
            self.consume('SQRT')
            self.consume('LEFT_PARENTHESES')
            exp = self.parseE()
            self.consume('RIGHT_PARENTHESES')
            return ExpSqrt(exp)
    
        elif self.peek('LEFT_PARENTHESES'):
            self.consume('LEFT_PARENTHESES')
            exp = self.parseE()
            self.consume('RIGHT_PARENTHESES')
            return exp
    
        else:
            raise SyntaxError(f"Unexpected token type: '{self.tokens[self.index].tokenType}'.")


# Definindo os padrões de expressão regular para os tokens em Python
patterns = [
    (re.compile(r'[a-zA-Z_][a-zA-Z0-9_]*'), 'VARIABLE'),
    (re.compile(r'\@'), 'ARROBA'),
    (re.compile(r'\d+'), 'NUMBER'),
    (re.compile(r'\+'), 'PLUS'),
    (re.compile(r'\-'), 'MINUS'),
    (re.compile(r'\*'), 'ASTERISK'),
    (re.compile(r'\/'), 'SLASH'),
    (re.compile(r'\='), 'EQUALS'),
    (re.compile(r'\('), 'LEFT_PARENTHESES'),
    (re.compile(r'\)'), 'RIGHT_PARENTHESES'),
    (re.compile(r'\n'), 'NEWLINE'),
    (re.compile(r'\s+'), 'SPACE'),
    (re.compile(r'\#.*'), 'COMMENT')
]

# Função para analisar um arquivo .py e retornar os tokens
def lexicalAnalyzer(file_path):
    tokens = []
    print("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@")
    # Responsável pela leitura do arquivo
    with open(file_path, 'r') as file:
        code = file.read()

    # Itera sobre o arquivo
    while code:
        match = None
        for pattern, token_type in patterns:
            match = pattern.match(code)

            # Verifica se a sintaxe é válida
            if match:
                value = match.group(0)
                if token_type == 'VARIABLE' or token_type == 'NUMBER':
                    if value == 'sqrt':
                        tokens.append(Token('SQRT', None))
                    else:
                        tokens.append(Token(token_type, value))
                    
                elif token_type != 'SPACE':
                    tokens.append(Token(token_type, None))
                break

        # Erro de sintaxe
        if not match:
            raise SyntaxError('Caractere inválido: %s' % code[0])
        code = code[match.end():]

    tokens.append(Token('EOF', None))
    print("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@")

    return tokens

def printTokens(file_path):
    # Exibe os tokens lidos no terminal
    tokens = lexicalAnalyzer(file_path)
    for token in tokens:
        print(token.tokenType, token.tokenValue)

def calculateExpression(expression, valueDict):
    exptag = expression.tag

    if exptag == 'EXPNUM':
        return expression.value

    elif exptag == 'EXPVAR':
        return valueDict.get(expression.var)

    elif exptag == 'EXPNEG':
        return -calculateExpression(expression.exp, valueDict)

    elif exptag == 'EXPSQRT':
        return sqrt(calculateExpression(expression.exp, valueDict))

    elif exptag == 'EXPPAR':
        return (calculateExpression(expression.exp, valueDict))

    elif exptag == 'EXPBIN':
        e1 = calculateExpression(expression.exp1, valueDict)
        op = expression.operator
        e2 = calculateExpression(expression.exp2, valueDict)
        if op == '+':
            return e1 + e2
        elif op == '-':
            return e1 - e2
        elif op == '*':
            return e1 * e2
        elif op == '/':
            return e1 / e2

    elif exptag == 'EXPASSIGN':
        if expression.prevAssign == None:
            valueDict[expression.var] = calculateExpression(expression.exp, valueDict)
        else:
            valueDict[expression.var] = calculateExpression(expression.prevAssign, valueDict)
            valueDict[expression.var] = calculateExpression(expression.exp, valueDict)
    
    elif exptag == 'EXPPRINT':
        if expression.prevPrint == None:
            print("\n@:", calculateExpression(expression.exp, valueDict))
        else:
            calculateExpression(expression.prevPrint, valueDict)
            print("\n@:", calculateExpression(expression.exp, valueDict))
    
    elif exptag == 'EXPTOTAL':
        calculateExpression(expression.expassign, valueDict)
        calculateExpression(expression.expprint, valueDict)

    else:
        assert(False)



if __name__ == '__main__':
    # Define arquivo a ser analisado lexicamente
    
    file_path = './entrada.txt'
    '''
    if len(argv) != 2:
        sys.exit("Insira path do arquivo no terminal no formato: python calculadora.py arquivo.txt")
    
    file_path = argv[1]
    '''
    
    # printa os tokens (debugger)
    tokens = lexicalAnalyzer(file_path)
    for token in tokens:
        print(token.tokenType, token.tokenValue)
    
    # faz o parse dos tokens retornados
    parser = Parser(tokens)
    expression = parser.parseS()

    valueOfVariables = {}
    calculateExpression(expression, valueOfVariables)
    print("\nDicionário resultado: ",valueOfVariables)