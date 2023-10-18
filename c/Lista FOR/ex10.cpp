#include <stdio.h>
#include <conio.h>

int main (){

	int f1, r, k;
	
	printf ("Insira o numero da tabuada:  ");
	scanf ("%d", & f1);
	
	for (k=0 ; k<=10 ; k++){

		r=f1*k;
		
		printf("%d x ", f1);
		printf("%d ", k);
		printf("= %d\n", r);
		
	}
}


