/*
	Par ou Impar
*/


#include<stdio.h>
#include<conio.h>
#include <locale.h> //setlocale(LC_ALL,""); 

int main (void)
{
  
	setlocale(LC_ALL,"");
  
	int a;
	int resto;
  
	printf ("Informe um Valor: ");	
	scanf ("%d", & a);
  
	resto=a%2;
  
  
	if (resto==0){
		
		printf ("O Valor maior idicado é PAR: %d", a);
		
		}
	
	
	else{
		
		printf ("O Valor maior idicado é IMPAR: %d", a);
		
   }
  
}
