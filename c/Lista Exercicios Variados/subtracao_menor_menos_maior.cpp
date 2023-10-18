/*
	Subtracao do Menor para maior
*/

#include<stdio.h>
#include<conio.h>
#include<locale.h>

int main (void)

{

	int val_a, val_b, aux, subt;

	setlocale(LC_ALL,"");
		
	printf ("Indique a Variável A: ");
	scanf ("%d", & val_a);

	printf ("Indique a Variável B: ");
	scanf ("%d", & val_b);


	if (val_a<val_b){
	
	aux = val_a;
	val_a=val_b;
	val_b = aux;
	
	}


subt =val_a-val_b;

printf ("MAIOR %d", val_a);


printf ("\n subtração do menor para o maior: %d", subt);

}
