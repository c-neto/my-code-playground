#include <stdio.h>
#include <conio.h>

int main(){
	
	int i, r=1, aux;
	
	printf("Numero: ");
	scanf("%d", & i);

	aux=i;
	
	for (i ; aux>0 ; aux--){
		r = r*aux;
	}
	
	printf("%d ! = ", i);
	printf("%d", r);
}

