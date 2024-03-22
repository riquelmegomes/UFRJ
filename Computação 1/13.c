#include <stdio.h>

typedef struct _FRACAO {
    int numerador, denominador;
} FRACAO;

int main(void) {
    FRACAO f1, f2;
    int num, denom;

    puts("Digite o numerador da fracao 1.");
    scanf("%d", &f1.numerador);
    puts("Digite o denominador da fracao 1.");
    scanf("%d", &f1.denominador);
    puts("Digite o numerador da fracao 2.");
    scanf("%d", &f2.numerador);
    puts("Digite o denominador da fracao 2.");
    scanf("%d", &f2.denominador);
    if ((f1.denominador == 0) || (f2.denominador == 0)) {
        puts("Denominador igual a zero, fracao invalida!");
        return 1;
    }
    /* SOMA */
    if(f1.denominador == f2.denominador) {
        num = f1.numerador + f2.numerador;
        denom = f1.denominador;
    }
    else {
       num = (f1.numerador*f2.denominador) + (f2.numerador*f1.denominador);
       denom = f1.denominador*f2.denominador;
    }
    printf("\nSOMA: %d/%d\n", num, denom);
    
    /* SUBTRAÇÃO */
    if(f1.denominador == f2.denominador) {
        num = f1.numerador - f2.numerador;
        denom = f1.denominador;
    }
    else {
       num = (f1.numerador*f2.denominador) - (f2.numerador*f1.denominador);
       denom = f1.denominador*f2.denominador;
    }
    printf("SUBTRACAO: %d/%d\n", num, denom);
    
    /* MULTIPLICAÇÃO */
    num = f1.numerador*f2.numerador;
    denom = f1.denominador*f2.denominador;
    printf("MULTIPLICACAO: %d/%d\n", num, denom);

    /* DIVISÃO */
    num = f1.numerador*f2.denominador;
    denom = f1.denominador*f2.numerador;
    printf("DIVISAO: %d/%d\n", num, denom);
    
    return 0;
}


