#include<stdio.h>
#include<string.h>
#include<stdlib.h>

typedef struct _tno{
    int chave;
    struct _tno *prox;
} tno;

void insere(tno** ptlista, int x){
    tno *novo;
    novo = (tno*) malloc(sizeof(tno));
    if (novo != NULL){
        novo->chave = x;
        novo->prox = (*ptlista);
        (*ptlista) = novo;
    }
}

int main(void) {
    int i;
    int vertices, arestas;
    int *grau_vertices, *vetor_ordem;
    int pos, numLido, numChars;
    char *linha = NULL;
    size_t tam_linha = 0;
    tno **lista;

    // Recebe quantidade de vértices e arestas
    scanf("%d %d\n", &vertices, &arestas);

    lista = (tno**) malloc((vertices + 1)*(sizeof(tno*)));
    grau_vertices = (int *) malloc((vertices + 1)*(sizeof(int)));
    vetor_ordem = (int *) malloc((vertices + 1)*(sizeof(int)));

    // Inicializa os vetores
    for(i = 1; i <= vertices; i++) {
        grau_vertices[i] = 0;
        vetor_ordem[i] = 0;
        lista[i] = NULL;
    }

    for(i = 1; i <= vertices; i++) {
        getline(&linha, &tam_linha, stdin);
        pos = 0;
        numLido = 0;
        numChars;

        while(sscanf(&linha[pos], "%d %n", &numLido, &numChars) > 0) {
            pos += numChars;
            if(strlen(linha) != 0) {
                insere(&lista[i], numLido);
                grau_vertices[numLido]++;    // Contabiliza o grau de entrada de cada vértice
            }
        }
    }

    pos = 1;
    // Adiciona os vértices com grau zero no vetor_ordem 
    for(i = 1; i <= vertices; i++) {
        if(grau_vertices[i] == 0) {
            vetor_ordem[pos] = i;
            pos++;
        }
    }

    // Atualiza o grau dos vértices
    for(i = 1; i <= vertices; i++){
        tno *pt;
        pt = lista[vetor_ordem[i]];
        
        while(pt != NULL){
            grau_vertices[pt->chave]--;
            if(grau_vertices[pt->chave] == 0){
                vetor_ordem[pos] = pt->chave;
                pos++;
            }
            pt = pt->prox;
        }
    }
    
    // Imprime o vetor com a ordenação topológica 
    for(i = 1; i <= vertices; i++){
        printf("%d ", vetor_ordem[i]);
        tno *pt = lista[i];
        
        while(pt != NULL){
            pt = pt->prox;
            lista[i] = pt;
        }
    }

    return 0;
}