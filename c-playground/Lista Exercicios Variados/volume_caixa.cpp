/*
	Volume da caixa
*/

#include<stdio.h>
#include<conio.h>
#include<locale.h>

int main (void)

{
	
	float volume, largura, comprimento, altura;
  
	printf ("Indique a Altura da Caixa em CM: ",setlocale(LC_ALL,""));                                                                                                                             
	scanf ("%f", & altura);
  	
	printf ("\nAgora indique a largura da Caixa em CM: ");
	scanf ("%f", & largura);  	

	printf ("\nPor fim, indique a comprimento da Caixa em CM: ");
	scanf ("%f", & comprimento);  
  
	volume = altura*comprimento*largura;
		
	printf ("Volume: %.2f CM³", volume);

}
