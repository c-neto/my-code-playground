/*
	retorna antecessor sucessor
*/

#include<stdio.h>
#include<conio.h>
#include<locale.h>

int main (void)

{
	int V1,	V2, antes, depois;

	setlocale(LC_ALL,"");
		
	printf ("Indique um numero Inteiro: ");
	scanf ("%d", & V1);

	antes=V1-1;
	printf ("\nO antecessor do Número indicado é: %d", antes);

	depois=V1+1;
	printf ("\nO sucessor do Número indicado é: %d", depois);

}
