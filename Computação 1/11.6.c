#include <stdio.h>

int main (void) {
    FILE *pFile;
    int i;

    pFile = fopen("arquivo.txt", "r");
    if(!pFile) return 1;
    
    fscanf(pFile, "%d", &i);
    while(!feof(pFile)) {
        printf("%d\n", i);
        fscanf(pFile, "%d", &i);
    }
    
    fclose(pFile);
    return 0;
}