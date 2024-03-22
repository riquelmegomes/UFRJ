#include <stdio.h>
   
int main() {
    FILE *pFile;
    int respos[3];
    int i;

    pFile = fopen("myfile.bin", "r" );
    if (!pFile) return 1;
    
    fread(respos, sizeof(int), 3, pFile);
    for(i = 0; i < 3; i++) {
        printf ("%d ", respos[i]);
    }
    printf("\n");
    fclose(pFile);
    return 0;
}