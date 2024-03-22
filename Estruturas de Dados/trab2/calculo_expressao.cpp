#include <stdio.h>
#include <string.h>
#define TAM 1000

float addsub();
float muldiv();
float term();

char expressao[TAM];
int pos = 0;

float term(){
  float n = 0;

  if(expressao[pos] == '(') {
    pos++;
    n = addsub();
    
    if(expressao[pos] == ')') {
      pos++;
      return n;
    }
  }
  else {
    while('0' <= expressao[pos] && expressao[pos] <= '9') {
      n = n*10 + (expressao[pos] - '0');
      pos++;
    }
  }
  return n;
}

float muldiv(){
  float primeiro, segundo;
  
  primeiro = term();
  for(;;) {
    if(expressao[pos] == '*') {
      pos++;
      segundo = term();
      primeiro *= segundo; 
    }
    else if(expressao[pos] == '/') {
      pos++;
      segundo = term();
      primeiro /= segundo;
    }
    else {
      return primeiro;
    }
  }
}

float addsub(){
  float primeiro, segundo;
  
  primeiro = muldiv();
  
  for(;;) {
    if(expressao[pos] == '+') {
      pos++;
      segundo = muldiv();
      primeiro += segundo; 
    }
    else if(expressao[pos] == '-') {
      pos++;
      segundo = muldiv();
      primeiro -= segundo;
    }
    else {
      return primeiro;
    }
  }
  
}

void removeEspacos(char entrada[], int tamanho) {
    int aux, i = 0;
    
    for(aux = 0; aux < tamanho; aux++) {
        if(entrada[aux] != ' ') {
            expressao[i] = entrada[aux];
            i++;
        }
    }
    expressao[i] = '\0';
}

int main() {
  int tamanho = TAM;
  char entrada[tamanho];
  
  scanf("%[^\n]", entrada);
  removeEspacos(entrada, tamanho);

  printf("%.2f\n", addsub());  
  
  return 0;
}