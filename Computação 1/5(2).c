#include <stdio.h>

typedef struct _TEMPO {
    int hora, minuto, segundo;
} TEMPO;

int maior(int x, int y) { 
    if(x>y) return x;
    else return y;
}

int main(void) {
    TEMPO t1, t2;
   
    printf("Entre com um tempo t1 no formato: horas minutos segundos.\n");
    scanf("%d %d %d", &t1.hora, &t1.minuto, &t1.segundo);
    printf("Entre com um tempo t2 no formato: horas minutos segundos.\n");
    scanf("%d %d %d", &t2.hora, &t2.minuto, &t2.segundo);

    if(t1.hora == t2.hora){
        if(t1.minuto == t2.minuto){
            if(t1.segundo == t2.segundo)
                printf("Os dois tempos sao iguais.");
            else{
                if(maior(t1.segundo, t2.segundo) == t1.segundo)
                     printf("O maior tempo eh: t1\n");
                else
                     printf("O maior tempo eh: t2\n");
            }
        }       
        else {
            if(maior(t1.minuto, t2.minuto) == t1.minuto)
                    printf("O maior tempo eh: t1\n");
            else
                printf("O maior tempo eh: t2\n");
        }
    }
    else {
        if(maior(t1.hora, t2.hora) == t1.hora)
            printf("O maior tempo eh: t1\n");
        else
            printf("O maior tempo eh: t2\n");
    }
    return 0;
}