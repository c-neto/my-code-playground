/*
	13. Dados três números, imprimi-los em ordem crescente.
*/

#include <stdio.h>
#include <conio.h>

int main (){
	
	int n1, n2, n3, maior, menor, mei;
	
	scanf("%d", & n1);
	scanf("%d", & n2);	
	scanf("%d", & n3);	
	
	if (n1>n2 && n1>n3){

		if (n2>n3){
			printf("\n\n%d\n", n3);
			printf("%d\n", n2);
		}
			
		else {
			printf("%d\n", n2);
			printf("%d\n", n3);
		}
		
		printf("%d\n", n1);
			
	}
	
	if (n2>n3 && n2>n1){
		
		if (n1>n3){
			printf("\n\n%d\n", n3);
			printf("%d\n", n1);
		}
			
		else {
			printf("%d\n", n1);
			printf("%d\n", n3);
		}
		
		printf("%d\n", n2);
		
	}
	
	if (n3>n1 && n3>n2){
		
		if (n1>n2){
			printf("\n\n%d\n", n2);
			printf("%d\n", n1);
		}
			
		else {
			printf("%d\n", n1);
			printf("%d\n", n2);
		}
		
		printf("%d\n", n3);
		
	}
	
	if (n1==n2 && n2==n3){
		
		printf("%d\n", n1);
		printf("%d\n", n2);
		printf("%d\n", n3);
	}
}
