/*
	1. Dada uma seqüência de números inteiros não-nulos, seguida por 0,
	imprimir seus quadrados.
*/

#include <stdio.h>

int main (){
	
	int n=0;
	
	scanf("%d", & n);

	while(n!=0){

		n=n*n;
		printf("%d\n", n);
		scanf("%d", & n);

	}
}
