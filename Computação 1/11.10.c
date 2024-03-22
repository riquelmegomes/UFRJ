#include <stdio.h>

int main (void) {
    FILE *pa, *pFile;
    char *nome = "ex6.txt";
    char c, nomeArq[21];    
    
    puts("Digite o nome do novo arquivo.");
    scanf("%s", nomeArq);
    
    pa = fopen(nome, "r");
    if(!pa) {
        printf("Erro ao abrir %s\n", nome);
        return 1;
    }
    
    pFile = fopen(nomeArq, "w");
    if(!pFile) {
        printf("Erro ao abrir %s\n", nomeArq);
        return 1;
    }

    while(1) {
        c = fgetc(pa);
        if(c == EOF) break;
        fputc(c, pFile);
    }

    fclose(pa);
    fclose(pFile);
    return 0;
}