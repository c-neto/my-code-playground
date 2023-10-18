#include <stdio.h>
#include <conio.h>

int main (){
	
	char s, masc = 'm', Masc = 'M', femi = 'f', Femi = 'F';

	printf("Idique a letra inicial de um sexo: ");
	scanf("%c", & s);
	
	if (s==masc || s==Masc){
		
		printf("Masculino");
		
	}
	
	else if (s==Femi || s==femi){
			
		printf("Feminino");
		
	}		
	
}


