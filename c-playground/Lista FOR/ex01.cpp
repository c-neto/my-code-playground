#include <stdio.h>
#include <conio.h>
#include <locale.h>

int main (){
	
	setlocale (LC_ALL,"");
	
	int n;
	
	printf ("Insira um valor de 0 a 10: ");
	scanf ("%d", & n);
	
	while (n>10){
		
		printf ("VALOR INVÁLIDO\n");
		printf ("Insira um valor de 0 a 10\n");
		scanf ("%d", & n);

	}
	
	printf ("Fim de programa");	
	
}
