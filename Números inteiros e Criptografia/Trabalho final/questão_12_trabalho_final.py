# -*- coding: utf-8 -*-
"""Questão 12 - Trabalho Final

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/1yKgxTpo5FIuGMqvdEDNL5lyrmRKsrARO

Questão 12a)
"""

def Miller_Rabin(n,b):
  """
  Retorna True se o teste de Miller--Rabin para n com base b **prova**
  que n é composto, False nos outros casos
  """
  b %= n # o mesmo que b = b%n
  if b <= 1:
    return False
  
  q = n-1
  k = 0
  while q%2 == 0:
    k += 1  # o mesmo que k = k+1
    q //= 2 # o mesmo que q = q//2; // é divisão inteira
  
  R = pow(b,q,n) # a função pow(b,q,n) gera resultados entre 0 e n-1
  if R==1 or R==n-1:
    return False

  i = 0
  while True:
    R = pow(R,2,n)
    i += 1
    if R == 1:
      # n é composto!
      return True
    # else implícito
    if i == k:
      # n é composto! (PTF)
      # pois nesse momento estamos calculando b**(2**k * q) = b**(n-1) mod n
      return True
    if R == n-1:
      return False

from random import randint
def gera_primo(n):
  """
  Função que recebe como entrada um natural n e gera um número 
  (provavelmente) primo p satisfazendo 10^n < p < 10^(n+2).
  """
  menor, maior = 10**n + 1, (10**(n+2)) - 1
  contador = 0
  
  p = randint(menor, maior-1)  # randint inclui ambos os valores
  if p%2 == 0: p += 1  # p deve ser ímpar
  while contador < 10:  # roda 10 testes de Miller-Rabin
    b = randint(2, p-2)
    if Miller_Rabin(p, b) == False:  # Função do teste Miller Rabin feita em aula
      contador +=  1
    else:
      contador = 0
      p = randint(menor, maior-1)
      if p%2 == 0: p -= 1
  return p

"""Questão 12b)"""

def Euclides_estendido(a,b):
  """
  ...
  """
  Dividendo, Divisor = a,b
  x_ant, y_ant = 1,0
  x_novo, y_novo = 0,1
  while Divisor != 0:
    Quociente, Resto = divmod(Dividendo, Divisor) # retorna o quociente e resto de uma vez só
    x_ant, x_novo = x_novo, (x_ant - x_novo*Quociente)
    y_ant, y_novo = y_novo, (y_ant - y_novo*Quociente)
    Dividendo, Divisor = Divisor, Resto
  return Dividendo, x_ant

def gera_chaves():
  """
  Função que utiliza a função "gera_primo" para gerar primos p e q, 
  sendo p com aproximadamente 50 algarismos e q com aproximadamente 100 algarismos,
  e, com isso, gera chaves do RSA.
  """
  p, q = gera_primo(48), gera_primo(98)
  n = p*q
  phi = (p-1)*(q-1)
  e = 3  # menor expoente ímpar > 1
  
  mdc, d = Euclides_estendido(e, phi) # Função de Euclides Estendido feita em aula
  while mdc != 1:
    e += 2
    mdc, d = Euclides_estendido(e, phi)
  d += phi
  return n, e, d

"""Questão 12c)"""

