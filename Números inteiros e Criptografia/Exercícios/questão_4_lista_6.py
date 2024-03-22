# -*- coding: utf-8 -*-
"""Questão 4 - lista 6

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/1zpqDTahLTqmnlG5FW2nemJP_UQVwd8Yx

Função do Crivo de Eratóstenes, feita e demonstrada em aula, 
usada para encontrar a lista de todos os primos de 2 até n >= 2, 
inclusive o n, se for o caso.
"""

from math import sqrt
def crivo(n):
  """
  Recebe n ≥ 2 e retorna a lista de todos os primos de 2 até n
  inclusive o n, se for o caso
  """
  limite = int(sqrt(n))
  # dict comprehension!
  é_composto = {chave:False for chave in range(2,n+1)}
  for chave in é_composto:
    if é_composto[chave]:
      # a chave atual é um número composto, vamos ignorar e partir
      # para a próxima
      continue
    if chave > limite:
      # acabou a etapa de eliminação
      break
    # chave é um primo, vamos eliminar seus múltiplos
    for múltiplo in range(chave**2,n+1,chave):
      é_composto[múltiplo] = True
  return [chave for chave,valor in é_composto.items() if not valor]

"""Questão 4)"""

def k_gemeos(k, limite):
    """
    Função que recebe dois naturais k>0 e limite, e retorna a lista de todos os
    pares de primos k-gêmeos que existem até (incluindo, se for o caso) o limite.
    """
    lista_primos = crivo(limite)
    lista_k_gemeos = []
    for primo in lista_primos:
        if primo + k in lista_primos:
            lista_k_gemeos.append([primo, primo+k])
    return lista_k_gemeos

# Commented out IPython magic to ensure Python compatibility.
# %time k_gemeos(2, 10**5)