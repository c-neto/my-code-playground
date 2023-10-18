#include <stdio.h>
#include <conio.h>

int main (){

	int n, e, r=1, k=0, b;

	printf ("Insira a base:  ");
	scanf ("%d", & b);
	
	printf ("Insira o expoente:  ");
	scanf ("%d", & e); 

	for (k;k<e;k++){
		r*=b;			
	}		
		
	printf ("RESULTADO: %d \n \n", r);
	
}
