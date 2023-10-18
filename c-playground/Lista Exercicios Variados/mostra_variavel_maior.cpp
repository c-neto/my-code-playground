/*
	Variável Maior
*/

#include<stdio.h>
#include<conio.h>
#include <locale.h> //necessário para usar setlocale

int main (void)
{
  
	setlocale(LC_ALL,"");
	int a, b;
  
  	printf ("Informe um Valor: ");
  	scanf ("%d", & a);
  
 	printf ("informe outro Valor: ");
    scanf ("%d", & b);
    
	if (a>b){
		
		printf ("O Valor maior idicado é: %d", a);
		
	}
	
	else{
		
		printf ("O Valor maior idicado é: %d", b);
		
	}
  
}
