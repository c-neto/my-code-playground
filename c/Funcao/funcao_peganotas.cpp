/*
	Pega notas POR FUNÇÃO e faz média
*/


#include <stdio.h>
#include <conio.h>
#include <locale.h>

float peganota(){

	float nota=-1;
	
	while (nota<0 || nota>10){
	
		printf ("Informa (0-10)");
		fflush(stdin);
		scanf ("%f", & nota);
	
		if (nota<0 || nota>10){
			printf("nota invalida\n");
		}	
		
	}
	
	return nota;
}

int main (){
	
	float n1,n2,n3,n4,media;
	
	printf ("Informe Nota: ");
	n1 = peganota ();
	
	printf ("Informe Nota: ");
	n2 = peganota ();
	
	printf ("Informe Nota: ");
	n3 = peganota ();
	
	printf ("Informe Nota: ");
	n4 = peganota ();

	media=(n1+n2+n3+n4)/4;
	printf ("Media: %.2f", media);
	
	return 0;
	
}
