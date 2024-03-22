#include <stdio.h>

#define TAM 50

typedef struct _TEMPO {
    int hora, minuto, segundo;
} TEMPO;

int main(void) {
    TEMPO t[TAM];
    int i, j, temp;

    printf("Entre com 50 tempos no formato: horas minutos segundos\n");
    for(i=0; i < TAM; i++) {
        scanf("%d %d %d", &t[i].hora, &t[i].minuto, &t[i].segundo);
        t[i].segundo = t[i].segundo + (t[i].minuto*60) + (t[i].hora*3600);   /*Converte tempo t para segundos */
    }
    
    for(i=0; i < TAM-1; i++) {     /*Ordena os tempos em ordem crescente*/
        for(j=0; j < TAM-1-i; j++) {
            if(t[j].segundo > t[j+1].segundo) {
                temp = t[j].segundo;
                t[j].segundo = t[j+1].segundo;
                t[j+1].segundo = temp;
            }
        }
    }
    
    printf("Tempos em segundos e em ordem crescente:\n");
    for(i=0; i < TAM; i++) {
       printf("Tempo %d: %d segundos.\n", i+1, t[i].segundo);
    }
    return 0;
}