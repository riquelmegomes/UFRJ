import random
import numpy as np

def esticamento_encolhimento(B, C, i, fator):
    """ i >= 1, 'fator' != 0
        Multiplica a coluna i da matriz B por 'fator'.
        Divide a linha i da matriz C por 'fator'.     
    """

    linhas_B = B.shape[0] 
    colunas_C = C.shape[1] 
    i -= 1  # adaptando para i >= 0

    for linha in range(linhas_B):
        B[linha, i] *= fator

    for coluna in range(colunas_C):
        C[i, coluna] /= fator
 
    return B, C


def troca(B, C, i, j):
    """ i, j >= 1
        Troca a coluna i com a coluna j (na matriz B).
        Troca a linha i com a linha j (na matriz C).  
    """
    
    linhas_B = B.shape[0] 
    colunas_C = C.shape[1] 
    i -= 1  # adaptando para i, j >= 0
    j -= 1
    
    for linha in range(linhas_B):
        B[linha, i], B[linha, j] = B[linha, j], B[linha, i]

    for coluna in range(colunas_C):
        C[i, coluna], C[j, coluna] = C[j, coluna], C[i, coluna]
 
    return B, C


def soma_subtracao(B, C, i, j, fator):
    """ i, j >= 1
        Soma o produto (entre a coluna j e o fator) à coluna i (na matriz B).
        Subtrai o produto (entre a linha i e o fator) da linha j (na matriz C).
    """

    linhas_B = B.shape[0] 
    colunas_C = C.shape[1] 
    i -= 1  # adaptando para i, j >= 0
    j -= 1

    for linha in range(linhas_B):
        B[linha, i] += B[linha, j] * fator

    for coluna in range(colunas_C):
        C[j, coluna] -= C[i, coluna] * fator

    return B, C

def fatoracao(A, i, j, fator):
   """Fatora a matriz A(NxM) em duas matrizes B(NxN) e C(NxM)"""
 
   B = np.eye(A.shape[0]) # cria matriz identidade NxN
   C = A
   
   print(f"i = {i}, j = {j}, fator = {fator}\n")
   print(C)

   B, C = esticamento_encolhimento(B, C, i, fator)
   print("\n\nEsticamento/Encolhimento\n", C)

   B, C = troca(B, C, i, j)
   print("\n\nTroca\n", C)

   B, C = soma_subtracao(B, C, i, j, fator)
   print("\n\nSoma/Subtracao\n", C)

   #return B, C

i = random.randrange(1, 5)
j = random.randrange(1, 5)
fator = random.randrange(2, 11)
A = np.array([[2, 4, 1, 8, 11, 101], 
              [2, 4, 2, 8, 12, 102],
              [2, 4, 3, 8, 13, 103],
              [2, 4, 4, 8, 14, 104]])

fatoracao(A, i, j, fator)