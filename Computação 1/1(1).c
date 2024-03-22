#include <stdio.h>

int multiplicacao(int x, int y) {
    if(y == 0) return 0;
    else return (x + multiplicacao(x, y-1));
}

int main(void) {
    int num1, num2;

    puts("Entre com o primeiro numero.");
    scanf("%d", &num1);
    puts("Entre com o segundo numero.");
    scanf("%d", &num2);
    printf("%d x %d = %d\n", num1, num2, multiplicacao(num1, num2));
    return 0;
}