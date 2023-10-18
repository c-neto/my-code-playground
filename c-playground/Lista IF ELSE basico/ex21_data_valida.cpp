#include<stdio.h>
#include<conio.h>
#include <locale.h> //setlocale(LC_ALL,""); 

int main (void)
{
  
	setlocale(LC_ALL,"");
  
	int d, m, a;

	
	printf("Indique uma Data no formato DD/MM/AAAA \n");
	
	printf ("Informe o Dia: ");
	scanf ("%d", & d);
	
	printf ("Informe o Mês: ");
	scanf ("%d", & m);	
	
	printf ("Informe o Ano: ");
	scanf ("%d", & a);
	
	if (d>31 && d<1 || m>12 && m<1 || a<=999 && a>9999){
			
		printf ("Data Inválida");
				
	}
			
	else{
				
		printf ("Data Válida");
				
	}
	
}
