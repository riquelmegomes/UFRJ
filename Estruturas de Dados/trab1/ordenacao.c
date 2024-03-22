#include <stdio.h>
#include <stdbool.h>
#include <string.h>
#include <stdlib.h>
#include <time.h>
#define INICIO 0
#define RAND_MAX 1001

int* bubbleSort(int *lista, int tam) {
    int i = 0;
    int temp;
    bool trocou = true;
    
    while(i < tam - 1 && trocou) {
        trocou = false;

        for(int j = 0; j < tam - i - 1; j++) {

            if(lista[j] > lista[j + 1]) {
                temp = lista[j];
                lista[j] = lista[j + 1];
                lista[j + 1] = temp;
                trocou = true;
            }
        } 
    }
    
    return *(&lista);
}

void merge(int *lista, int inicio, int meio, int fim) {
    int *aux;
    int i = inicio, j = meio;
    int k = 0;
    aux = (int*)malloc((fim - inicio) * sizeof(int));

    while (i < meio && j < fim) {
        if (lista[i] <= lista[j])  aux[k++] = lista[i++];
        else aux[k++] = lista[j++];
    }
    while (i < meio) {
        aux[k++] = lista[i++];
    }
    while (j < fim) {
        aux[k++] = lista[j++];
    }         
    for (i = inicio; i < fim; ++i) {
        lista[i] = aux[i - inicio];
    }
    
    free(aux);
}
int* mergeSort(int *lista, int inicio, int fim) {
    if(fim - inicio <= 1) {
        return *(&lista);
    }

    int meio = (inicio + fim) / 2;
    mergeSort(lista, inicio, meio);
    mergeSort(lista, meio, fim);
    merge(lista, inicio, meio, fim);
    
    return *(&lista);
}

int particiona(int *lista, int inicio, int fim) {
    int i, j, pivot, temp;
    
    pivot = lista[fim];
    i = inicio;
    
    for(int j = inicio; j < fim; j++) { 
        if(lista[j] <= pivot) {
            temp = lista[j];
            lista[j] = lista[i];
            lista[i] = temp;
            i++;
        }   
    }
    temp = lista[fim];
    lista[fim] = lista[i];
    lista[i] = temp;

    return i;
}
int* quickSort(int *lista, int inicio, int fim) {
    int pospivot;
    
    if(inicio < fim) {
        pospivot = particiona(lista, inicio, fim);
        quickSort(lista, inicio, pospivot-1);
        quickSort(lista, pospivot+1, fim);
    }
    return *(&lista);
}


int main(int argc, char *argv[]) {
    int tam = atoi(argv[2]);  // tamanho da lista a ser ordenada
    char* tipo = argv[3];  // tipo de algoritmo de ordenação ((null): bubbleSort, -m: mergeSort, -q: quickSort)
    bool ordenou = true;

    // Gerando a lista que ira conter 'tam' inteiros aleatórios
    int *lista = (int*)malloc(tam * sizeof(int));
    srand(time(NULL));
    for(int i = 0; i < tam; i++)  lista[i] = rand() % RAND_MAX;  // gera inteiros de 0 até (RAND_MAX - 1)


    if(argc == 3)  *(&lista) = bubbleSort(lista, tam);   // BUBBLE SORT
    else if(argc >= 4) {
        if( !(strcmp(tipo, "-m")) )   *(&lista) = mergeSort(lista, INICIO, tam);    // MERGE SORT
        else if( !(strcmp(tipo, "-q")) )   *(&lista) = quickSort(lista, INICIO, tam-1);  // QUICK SORT
        else {
            printf("ERRO: Parametro invalido!");
            ordenou = false;
        }    
    }
    else {
        printf("ERRO: Numero de parametros invalido!");
        ordenou = false;
    }    

    // printa lista ordenada
    if(ordenou) {
        for(int i = 0; i < tam; i++)  printf("%d ", lista[i]);
    }

    free(lista);
    return 0;
} 