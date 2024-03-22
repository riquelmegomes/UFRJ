#include <stdio.h>

#define TAM 3

int main(void) {
    FILE *pFile;
    double reais[TAM];
    int i;

    puts("Digite 3 numeros reais.");
    for(i=0; i<TAM; i++)
        scanf("%lf", &reais[i]);

    pFile = fopen("reais.bin", "wb");
    if(!pFile) return 1;
   
    fwrite(reais , sizeof(double) , 3, pFile);
    
    fclose(pFile);
    return 0;
}