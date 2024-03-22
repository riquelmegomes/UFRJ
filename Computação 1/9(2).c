#include <stdlib.h>
#include <stdio.h>

int main (void) {
    int i, n, *pvetor, contador = 0;
    float soma = 0.0, media = 0.0;
    
    scanf ("%d", &n);
    pvetor = (int *) malloc(n*sizeof(int));
    if(!pvetor) {
    puts("Sem memória.");
    return 1;
    }
    
    for (i = 0; i < n; i++) {
        scanf ("%d", pvetor + i);
    }
    for (i = 0; i < n; i++) {
        soma += *(pvetor + i);
    }
    media = soma/n;
    for (i = 0; i < n; i++) { 
        if (*(pvetor + i) > media)
            contador++;
    }
    
    printf ("Media: %f\n", media);
    printf ("%d numeros sao maiores do que a media.\n", contador);
    free (pvetor);
    return 0;
}