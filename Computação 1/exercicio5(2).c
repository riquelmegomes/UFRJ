#include <stdio.h>

int main(void){
    short r = 5;
    double constante = 1.33333, volume = constante*3.14159*r*r*r;
    printf("Volume da esfera aproximado: %f", volume);
    return 0;
}
