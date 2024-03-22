#include <stdlib.h>
#include <stdio.h>

int main (void) {
    int i, j, n, temp, *pvetor;
    
    scanf ("%d", &n);
    pvetor = (int *) malloc(n*sizeof(int));
    if(!pvetor) {
        puts("Sem memória.");
        return 1;
    }
    
    for (i = 0; i < n; i ++) {
        scanf ("%d", pvetor + i);
    }
    
    for(i=0; i < n-1; i++){
       for(j=0; j < n-1-i; j++){
           if (*(pvetor + j) > *(pvetor + j+1)){
              temp = *(pvetor + j);
              *(pvetor + j) = *(pvetor + j+1);
              *(pvetor + j+1) = temp;
           }
       } 
    }
    
    for (i=0; i < n; i++)
        printf("%d\n", *(pvetor + i));
    
    free (pvetor);
    return 0;
}