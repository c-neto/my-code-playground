/*
	10. Dado um inteiro positivo p, verificar se p é primo.
*/

#include <stdio.h>
#include <conio.h>

int main(){
	
	int p, ak=0, k=1, op=1;
	
	do{
		scanf("%d", & p);
			
		if(p<1){ 
			printf("Valores negativos nao permitidos, indique outro valor: "); 
		}
		
	} while(p<1);
		
	for (k ; k<=p ; k++){
		if (!(p%k)) {
			printf("Divisivel por: %d\n", k);
			ak+=1;
		}	
	}
		
	if (ak>2){
		printf("NAO PRIMO\n\n");
	}
			
	else{
		printf("PRIMO");
	}
	
}

