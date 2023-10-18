/*
	Verificar se a letra digitada é uma vogal ou não
*/

#include <stdio.h>
#include <conio.h>
#include <locale.h> //setlocale(LC_ALL,""); 
int main (){
	
	setlocale(LC_ALL,""); 
	
	char letra;
	char vogal_a = 'a', vogal_e = 'e', vogal_i = 'i', vogal_o = 'o',vogal_u ='u';
	char vogal_A = 'A', vogal_E = 'E', vogal_I = 'I', vogal_O = 'O',vogal_U ='U';
	
	printf("Digite uma letra: ");
	scanf("%c", & letra);
	
	if (letra==vogal_a || letra==vogal_e || letra==vogal_i || letra==vogal_o || letra==vogal_u || letra==vogal_A || letra==vogal_E || letra==vogal_I || letra==vogal_O || letra==vogal_U){
		
		printf("Sua letra é uma vogal");
		
	}
	
	else {
			
		printf("Sua letra é uma Consoante");
		
	}		
	
}


