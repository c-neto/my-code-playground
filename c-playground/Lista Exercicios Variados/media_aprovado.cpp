/*
	Media >6 Aprovado
*/

#include<stdio.h>
#include<conio.h>
#include <locale.h> //setlocale(LC_ALL,""); 

int main (void)
{
  
	setlocale(LC_ALL,""); 
  
 	float n1, n2, n3, n4, mf;
  
 	printf ("Informe a NOTA 1: ");
  	scanf ("%f", & n1);
  	
  	printf ("Informe a NOTA 2: ");
  	scanf ("%f", & n2);
  	
  	printf ("Informe a NOTA 3: ");
  	scanf ("%f", & n3);
  	
  	printf ("Informe a NOTA 4: ");
  	scanf ("%f", & n4);
  
	mf=(n1+n2+n3+n4)/4;

	if (mf>=6){
		
		printf ("Parabéns, Você está APROVADO, sua média final é de %.2f", mf);
		printf ("\nMédia final superior a 6", mf);
	}
	
	else{
		
		printf ("Você está REPROVADO: %.2f", mf);
		printf ("\nInfelizmente sua média final não foi superior a 6", mf);		
	}
  
}
