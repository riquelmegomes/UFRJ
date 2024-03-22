#include <stdio.h>
#include <stdlib.h>

int main (void) {
    FILE *pFile;
    int i, inteiro, *vetor, quant = 0;

    pFile = fopen("arquivo.txt", "r");
    if(!pFile) return 1;
    
    fscanf(pFile, "%d", &inteiro);
    while(!feof(pFile)) {
        quant++;
        fscanf(pFile, "%d", &inteiro);
    }
    
    vetor = (int *) malloc(quant*sizeof(int));
    rewind(pFile);
    for(i=0; i<quant; i++) {
        fscanf(pFile, "%d", &inteiro);
        vetor[i] = inteiro;
    }

    for(i=quant-1; i>=0; i--) 
        printf("%d\n", vetor[i]);

    fclose(pFile);
    return 0;
}