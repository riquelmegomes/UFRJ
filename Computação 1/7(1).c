#include <stdio.h>
#include <stdlib.h>

int maior(int vetor[], int a, int b) {
    int meio, x, y;
    
    if (a == b) return vetor[a]; 
    else {
        meio = (a+b)/2;
        x = maior(vetor, a, meio);
        y = maior(vetor, meio+1, b);
    }
    if(x>y) return x;
    else return y;
}

int main(void) {
    int i, tamanho, *vetor;
 
    puts("Digite quantos elementos o vetor.");
    scanf("%d", &tamanho);
    vetor = (int *) malloc(tamanho*sizeof(int));
    
    puts("Digite os elementos do vetor.");
    for (i=0; i < tamanho; i++) 
        scanf("%d", &vetor[i]);
    
    printf("O maior elemento deste vetor eh: %d", maior(vetor, 0, tamanho-1));
    free(vetor);
    return 0;
}
