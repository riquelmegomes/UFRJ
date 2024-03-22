#include <stdio.h>

int main(void){
    int tempo, hora, minutos, segundos;
    scanf("%d", &tempo);
    hora = tempo/3600; 
    minutos = (tempo % 3600) / 60; 
    segundos = tempo % 60;
    printf("%d:%d:%d", hora, minutos, segundos);
    return 0;
}
