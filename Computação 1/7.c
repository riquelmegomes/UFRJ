#include <stdio.h>

int main(void) {
    FILE *pFile;
    long tamanho;

    pFile = fopen("ex1.bin", "rb");
    if(!pFile) return 1;
    
    fseek(pFile, 0, SEEK_END);
    tamanho = ftell(pFile);
    fclose(pFile);
    printf("Tamanho do arquivo: %ld bytes.\n");
    return 0;
}