#include <stdio.h>
#include <math.h>

typedef struct {
    float x, y;
} PONTO;

typedef struct {
    float raio;
    PONTO centro;
} CIRCUNFERENCIA;

int main(void) {
    PONTO p1;
    CIRCUNFERENCIA c1;
    float distancia;

    printf("Entre com as coordenadas do ponto p1.\n");
    scanf("%f %f", &p1.x, &p1.y);
    printf("Entre com as coordenadas do centro da circunferencia c1.\n");
    scanf("%f %f", &c1.centro.x, &c1.centro.y);
    printf("Entre com o raio da circunferencia.\n"); 
    scanf("%f", &c1.raio); 
    printf("Dados lidos.\n");
    
    distancia = sqrt(pow(c1.centro.x - p1.x,2) + pow(c1.centro.y - p1.y,2));
    if (distancia == c1.raio)
        printf("O ponto esta contido na circunferencia.\n");
    else 
        printf("O ponto nao esta contido na circunferencia.\n");
    return 0;
}