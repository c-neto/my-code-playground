/*
	9. Dizemos que um número natural é triangular se ele é produto de três
	números naturais consecutivos.
	Exemplo: 120 é triangular, pois 4.5.6 = 120.
	Dado um inteiro não-negativo n, verificar se n é triangular.
*/

#include <stdio.h>
#include <conio.h>

int main(){
	int k=1, n=0, soma=0, decisao=0;	

	scanf("%d", & n);
	
	while (k!=n){
		
		if (n%k==0){
			if (k*(k+1)*(k+2) ==n) {
				decisao=1;
				break;
				}
		}
		
		k++;
		
	}
	
	if (decisao){
		printf("%d TRIANGULAR", n);	
	}
	
	else{
		printf("%d NAO TRIANGULAR", n);
	}
	
	return 0;

}
