#include <stdio.h>
#include <string.h>

#define TAM 5

typedef struct _JOGADOR {
    int pontos;
    char nome[42];
} JOGADOR;

int main(void) {
    JOGADOR jogadores[TAM];
    int i, j, temp;
    char guarda[42];

    for(i=0; i<TAM; i++){
        printf("Digite o nome do jogador %d.\n", i+1);
        scanf("%s", &jogadores[i].nome);
        printf("Digite os pontos do jogador %d.\n", i+1);
        scanf("%d", &jogadores[i].pontos);
    }

    for(i=0; i < TAM-1; i++) {     
        for(j=0; j < TAM-1-i; j++) {
            if(jogadores[j].pontos > jogadores[j+1].pontos) {
                temp = jogadores[j].pontos;
                strcpy(guarda, jogadores[j].nome); 
                jogadores[j].pontos = jogadores[j+1].pontos;
                strcpy(jogadores[j].nome, jogadores[j+1].nome);
                jogadores[j+1].pontos = temp;
                strcpy(jogadores[j+1].nome, guarda);  
            }
        }
    }

    for(i=TAM-1; i>=0; i--){
        printf("\nNome: %s \nPontos: %d\n", jogadores[i].nome, jogadores[i].pontos);
    }
    return 0;
}