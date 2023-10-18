/*
	11. Dizemos que um inteiro positivo n é perfeito se for igual à soma de seus
	divisores positivos diferentes de n.
	Exemplo: 6 é perfeito, pois 1+2+3 = 6
	Dado um inteiro positivo n, verificar se n é perfeito.
*/

#include <stdio.h>
#include <conio.h>

int main(){
	int k=1, n=0, soma=0, decisao=0;	

	scanf("%d", & n);
	
	while (k!=n){
		
		if (n%k==0){
			soma+=k;
			
				if (soma==n){
					decisao=1;
					break;
				}
		}
		
		k++;
		
	}
	
	if (decisao){
		printf("%d PERFEITO", n);	
	}
	
	else{
		printf("%d NAO PERFEITO", n);
	}
	
	return 0;

}
