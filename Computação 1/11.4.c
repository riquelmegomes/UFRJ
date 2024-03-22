#include <stdio.h>

#define TAM 10

int main (void) {
    FILE *pFile;
    float nota1[TAM], nota2[TAM], media[TAM];
    int i;

    pFile = fopen("ex3.txt" , "r");
    if(!pFile) return 1;

    for(i=0; i<TAM; i++) {
        fscanf(pFile, "%f %f", &nota1[i], &nota2[i]);  
        media[i] = (nota1[i]+nota2[i])/2;
    } 
    fclose(pFile);
    
    pFile = fopen("ex3.txt" , "w");
    if(!pFile) return 1;

    for(i=0; i<TAM; i++) {
        fprintf(pFile, "%.2f %.2f %.2f\n", nota1[i], nota2[i], media[i]);
    }
    
    fclose(pFile); 
    return 0;
}