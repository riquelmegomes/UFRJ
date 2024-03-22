#include <stdio.h>

#define TAM 100

double* inverteVetor(int num, double vetor[]) {
    double guarda;
    static int contador = 0;

    if(num <= contador) return vetor;
    else { 
        guarda = vetor[num];
        vetor[num] = vetor[contador];
        vetor[contador] = guarda;
        contador++;
        return inverteVetor(--num, vetor); 
    }
}

int main(void) {
    int i;
    double vetor[TAM];
    
    for(i=0; i<TAM; i++) {
        printf("Digite um numero real para a posicao %d do vetor.\n", i+1);
        scanf("%lf", &vetor[i]);
    }

    inverteVetor(TAM-1, vetor);
    puts("\nOrdem invertida!");
    for(i=0; i<TAM; i++) 
        printf("Posicao %d: %.2lf\n", i+1, vetor[i]);
    return 0;
}