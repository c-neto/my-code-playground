/*
	3. Faça uma função que recebe, por parâmetro, um valor inteiro e positivo e retorna o número de divisores desse valor.
*/

#include <stdio.h>
#include <conio.h>


int primo(int m){
	
	int ak=0, k=1, op=1;
			
	for (k ; k<=m ; k++){
		if (!(m%k)) {
			printf("Divisivel por: %d\n", k);
			ak+=1;
		}	
	}
		

	return ak;	
	
}

int main(){
	
	int m, dec;
	
	do{
		scanf("%d", & m);
			
		if(m<1){ 
			printf("Valores negativos nao permitidos, indique outro valor: "); 
		}

	} while(m<1);
	
	printf( "%d", primo(m) );
	
}
