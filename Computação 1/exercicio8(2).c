#include <stdio.h>

int main(void){
    short tempo_onibus1 = 36, tempo_onibus2 = 20;  /*tempo de percurso dos onibus em minutos*/
    short tempo_total = 15 + tempo_onibus1 + tempo_onibus2, horario_minutos = (8*60) - tempo_total;
    float horario_saida = horario_minutos/60, resto = horario_minutos % 60;
    printf("Preciso sair as %g horas e %g minutos.", horario_saida, resto);
    return 0;
}
