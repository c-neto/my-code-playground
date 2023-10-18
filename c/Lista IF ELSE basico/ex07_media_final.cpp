/*
	7 Faça um programa para a leitura de duas notas parciais de um aluno. APROVADO ou REPORVADO
*/

#include<stdio.h>
#include<conio.h>
#include <locale.h> //setlocale(LC_ALL,""); 

int main (void)
{
  
	setlocale(LC_ALL,""); 
  
 	float n1, n2, mf;
  
 	printf ("Informe a NOTA 1: ");
  	scanf ("%f", & n1);
  	
  	printf ("Informe a NOTA 2: ");
  	scanf ("%f", & n2);
  	
  	mf=(n1+n2)/2;

	if (mf>=0 && mf<5){
		
		printf ("Você está REPROVADO, sua média final é de %.2f", mf);
		printf ("\nMédia final não foi superior a 5", mf);
	}
	
	else if (mf>=5 && mf<7){
	
		printf ("Você está RECUPERAÇÃO, sua média final é de %.2f", mf);
		printf ("\n ... ", mf);

	}
	
	else if (mf>=7 && mf<=10){
	
		printf ("Parabéns, Você está APROVADO, sua média final é de %.2f", mf);
		printf ("\n ... ", mf);

	}
		
	else{
		
		printf ("Média invalida: %.2f", mf);
		printf ("\nA média das notas excederam o valor 10, ", mf);		
	}
  
}
