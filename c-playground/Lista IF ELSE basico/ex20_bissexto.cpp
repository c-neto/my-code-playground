/*
	Ano Bissexto
*/
#include<stdio.h>
#include<conio.h>
#include <locale.h> //setlocale(LC_ALL,""); 

int main (void)
{
  
	setlocale(LC_ALL,"");
  
	int ano;
	float resto4, resto100, resto400;
	
	
	printf("Verificação de Ano Bissexto\n");
	
	printf ("Informe o Ano: ");
	scanf ("%d", & ano);

	resto4 = ano%4;
	resto100 = ano%100;
	resto400 = ano%400;
	
	if (resto4==0){
		
		if (resto100==0){
			
			if (resto400==0){
				
				printf ("Ano Bissexto \nFim do Teste");
				
			}
			
			else {
				
				printf ("Ano Normal \nFim do Teste");
				
			}
		}
		
		else{
			
			printf ("Ano Bissexto \nFim do Teste");
			
		}
	}
	
	else{
		
		printf ("Ano Normal \nFim do Teste");
		
	}
  
}
