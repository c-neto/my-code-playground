/*
	6. Dados n e uma seqüência de n números inteiros, determinar a soma dos
	números pares.
*/

#include <stdio.h>
#include <conio.h>

int main(){
	int k=0, n=0, numero=0, soma=0;
	
	printf("Digite a quantidade de termos");
	scanf("%d", & n) ;
	
	for (k; k<n ; k++){
		printf("Digite um numero: ");
		scanf("%d", & numero);
		
		if(numero%2==0){
			printf("NUMERO PAR\n");
			soma+=numero;			
		}
		
	}
	printf("Soma dos Pares: %d", soma);
}
