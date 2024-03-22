#include <stdio.h>

#define TAM 5

typedef struct _JOGADOR {
    int pontos;
    char nome[42];
} JOGADOR;

int main(void) {
    JOGADOR jogadores[TAM];
    int i;

    for(i=0; i<TAM; i++){
        printf("Digite o nome do jogador %d.\n", i+1);
        scanf("%s", &jogadores[i].nome);
        printf("Digite os pontos do jogador %d.\n", i+1);
        scanf("%d", &jogadores[i].pontos);
    }

    for(i=0; i<TAM; i++){
        printf("\nNome: %s\nPontos: %d\n", jogadores[i].nome, jogadores[i].pontos);
    }
    return 0;
}
