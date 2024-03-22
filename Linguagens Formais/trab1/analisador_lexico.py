import re
# MEMBROS: Jhayson Jales, Riquelme Gomes e Gabriel Trindade

# Definindo os padrões de expressão regular para os tokens em Python
patterns = [
    (r'import|if|for|while|end|and|from|in|def|with|as|None|break|raise|not|return', 'KEYWORD'),
    (r'True|False', 'BOOL'),
    (r'[a-zA-Z_][a-zA-Z0-9_]*', 'NOME'),
    (r'"(?:\\.|[^"\\])*"', 'STRING'),
    (r"'(?:\\.|[^'\\])*'", 'STRING'),
    (r'\d+', 'NUMERO'),
    (r'\s+', 'SPACE'),
    (r'\#.*', 'COMENTARIO'),
    (r'\-|\+|=|!|%|\(|\)|\[|\]|\{|\}|,|:|\.|;', 'SIMBOLO'),
]

file_path = './analisador_lexico.py'

# Função para analisar um arquivo .py e retornar os tokens
def lexer(file_path):
    tokens = []

    # responsavel pela leitura do arquivo
    with open(file_path, 'r') as file:
        code = file.read()
    
    # itera sobre o arquivo
    while code:
        match = None
        for pattern, token_type in patterns:
            regex = re.compile(pattern)
            match = regex.match(code)

            # verifica se a sintaxe é válida
            if match:
                value = match.group(0)
                if token_type != 'SPACE' and token_type != 'COMENTARIO':
                    tokens.append((token_type, value))
                break
        
        # Erro de sintaxe
        if not match:
            raise SyntaxError('Caractere invalido: %s' % code[0])
        code = code[match.end():]
    return tokens

tokens = lexer(file_path)
for token_type, value in tokens:
    print(token_type, value)