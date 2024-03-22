#include <stdio.h>

int main (void) {
    FILE *pFile;
    float reais[2];

    pFile = fopen("ex2.txt" , "w");
    if(!pFile) return 1;

    printf("Entre com o primeiro numero real:\n");
    scanf("%f", &reais[0]);
    printf("Entre com o segundo numero real:\n");
    scanf("%f", &reais[1]);

    
    fprintf(pFile, "%.1f ", reais[0]);
    fprintf(pFile, "%.1f", reais[1]);
    
    fclose(pFile);
    return 0;
}