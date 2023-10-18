/*
	media invalida, aprovado por conselho ...
*/
#include<stdio.h>
#include<conio.h>
#include <locale.h> //setlocale(LC_ALL,""); 

int main (void)
{
  
	setlocale(LC_ALL,""); 
  
 	float n1, n2, n3, mf;
  
 	printf ("Informe a NOTA 1: ");
  	scanf ("%f", & n1);
  	
  	printf ("Informe a NOTA 2: ");
  	scanf ("%f", & n2);
  	
  	printf ("Informe a NOTA 2: ");
  	scanf ("%f", & n3);
  	
  	mf=(n1+n2)/2;

	if (mf>=7 && mf<10){
		
		printf ("Você está APROVADO, sua média final é: %.2f", mf);
		printf ("\nMédia final superior a 7");
	}
	
	else if (mf<7){
	
		printf ("Você está REPROVADO, sua média final é: %.2f", mf);
		printf ("\nMédia final não superior a 7");

	}
	
	else if (mf==10){
	
		printf ("Parabéns, Você foi APROVADO COM DISTINÇÃO, sua média final é de %.2f", mf);

	}
		
	else{
		
		printf ("Média invalida: %.2f", mf);
		printf ("\nA média das notas excederam o valor 10, ", mf);		
	}
  
}
