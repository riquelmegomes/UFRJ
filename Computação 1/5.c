#include<stdio.h>

int main(void) {
    FILE *pFile;
    int respos[3], i, novoValor = 5, posicao;

    puts("Informe a posicao do numero a ser substituido.");
    scanf("%d", &posicao);
    
    /* abre arquivo para leitura e escrita */
    pFile = fopen("myfile.bin", "r+");
    if(!pFile) return 1;

    /* lê o que está escrito no arquivo */
    fread(respos, sizeof(int), 3, pFile);
    for(i=0; i<3; i++) 
        printf("%d ", respos[i]);
    printf("\n");

    /* pula "x" inteiros a partir do inicio e vai para a posicao a ser substituida */
    fseek(pFile, posicao*sizeof(int), SEEK_SET);

    /* escreve um novo valor na posição do segundo inteiro */
    fwrite(&novoValor, sizeof(int), 1, pFile);
    printf("Novo valor: %d\n", novoValor);

    /* volta para o inicio do arquivo */
    fseek(pFile, 0, SEEK_SET); /*ou rewind também serve */

    /* le os novos valores */
    fread(respos, sizeof(int), 3, pFile);
    for(i=0; i<3; i++) 
        printf("%d ", respos[i]);
    printf("\n");
    
    fclose(pFile);
    return 0;
}