def encriptar(texto, n, e):
  """
  Função que tem como entrada uma string texto e números "n" e "e", e retorna 
  uma lista de números que seja uma sequência válida dos blocos numéricos 
  resultantes da encriptação do texto com chave pública de módulo n e expoente e.
  """
  símbolos_para_códigos = {'0': 111, '1': 112, '2': 113, '3': 114, '4': 115,
  '5': 116, '6': 117, '7': 118, '8': 119, '9': 121, '=': 122, '+': 123,
  '-': 124, '/': 125, '*': 126, 'a': 127, 'b': 128, 'c': 129, 'd': 131,
  'e': 132, 'f': 133, 'g': 134, 'h': 135, 'i': 136, 'j': 137, 'k': 138,
  'l': 139, 'm': 141, 'n': 142, 'o': 143, 'p': 144, 'q': 145, 'r': 146,
  's': 147, 't': 148, 'u': 149, 'v': 151, 'w': 152, 'x': 153, 'y': 154,
  'z': 155, 'á': 156, 'à': 157, 'â': 158, 'ã': 159, 'é': 161, 'ê': 162,
  'í': 163, 'ó': 164, 'ô': 165, 'õ': 166, 'ú': 167, 'ç': 168, 'A': 169,
  'B': 171, 'C': 172, 'D': 173, 'E': 174, 'F': 175, 'G': 176, 'H': 177,
  'I': 178, 'J': 179, 'K': 181, 'L': 182, 'M': 183, 'N': 184, 'O': 185,
  'P': 186, 'Q': 187, 'R': 188, 'S': 189, 'T': 191, 'U': 192, 'V': 193,
  'W': 194, 'X': 195, 'Y': 196, 'Z': 197, 'Á': 198, 'À': 199, 'Â': 211,
  'Ã': 212, 'É': 213, 'Ê': 214, 'Í': 215, 'Ó': 216, 'Ô': 217, 'Õ': 218,
  'Ú': 219, 'Ç': 221, ',': 222, '.': 223, '!': 224, '?': 225, ';': 226,
  ':': 227, '_': 228, '(': 229, ')': 231, '"': 232, '#': 233, '$': 234,
  '%': 235, '@': 236, ' ': 237, '\n': 238}
  tam_texto = len(texto)
  blocos_encriptados = []

  for símbolo in range(0, tam_texto):
    blocos_encriptados += texto[símbolo]
    blocos_encriptados[símbolo] = símbolos_para_códigos[blocos_encriptados[símbolo]]
    blocos_encriptados[símbolo] = pow(blocos_encriptados[símbolo], e, n)
  return blocos_encriptados

"""Questão 12d)"""

def descriptar(lista_blocos, n, d):
  """
  Função que recebe como entrada uma lista blocos e números n e d, 
  e retorna a string resultante da descriptação da sequência de 
  blocos usando a chave privada de módulo n e expoente d.
  """
  códigos_para_símbolos = {111: '0', 112: '1', 113: '2', 114: '3', 115: '4',
  116: '5', 117: '6', 118: '7', 119: '8', 121: '9', 122: '=', 123: '+',
  124: '-', 125: '/', 126: '*', 127: 'a', 128: 'b', 129: 'c', 131: 'd',
  132: 'e', 133: 'f', 134: 'g', 135: 'h', 136: 'i', 137: 'j', 138: 'k',
  139: 'l', 141: 'm', 142: 'n', 143: 'o', 144: 'p', 145: 'q', 146: 'r',
  147: 's', 148: 't', 149: 'u', 151: 'v', 152: 'w', 153: 'x', 154: 'y',
  155: 'z', 156: 'á', 157: 'à', 158: 'â', 159: 'ã', 161: 'é', 162: 'ê',
  163: 'í', 164: 'ó', 165: 'ô', 166: 'õ', 167: 'ú', 168: 'ç', 169: 'A',
  171: 'B', 172: 'C', 173: 'D', 174: 'E', 175: 'F', 176: 'G', 177: 'H',
  178: 'I', 179: 'J', 181: 'K', 182: 'L', 183: 'M', 184: 'N', 185: 'O',
  186: 'P', 187: 'Q', 188: 'R', 189: 'S', 191: 'T', 192: 'U', 193: 'V',
  194: 'W', 195: 'X', 196: 'Y', 197: 'Z', 198: 'Á', 199: 'À', 211: 'Â',
  212: 'Ã', 213: 'É', 214: 'Ê', 215: 'Í', 216: 'Ó', 217: 'Ô', 218: 'Õ',
  219: 'Ú', 221: 'Ç', 222: ',', 223: '.', 224: '!', 225: '?', 226: ';',
  227: ':', 228: '_', 229: '(', 231: ')', 232: '"', 233: '#', 234: '$',
  235: '%', 236: '@', 237: ' ', 238: '\n'}
  tam_lista = len(lista_blocos)
  mensagem = ''

  for bloco in range(0, tam_lista): 
    lista_blocos[bloco] = pow(lista_blocos[bloco], d, n)
    mensagem += códigos_para_símbolos[lista_blocos[bloco]]
  return mensagem

"""Testando minhas funções"""

n, e, d = gera_chaves()
descriptar(encriptar("slk daora", n, e), n, d)