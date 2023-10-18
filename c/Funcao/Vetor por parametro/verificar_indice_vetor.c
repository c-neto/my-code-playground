#include <stdio.h>
#define MAX 100

int verifica (int vetor[], int ind, int range){

    int k, ak=0;

    for(k=0 ; k<range ; k++){
        if (vetor[ind] > vetor[k]){
        	ak++;
		}
    }
	return ak;
}

int main(){

    int k, V[MAX], N, I;

    printf("Indique o range do vetor: ");
    scanf("%d", & N);

    do{
        printf("Indique o indice a ser verificado: ");
        scanf("%d", & I);

        if(I<0 || I>N){
            printf("Indice estourou o limite do vetor\nDigite outro Indice: ");
            scanf("%d", & I);
        }

    }while(I<0 || I>N);

    printf("V[]:\n");

    for(k=0 ; k<N ; k++){
        printf("\tV[%d]: ", k);
        scanf("%d", & V[k]);
    }

    printf("%d", verifica(V,I,N) );

}
