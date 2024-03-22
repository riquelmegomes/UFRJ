#include <stdio.h>

int main(void){
    double A, B, C, MEDIA;
    scanf("%lf", &A);
    scanf("%lf", &B);
    scanf("%lf", &C);
    MEDIA = (2*A + 3*B + 5*C) / 10;
    printf("MEDIA = %.1lf\n", MEDIA);
    return 0;
}