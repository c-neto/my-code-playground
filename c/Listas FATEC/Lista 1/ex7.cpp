/*
	7. Dado um inteiro não-negativo n, determinar n!
*/

#include <stdio.h>
#include <conio.h>

int main(){
	
	int k=1, n=0, f=1;
	
	printf("Digite o numero a ser Fatorado: ");
	scanf("%d", & n);
	for(k; k<=n ; k++){
		f*=k;	
	}
	printf("%d!=%d", n,f);
	
}
