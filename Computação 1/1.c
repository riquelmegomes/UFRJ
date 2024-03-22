#include <stdio.h>

int main(void) {
    FILE *pFile;
    int buffer[3]= {10 , 20 , 30};
    
    pFile = fopen("myfile.bin" , "wb");
    if(!pFile) return 1;
    
    fwrite(buffer , sizeof(int) , 3, pFile);
    
    fclose(pFile) ;
    return 0;
}