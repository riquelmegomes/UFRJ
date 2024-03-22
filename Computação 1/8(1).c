#include <stdio.h>
#include <string.h>

int verificaPalindromo(int num, char string[]);

int main(void) {
    int tamanho, i, j = 0;
    char string[100], string_limpa[100];
    
    printf("Digite uma frase.\n");
    scanf("%[^\n]", string);
    tamanho = strlen(string);

    /* AQUI SÓ É CONSIDERADO PARA A STRING LETRAS DO ALFABETO */
    for(i=0; i < tamanho; i++) {
        if((string[i] >= 'A' && string[i] <= 'Z') || (string[i] >= 'a' && string[i] <= 'z')) {
            string_limpa[j] = string[i];
            j++;
        }
    }

    if(verificaPalindromo((j-1), string_limpa) == 1)
        puts("A frase armazenada eh um palindromo.");
    else
        puts("A frase armazenada nao eh um palindromo.");
    
    return 0;
}
/* FUNÇÃO QUE VERIFICA SE A STRING É UM PALINDROMO */
int verificaPalindromo(int num, char string[]) {
    static int contador = 0;
    
    if(num < 1) return 1;
    if(string[num] == string[contador]) {
        if((num == contador) || (contador > num/2)) return 1;
        else {
            contador += 1;
            num -= 1;
            return verificaPalindromo(num, string);
        }
    }
    return 0;
}