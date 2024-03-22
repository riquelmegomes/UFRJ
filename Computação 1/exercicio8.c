#include <stdio.h>

int main(void){
    char nome[21];
    double salario, vendas, total;
    scanf("%s", nome);
    scanf("%lf", &salario);
    scanf("%lf", &vendas);
    total = (15*vendas / 100) + salario;
    printf("TOTAL = R$ %.2lf\n", total);
    return 0;
}
