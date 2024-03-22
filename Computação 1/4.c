#include <stdio.h>

#define TAM 3

int main(void) {
    FILE *pFile;
    double reais[TAM];
    int i;

    pFile = fopen("reais.bin", "rb");
    if(!pFile) return 1;
    
    fread(reais, sizeof(double), 3, pFile);
    for(i = 0; i < TAM; i++) 
        printf ("%lf ", reais[i]);

    return 0;
}