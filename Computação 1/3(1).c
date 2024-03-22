#include <stdio.h>

unsigned int resto(unsigned int x, unsigned int y) {
    if(x == 0 || y == 1) return 0;
    else if(x < y) return x;
    else return resto((x-y), y);
}

int main(void) {
    unsigned int num1, num2;
    
    puts("Entre com um numero inteiro nao negativo.");
    scanf("%u", &num1);
    puts("Entre com um numero inteiro positivo.");
    scanf("%u", &num2);
    printf("O resto da divisao de %u por %u eh igual a %u.\n", num1, num2, resto(num1, num2));
    return 0;
}