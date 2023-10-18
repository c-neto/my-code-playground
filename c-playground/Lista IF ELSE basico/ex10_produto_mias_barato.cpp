/*
	10. Faça um programa que pergunte o preço de três produtos e informe qual produto
	mais barato
*/

#include<stdio.h>
#include<conio.h>
#include<locale.h>

int main (void)

{
	int n1,	n2, n3;

	setlocale(LC_ALL,"");
		
	printf ("Informe o Preço do Produto A: R$ ");
	scanf ("%d", & n1);
	
	printf ("Informe o Preço do Produto B: R$ ");
	scanf ("%d", & n2);
	
	printf ("Informe o Preço do Produto C: R$ ");
	scanf ("%d", & n3);

	if (n1 > n2 && n2 > n3){
		
		printf ("Você deve comprar o Produto C, pois ele é o mais barato \n em relação aos demais produtos citados: ");
		printf ("%d ", n3);
		printf (" R$ \n");

	}
	
	else if (n1 > n3 && n3 > n2){
	
		printf ("Você deve comprar o Produto B, pois ele é o mais barato em relação aos demais produtos citados: ");
		printf ("%d ", n2);
		printf (" R$ \n");
		
	}
	
		
	else if (n2 > n3 && n3 > n1){
		
		printf ("Você deve comprar o Produto A, pois ele é o mais barato em relação aos demais produtos citados: ");
		printf ("%d ", n1);
		printf (" R$ \n");
		
	}
	

	else if (n2 > n1 && n1 > n3){
	
		printf ("Você deve comprar o Produto C, pois ele é o mais barato em relação aos demais produtos citados: ");
		printf ("%d ", n3);
		printf (" R$ \n");
	}
	
	
	else if (n3 > n2 && n2 > n1){
		
		printf ("Você deve comprar o Produto A, pois ele é o mais barato em relação aos demais produtos citados: ");
		printf ("%d ", n1);
		printf (" R$ \n");
		
	}
	

	else if (n3 > n1 && n1 > n2){
	
		printf ("Você deve comprar o Produto B, pois ele é o mais barato em relação aos demais produtos citados: ");
		printf ("%d ", n2);
		printf (" R$ \n");
		
	}
	

}
