#include <stdio.h>

unsigned int fatorial(unsigned int n) {
    if(n == 0) return 1;
    else return (n *= fatorial(n-1));
}

int main(void) {
    unsigned int num;

    puts("Entre com um numero inteiro nao negativo.");
    scanf("%u", &num);
    printf("O fatorial de %u eh: %u.\n", num, fatorial(num));
    return 0;
}