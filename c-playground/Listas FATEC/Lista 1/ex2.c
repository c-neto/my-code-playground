/*2. Dado um número inteiro positivo n, calcular a soma dos n primeiros
números naturais.
*/

#include <stdio.h>

int main (){
	
	int aux=0, n=0, k=1;
	
	scanf("%d", & n);

	for(k ; k<=n ; k++){
		printf("\n%d", k);
		aux+=k;
	}

	printf("\n\nResultado: %d", aux);
}
