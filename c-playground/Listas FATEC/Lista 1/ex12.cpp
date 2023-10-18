/*
	
	12. Um matemático italiano da idade média conseguiu modelar o ritmo de
	crescimento da população de coelhos através de uma seqüência de números
	naturais que passou a ser conhecida como sequencia de Fibonacci. O n-ésimo
	número da seqüência de Fibonacci Fn é dado pela seguinte fórmula de
	recorrência:
	Faça um programa que, dado n, calcula Fn.

*/

#include <stdio.h>
#include <conio.h>

int main(){

	int k=1,n=0,a=0,b=1,c=1;

	scanf("%d", &n);

	for (k; k <= n; k++){

		printf("F(%d) = %d\n", k ,c);
		c = a+b;
		a=b;
		b=c;
		

	}
	return 0;
}
