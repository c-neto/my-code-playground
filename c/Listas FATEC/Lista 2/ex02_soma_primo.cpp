/*
	2. Escreva uma função que leia um inteiro não-negativo n e imprima a soma dos n primeiros números primos.
*/

#include <stdio.h>

int primo(int fim){
	
	int k=1, kk=1, ak=0, sum_primo=0;
	
	while (k<=fim){
		
		for (kk=1 ; kk<=k ; kk++){
			if (!(k%kk)) {
				ak+=1;
			}	
		}
			
		if(ak>2){
			printf("%d NAO PRIMO\n", k);
			
		}
		else{
			sum_primo+=k;
			printf("%d PRIMO\n", k);
		}
		k++;
		ak=0;
	}
	return sum_primo;
	
}

int main(){
	
	int m, dec;
	
	do{
		printf("Verificar a soma dos primos de 0 a: ");
		scanf("%d", & m);
			
		if(m<1){ 
			printf("Valores negativos nao permitidos, indique outro valor: "); 
		}

	} while(m<1);
	
	printf("\nSoma dos primos de 0 a %d = %d\n", m, primo(m));
	
}
