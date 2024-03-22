#include <stdio.h>

int main(void){
    double A, B, MEDIA;
    scanf("%lf", &A);
    scanf("%lf", &B);
    MEDIA = (3.5*A + 7.5*B) / 11;
    printf("MEDIA = %.5lf\n", MEDIA);
    return 0;
}
