#include <stdio.h>

#define TAM 10

int main (void) {
    FILE *pFile;
    int i, num;

    pFile = fopen("arquivo.txt", "a");
    if(!pFile) return 1;
    
    for(i=0; i<TAM; i++) {
        scanf("%d", &num);
        fprintf(pFile, "\n%d", num);
    }

    fclose(pFile);
    return 0;
}