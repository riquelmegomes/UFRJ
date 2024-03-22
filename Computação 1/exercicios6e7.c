#include <stdio.h>

int main(void){
    short Celsius = 28; 
    float Fahrenheit = (9*Celsius)/5 + 32, Kelvin = Celsius + 273.15;
    printf("Temperatura em graus Fahrenheit: %g\n", Fahrenheit);
    printf("Temperatura em Kelvin: %g", Kelvin);
    return 0;
}
