/*
	3. Dado um número inteiro positivo n, imprimir os n primeiros naturais
	ímpares.
	Exemplo: Para n=4 a saída deverá ser 1,3,5,7.
*/

#include <stdio.h>

int main (){
	
	int aux=0, n=1, k=1;
	
	scanf("%d", & n);

	while(k<=n){
		aux=k;
		printf("%d Termo: %d\n", k, aux+=2);
		k++;
	}
}
