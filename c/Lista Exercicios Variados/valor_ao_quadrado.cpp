/*
	Retorna o Valor ao quadrado
*/
#include<stdio.h>
#include<conio.h>
#include<locale.h>

int main (void)

{

	int n1,n1q;


	setlocale(LC_ALL,"");
		
	printf ("Indique um numero Inteiro: ");
	scanf ("%d", & n1);

	n1q=n1*n1;

	printf ("Valor inteiro ao Quadrado: %d", n1q);


}
