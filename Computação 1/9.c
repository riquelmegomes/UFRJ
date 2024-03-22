#include <stdio.h>

typedef struct _JOGADOR {
    char nome[40];
    int recorde;
} JOGADOR;

int main (void) {
    FILE *pFile;
    JOGADOR recordistas[3];
    int i;

    pFile = fopen("estruturas.bin", "rb");
    if(!pFile) return 1;

    fread(recordistas, sizeof(JOGADOR), 3, pFile);
    for(i=0; i<3; i++) {
        printf("%s ", recordistas[i].nome);
        printf("%d\n", recordistas[i].recorde);
    }

    fclose(pFile);
    return 0;
}

    