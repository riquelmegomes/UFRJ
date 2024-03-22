#include <stdio.h>

typedef struct {
    float nota1, nota2;
} nota;

#define TAM 10

int main (void) {
    FILE *pFile;
    nota nota_alunos;
    char nomeArq[21];
    int i;
 
    puts("Digite o nome do arquivo.");
    scanf("%s", nomeArq);

    pFile = fopen(nomeArq , "w");
    if(!pFile) return 1;

    for(i=0; i<TAM; i++) {
        printf("Entre com as notas do aluno %d\n", i+1);
        scanf("%f %f", &nota_alunos.nota1, &nota_alunos.nota2);
        fprintf(pFile, "%.2f %.2f\n", nota_alunos.nota1, nota_alunos.nota2);
    }
    
    fclose(pFile);
    return 0;
}