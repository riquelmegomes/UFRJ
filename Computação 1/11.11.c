#include <stdio.h>

int main (void) {
    FILE *pFile1, *pFile2;
    char *nome1 = "arq1.txt", *nome2 = "arq2.txt";
    char somente_nome[21];
    int num;
   
    pFile1 = fopen(nome1, "r");
    if(!pFile1) {
        printf("Erro ao abrir %s\n", nome1);
        return 1;
    }
   
    pFile2 = fopen(nome2, "w");
    if(!pFile2) {
        printf("Erro ao abrir %s\n", nome2);
        return 1;
    }

    while(!feof(pFile1)) {
        fscanf(pFile1, "%[^-1234567890] %d\n", somente_nome, &num);
        fprintf(pFile2, "%d %s\n", num, somente_nome);
    }

    fclose(pFile1);
    fclose(pFile2);
    return 0;
}