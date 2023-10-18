/*
	Retorna maior de tres valores
*/

#include<stdio.h>
#include<conio.h>
#include<locale.h>

int main (void)

{
	int n1,	n2, n3;

	setlocale(LC_ALL,"");
		
	printf ("Indique um numero Inteiro: ");
	scanf ("%d", & n1);
	
	printf ("Indique um numero Inteiro: ");
	scanf ("%d", & n2);
	
	printf ("Indique um numero Inteiro: ");
	scanf ("%d", & n3);

	if (n1 > n2 && n2 > n3){
		
		printf ("Maior valor inserido: %d \n", n1);
		printf ("Menor valor inserido: %d \n", n3);	
	}
	
	else if (n1 > n3 && n3 > n2){
	
		printf ("Maior valor inserido: %d \n", n1);
		printf ("Menor valor inserido: %d \n", n2);
		
	}
	
		
	else if (n2 > n3 && n3 > n1){
		
		printf ("Maior valor inserido: %d \n", n2);
		printf ("Menor valor inserido: %d \n", n1);
		
	}
	

	else if (n2 > n1 && n1 > n3){
	
		printf ("Maior valor inserido: %d \n", n2);
		printf ("Menor valor inserido: %d \n", n3);
		
	}
	
	
	else if (n3 > n2 && n2 > n1){
		
		printf ("Maior valor inserido: %d \n", n3);
		printf ("Menor valor inserido: %d \n", n1);
		
	}
	

	else if (n3 > n1 && n1 > n2){
	
		printf ("Maior valor inserido: %d \n", n3);
		printf ("Menor valor inserido: %d \n", n2);
		
	}
	

}
