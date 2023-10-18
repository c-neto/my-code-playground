#include <stdio.h>
#define MAX 100

void prod_matriz(int matriz[MAX][MAX], int N, int *DP, int *DS, int *D){

    int x, y, aux=N, dp=1, ds=1, d=0;

    for (x=0 ; x<N ; x++){
        for (y=0 ; y<N ; y++){
            if (x==y){
                dp*=matriz[x][y];
            }

            if (y==aux-1){
                ds*=matriz[x][y];
            }
        }
        aux--;
    }

    if(dp==ds){
        d=1;
    }

    *D=d;
    *DP=dp;
    *DS=ds;

}

void main (){

    int n, x, y, matriz[MAX][MAX];
    int dp, ds, d;

    printf("N: ");
    scanf("%d", & n);

    for (x=0 ; x<n ; x++){
        for (y=0 ; y<n ; y++){
          scanf("%d", & matriz[x][y]);
        }
    }

    prod_matriz(matriz, n, &dp, &ds, &d);

    for (x=0 ; x<n ; x++){
        for (y=0 ; y<n ; y++){
          printf("%d ", matriz[x][y]);
        }printf("\n");
    }

    printf("Diagonal Principal: %d\n", dp );
    printf("Diagonal Secundaria: %d\n", ds );
    printf("Igual: %d", d);
}
