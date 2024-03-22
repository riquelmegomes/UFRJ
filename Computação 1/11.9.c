#include <stdio.h>

int main(int argc, char *argv[]) {
    FILE *pa;
    char *nome = "texto2.txt";
    char c;

    pa = fopen(nome, "r");
    if(!pa) {
        printf("Erro ao abrir %s\n", nome);
        return 1;
    }

    while(1) {
        c = fgetc(pa);
        if(c == EOF) break;
        putchar(c);
    }

    fclose(pa);
    return 0;
}