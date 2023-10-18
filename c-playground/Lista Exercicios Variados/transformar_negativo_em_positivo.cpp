#include<stdio.h>
#include<conio.h>
#include <locale.h> //setlocale(LC_ALL,""); 

int main (void)
{
  
	setlocale(LC_ALL,"");  

 	int n;
  
 	printf ("Informe um Valor: ");
  	scanf ("%d", & n);
  	
  	
	if (n<0){
		
		n=n*-1;
		printf ("Valor NEGATIVO Transformado em POSITIVO: %d", n);

	}
	
	
}
