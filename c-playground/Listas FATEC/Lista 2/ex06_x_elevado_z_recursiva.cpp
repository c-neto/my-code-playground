#include <stdio.h>
/*
	1-Escreva uma função recursiva que recebe, por parâmetro, dois valores X e Z e calcula e retorna X elevado a Z. (sem utilizar funções prontas).
*/

int recursiva(int base, int exp, int base_fixa){
	
	printf("Base: %d\n", base);
	printf("Expoente: %d\n\n", exp);
	
	if(exp==0){
		return 1;
	}
	
	else if (exp==1){
		return base;
	}
	
	else{
		base*=base_fixa;	
		exp-=1;	
		recursiva (base, exp, base_fixa);	
	}
	
}

int main(){

	int X=0, Z=0;
	
	printf("Digite a BASE: ");
	scanf("%d", & X);
	
	printf("Digite o EXPOENTE: ");
	scanf("%d", & Z);
	
	printf("%d", recursiva(X,Z,X) );
	
}
