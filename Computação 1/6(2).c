#include <stdio.h>

typedef struct _TEMPO {
    int hora, minuto, segundo;
} TEMPO;

int main(void) {
    TEMPO t1, t2, t3;
    int m = 0, h = 0;
   
    printf("Entre com um tempo t1 no formato: horas minutos segundos.\n");
    scanf("%d %d %d", &t1.hora, &t1.minuto, &t1.segundo);
    printf("Entre com um tempo t2 no formato: horas minutos segundos.\n");
    scanf("%d %d %d", &t2.hora, &t2.minuto, &t2.segundo);
    
    if((t1.segundo + t2.segundo) < 60)
        t3.segundo = t1.segundo + t2.segundo;
    else {
        t3.segundo = (t1.segundo + t2.segundo - 60);
        m++;
    }
    if((t1.minuto + t2.minuto + m) < 60)
        t3.minuto = t1.minuto + t2.minuto + m;
    else {
        t3.minuto = (t1.minuto + t2.minuto + m - 60);
        h++;
    }
    t3.hora = t1.hora + t2.hora + h;
    
    printf("Resultado da soma: %d horas, %d minutos e %d segundos.\n", t3.hora, t3.minuto, t3.segundo);
    return 0;
}