#include <stdio.h>

int main(void){
    int numero, horas;
    float valor_por_hora, salario;
    scanf("%d", &numero);
    scanf("%d", &horas);
    scanf("%f", &valor_por_hora);
    salario = horas*valor_por_hora;
    printf("NUMBER = %d\nSALARY = U$ %.2f\n", numero, salario);
    return 0;
}
