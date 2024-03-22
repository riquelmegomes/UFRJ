#include <stdio.h>

typedef struct _TEMPO {
    int hora, minuto, segundo;
} TEMPO;

int comparaTempo(TEMPO t1, TEMPO t2) {
    if(t1.segundo < t2.segundo) return -1;
    else if(t1.segundo == t2.segundo) return 0;
    else if(t1.segundo > t2.segundo) return 1;
    return 0;
}

int main(void) {
    TEMPO t1, t2;
   
    printf("Entre com um tempo t1 no formato: horas minutos segundos.\n");
    scanf("%d %d %d", &t1.hora, &t1.minuto, &t1.segundo);
    printf("Entre com um tempo t2 no formato: horas minutos segundos.\n");
    scanf("%d %d %d", &t2.hora, &t2.minuto, &t2.segundo);
    
    t1.segundo = t1.segundo + (t1.minuto*60) + (t1.hora*3600);   /*Converte t1 para segundos */
    t2.segundo = t2.segundo + (t2.minuto*60) + (t2.hora*3600);   /*Converte t2 para segundos */

    if(comparaTempo(t1, t2) == 0)
        printf("Os dois tempos sao iguais.");
    else if(comparaTempo(t1, t2) == 1)
        printf("O maior tempo eh: t1\n");
    else 
        printf("O maior tempo eh: t2\n");
    return 0;
}