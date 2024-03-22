#include <stdio.h>

int main(void){
    int hora = 8, minuto = 30, segundo = 15, tempo_total_segundos = hora*3600 + minuto*60 + segundo, distancia = 765375;
    double velocidade_media = (distancia/tempo_total_segundos)*2.23694; 
    printf("Passaram-se %d segundos desde a meia-noite.\n", tempo_total_segundos);
    printf("Velocidade media de: %.4f mph.\n", velocidade_media);
    return 0;
}
