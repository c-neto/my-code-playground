/*
	4. Dados um inteiro x e um inteiro não-negativo n, calcular 
	x elevado a n.
*/

#include <stdio.h>

int main (){
	
	int k=0, r=1, x=0, n=0;

	scanf("%d", & x);
	scanf("%d", & n);
	
	if(n==0){
		x=1;
	}	
	while (k<n){
		r=r*x;
		k++;
	}

	printf("Resultado: %d", r);
}	
