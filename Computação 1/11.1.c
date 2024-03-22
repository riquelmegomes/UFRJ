#include <stdio.h>

int main (void) {
    FILE *pFile;
    float real;

    pFile = fopen("ex1.txt" , "w");
    if(!pFile) return 1;

    printf("Entre com um numero real:\n");
    scanf("%f", &real);
    
    fprintf(pFile, "%.1f", real);
    
    fclose(pFile);
    return 0;
}