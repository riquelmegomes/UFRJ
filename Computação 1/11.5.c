#include <stdio.h>

typedef struct {
    char nome[81];
    float nota;
} nota;

#define TAM 10

int main (void) {
    FILE *pFile;
    nota turma;
    int i;
     
    pFile = fopen("ex6.txt" , "w");
    if(!pFile) return 1;

    for(i=0; i<TAM; i++) {
        printf("Nome do aluno %d:\n", i+1);
        gets(turma.nome);
        printf("Entre com a nota de %s:\n", turma.nome);
        scanf("%f", &turma.nota);
        fprintf(pFile, "%s %.2f\n", turma.nome, turma.nota);
        setbuf(stdin, NULL);
    }

    fclose(pFile); 
    return 0;
}

