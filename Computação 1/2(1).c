#include <stdio.h>

int mdc(int x, int y) {
    if(y == 0) return x;
    else return (mdc(y, x%y));
}

int main(void) {
    int num1, num2;

    puts("Entre com o primeiro numero.");
    scanf("%d", &num1);
    puts("Entre com o segundo numero.");
    scanf("%d", &num2);
    printf("O maximo divisor comum entre %d e %d eh: %d.\n", num1, num2, mdc(num1, num2));
    return 0;
}