#include <stdio.h>

void Converter(int decimal);

int main(void) {
    int decimal;
    
    puts("Digite um numero na base decimal.");
    scanf("%d", &decimal);
    printf("Este numero em binario eh igual a: ");
    Converter(decimal);
    return 0;
}
void Converter(int decimal) {
    int n;

    if(decimal/2 != 0) {
        n = decimal/2;
        Converter(n);
        printf("%d", decimal%2);
    }
    else printf("%d", decimal%2);
}