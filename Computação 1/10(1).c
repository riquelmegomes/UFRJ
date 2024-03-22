#include <stdio.h>
/* PARA OCORRER UMA BOA DECOFIDIÇAÇÃO OS NUMEROS NO ARQUIVO PRECISAM
SER DE 0 A 25 E ESCRITOS COM PELO MENOS UM ESPAÇO DE DISTÂNCIA */

int main(void) {
    FILE *pFile;
    int inteiro;
    char letra;

    pFile = fopen("myfile.bin", "r");
    if(!pFile) return 1;
    
    while(!feof(pFile)) {
        fscanf(pFile, "%d", &inteiro);
        if(inteiro >= 0 && inteiro <= 25) {
            switch(inteiro) {
                case 0 :
                    letra = 'A';
                    printf("%c", letra);
                break;
            
                case 1 :
                    letra = 'B';
                    printf("%c", letra);
                break;
            
                case 2 :
                    letra = 'C';
                    printf("%c", letra);
                break;
            
                case 3 :
                    letra = 'D';
                    printf("%c", letra);
                break;
            
                case 4 :
                    letra = 'E';
                    printf("%c", letra);
                break;
            
                case 5 :
                   letra = 'F';
                   printf("%c", letra);
                break;
            
                case 6 :
                   letra = 'G';
                   printf("%c", letra);
                break;
            
                case 7 :
                    letra = 'H';
                    printf("%c", letra);
                break;
            
                case 8 :
                    letra = 'I';
                    printf("%c", letra);
                break;
            
                case 9 :
                    letra = 'J';
                    printf("%c", letra);
                break;
            
                case 10 :
                    letra = 'K';
                    printf("%c", letra);
                break;
            
                case 11 :
                    letra = 'L';
                    printf("%c", letra);
                break;
            
                case 12 :
                    letra = 'M';
                    printf("%c", letra);
                break;
            
                case 13 :
                    letra = 'N';
                    printf("%c", letra);
                break;
            
                case 14 :
                    letra = 'O';
                    printf("%c", letra);
                break;
            
                case 15 :
                    letra = 'P';
                    printf("%c", letra);
                break;
            
                case 16 :
                    letra = 'Q';
                    printf("%c", letra);
                break;
            
                case 17 :
                    letra = 'R';
                    printf("%c", letra);
                break;
            
                case 18 :
                    letra = 'S';
                    printf("%c", letra);
                break;
            
                case 19 :
                    letra = 'T';
                    printf("%c", letra);
                break;
            
                case 20 :
                    letra = 'U';
                    printf("%c", letra);
                break;
            
                case 21 :
                    letra = 'V';
                    printf("%c", letra);
                break;
            
                case 22 :
                    letra = 'W';
                    printf("%c", letra);
                break;
            
                case 23 :
                    letra = 'X';
                    printf("%c", letra);
                break;
            
                case 24 :
                    letra = 'Y';
                    printf("%c", letra);
                break;
            
                case 25 :
                    letra = 'Z';
                    printf("%c", letra);
                break;
            }
        } else printf("(Numero invalido!)");
    }
    puts("\nMensagem decodificada.");
    fclose(pFile);
    return 0;
}