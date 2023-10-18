/*
	Velocidade média de uma caixa
*/

#include<stdio.h>
#include<conio.h>
#include <locale.h>

int main (void)
{
		
	float velocidade, distancia, tempo, min;
	
	printf ("Indique a Velocidade Média em KM/h: ",setlocale(LC_ALL,""));
	scanf ("%f", & velocidade);

	printf ("Indique a Distância em KM: ");
	scanf ("%f", & distancia);

	tempo = distancia/velocidade;

	min=60*tempo;

	if (min >60){

 		printf("Tempo Estimado: ");
 		printf("%.2f", tempo);
 		printf("Horas"); 

	}

	else{

 		printf("Tempo Estimado: ");
 		printf("%.2f", min);
 		printf(" Minutos"); 

	} 
}
