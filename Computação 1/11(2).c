#include <stdio.h>

/* Caso você digite o seu primeiro e último nomes separados por um branco, o programa 8(esse abaixo) imprime o seu último nome. 
O programa 5 faz o mesmo, porém ele utiliza também as posições de um vetor de caracteres para encontrar o sobrenome, enquanto o 
programa 8 usa somente ponteiros pra isso. */

void misterio (char *n);

int main (void) {
    char nome[41];
    gets(nome);
    misterio(nome);
    return 0;
}

void misterio (char *n) {
    while (*n != ' ') n++;
    n++;
    puts(n);
}