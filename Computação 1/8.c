#include <stdio.h>

typedef struct _JOGADOR {
    char nome[40];
    int recorde;
} JOGADOR;

int main (void) {
    FILE *pFile;
    JOGADOR recordistas[3];
    int i;

    pFile = fopen("estruturas.bin", "wb");
    if(!pFile) return 1;

    for(i=0; i<3; i++) {
        printf("Nome do jogador %d(so um nome!!!)\n", i+1);
        scanf("%s", recordistas[i].nome);
        printf("Recorde do jogador %d:\n", i+1);
        scanf("%d", &recordistas[i].recorde);
    }
    
    fwrite(recordistas, sizeof(JOGADOR), 3, pFile);
    fclose(pFile);
    return 0;
}