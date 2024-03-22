#include <stdlib.h>
#include <stdio.h>

int main (void) {
    int n=0, *vetor;
    
    while(1) {
        vetor = (int *) malloc(n);
        if(!vetor) {
            printf("Maior segmento: %d\n", n);
            puts("Nao consigo mais alocar memoria.");
            return 1;
        }
        else {
            printf("%d\n", n);
            free(vetor);
            n += 1000000;
        }
    }
    return 0;
}