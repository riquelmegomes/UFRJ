#include <stdio.h>

typedef struct _FRACAO {
    int numerador, denominador;
} FRACAO;
FRACAO f1, f2, resultado;

FRACAO soma (FRACAO a, FRACAO b); /* a + b */
FRACAO subtracao (FRACAO a, FRACAO b); /* a - b */
FRACAO multiplicacao (FRACAO a, FRACAO b); /* a * b */
FRACAO divisao (FRACAO a, FRACAO b); /* a / b */

int main(void) {

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
    
    soma(f1, f2);
    printf("\nSOMA: %d/%d\n", resultado.numerador, resultado.denominador);

    subtracao(f1, f2);
    printf("SUBTRACAO: %d/%d\n", resultado.numerador, resultado.denominador);

    multiplicacao(f1, f2);
    printf("MULTIPLICACAO: %d/%d\n", resultado.numerador, resultado.denominador);

    divisao(f1, f2);
    printf("DIVISAO: %d/%d\n", resultado.numerador, resultado.denominador);

    return 0;
}

FRACAO soma (FRACAO a, FRACAO b) {
    if(f1.denominador == f2.denominador) {
        resultado.numerador = f1.numerador + f2.numerador;
        resultado.denominador = f1.denominador;
    }
    else {
       resultado.numerador = (f1.numerador*f2.denominador) + (f2.numerador*f1.denominador);
       resultado.denominador = f1.denominador*f2.denominador;
    }
    return resultado;
}

FRACAO subtracao (FRACAO a, FRACAO b) {
    if(f1.denominador == f2.denominador) {
        resultado.numerador = f1.numerador - f2.numerador;
        resultado.denominador = f1.denominador;
    }
    else {
       resultado.numerador = (f1.numerador*f2.denominador) - (f2.numerador*f1.denominador);
       resultado.denominador = f1.denominador*f2.denominador;
    }
    return resultado;
}

FRACAO multiplicacao (FRACAO a, FRACAO b) {
    resultado.numerador = f1.numerador*f2.numerador;
    resultado.denominador = f1.denominador*f2.denominador;
    return resultado;
}

FRACAO divisao (FRACAO a, FRACAO b) {
    resultado.numerador = f1.numerador*f2.denominador;
    resultado.denominador = f1.denominador*f2.numerador;
    return resultado;
}