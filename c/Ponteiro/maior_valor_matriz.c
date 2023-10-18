/*
Faça um função que recebe com entrada um inteiro n, uma matriz inteira A(nxn) e
devolve três inteiros: k, Lin e Col. O inteiro k é um maior elemento de A e é igual a
A[Lin][Col].
Obs. Se o elemento máximo ocorrer mais de uma vez, indique em Lin e Col qualquer
uma das possíveis posições
*/

#include <stdio.h>
#define MAX 100

void maior(int A[MAX][MAX], int n, int *k, int *Lin, int *Col){

	int x,y, maior=0;

	for (x=0 ; x<n ; x++){
		for(y=0 ; y<n ; y++){
			if (A[x][y] > maior){
				maior=A[x][y];
				*k=maior;
				*Lin=x;
				*Col=y;
			}
		}
	}

}

int main(){

	int matriz[MAX][MAX], x, y, n, *K, *LIN, *COL;

	printf("Indique n, da MATRIZ n/n: ");
	scanf("%d", & n);

	for (x=0 ; x<n ; x++){
		for(y=0; y<n ; y++){
			printf("Digite MATRIZ %d/%d: ", x, y);
			scanf("%d", & matriz[x][y] );
		}
	}

	maior(matriz, n, &K, &LIN, &COL);

	printf("Maior Valor: %d\nLinha: %d, Coluna: %d\n",K, LIN, COL);
}
