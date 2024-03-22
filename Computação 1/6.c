/* ftell example : getting size of a file */
#include <stdio.h>

int main(void) {
    FILE *pFile;
    long size;

    pFile = fopen("myfile.bin", "rb");
    if(pFile==NULL)
        perror("Error opening file.");
    else {
        fseek(pFile, 0, SEEK_END); /*go to the end of file */
        size = ftell(pFile);
        fclose(pFile);
        printf("Size of myfile.txt: %ld bytes.\n");
    }
    return 0;
}