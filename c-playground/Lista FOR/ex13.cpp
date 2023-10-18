#include <stdio.h>
#include <conio.h>

int main (){

	int n, e, k=0;

	printf ("Insira o termo final:  ");
	scanf ("%d", & n); 
	
	
	for (k=1 ; k<n ; k+=k){
		printf("%d\n", k);
	}		
		
	
}
