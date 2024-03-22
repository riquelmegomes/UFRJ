# -*- coding: utf-8 -*-
"""Questão 3 - Trabalho Final

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/1xtbeHNcIn2j7DRB6BT9sfwXcq2-_pJgE

Questão 3a)

Utilizando a função "fatoração_Fermat_v2", feita em aula, para fatorar n.
"""

from math import sqrt, floor
def fatoração_Fermat_v2(n):
  """
  Dado n ímpar, busca fator usando alg. de Fermat
  ou retorna que n é primo
  """
  x = int(sqrt(n))
  limite = (n-1)/2
  if x**2 == n:
    return x
  x += 1
  y = sqrt(x**2 - n)
  while True:
    if floor(y) == y:
      y = floor(y)
      return x-y,x+y
    x += 1
    if x > limite:
      return "primo"
    y = sqrt(x**2 - n)

fatoração_Fermat_v2(8989)

"""Utilizando a função "Euclides_estendido", feita em aula, para encontrar d."""

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
  return Dividendo, x_ant, y_ant

Euclides_estendido(3, 8800)

"""d = - 2933

Calculando forma reduzida do d encontrado
"""

pow(-2933, 1, 8800)

"""d = 5867

Verificando se ed ≡ 1 mod ((p-1)(q-1))
"""

p = 89
q = 101
phi = (p-1)*(q-1)
e = 3
d = 5867
pow(e*d, 1, phi) == 1

"""Questão 3b)"""

def encripta_blocos(b0, b1):
  n = 8989
  e = 3
  c0 = pow(b0, e, n)
  c1 = pow(b1, e, n)
  return (c0, c1)

encripta_blocos(1234, 5)

n = 8989
  e = 3
  b0 = 1234
  b1 = 5
  print('c0 =', pow(b0, e, n))
  print('c1 =', pow(b1, e, n))