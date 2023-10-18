/*
	2. Faça um Programa que peça um valor e mostre na tela se o valor é positivo ou
*/
#include<stdio.h>
#include<conio.h>
#include <locale.h> //setlocale(LC_ALL,""); 

int main (void)
{
  
	setlocale(LC_ALL,"");  

 	int n;
  
 	printf ("Informe um Valor: ");
  	scanf ("%d", & n);
  	
  	
	if (n<0){
		
		n=n*-1;
		printf ("Valor NEGATIVO: %d", n);

	}
	
	else{
		
		printf ("Valor POSITIVO: %d", n);
				
	}	
	
}
