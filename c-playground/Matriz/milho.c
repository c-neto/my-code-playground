#include <stdio.h>
#define MAX 100

void main (){

    int j, k, x, y, matriz[MAX][MAX];
    int ak=0, maior=0;

    printf("X: ");
    scanf("%d", & x);

    printf("Y: ");
    scanf("%d", & y);

    for (j=0 ; j<x ; j++){
        for (k=0 ; k<y ; k++){
          scanf("%d", & matriz[j][k]);
        }
    }

    j=0; k=0;

    while (j!=x) {

        for(k=0 ; k<y ; k++){
            ak+=matriz[j][k];
        }

        if(ak>maior){
            maior=ak;
        }
        ak=0;
        j++;
    }

    j=0; k=0;

    while (k!=y) {
        for(j=0 ; j<x ; j++){
            ak+=matriz[j][k];
        }

        if(ak>maior){
            maior=ak;
        }
        ak=0;
        k++;
    }

    for (j=0 ; j<x ; j++){
        for (k=0 ; k<y ; k++){
          printf("%d ", matriz[j][k]);
        }printf("\n");
    }

    printf("Maior: %d\n", maior );
}
