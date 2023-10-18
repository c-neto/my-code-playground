/*
	8. Dados n e dois números inteiros positivos i e j diferentes de 0, imprimir em
	ordem crescente os n primeiros naturais que são múltiplos de i ou de j e ou de
	ambos.
	Exemplo: Para n = 6 , i = 2 e j = 3 a saída deverá ser : 0,2,3,4,6,8.
*/

#include <stdio.h>
#include <conio.h>

int main (){
	
	int x=0, i, n, j, k=0;
	
	printf("Numero de Termos: ");
	scanf("%d", & n);
	
	printf("I: ");
	scanf("%d", & i);
	
	printf("J: ");
	scanf("%d", & j);
	
	while (x!=n){
		
		if (k%i==0 || k%j==0){
			printf("%d, ", k);
			x++;
		}				
		k++;
	}
		
}
