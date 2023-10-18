/*
	Soma dos Valores elevados ao quadrado
*/

#include<stdio.h>
#include<conio.h>
#include<locale.h>

int main (void)

{

	int V1,	V2,	V3, soma;
	int V1q, V2q, V3q;

	setlocale(LC_ALL,"");
		
	printf ("Indique um numero Inteiro: ");
	scanf ("%d", & V1);

	printf ("Indique outro numero Inteiro: ");
	scanf ("%d", & V2);

	printf ("Indique outro numero Inteiro: ");
	scanf ("%d", & V3);

	V1q=V1*V1;
	V2q=V2*V2;	
	V3q=V3*V3;
	
	soma = V1q+V2q+V3q;
	printf ("Valor da soma dos quadrados dos três valores lidos: %d", soma);


}
