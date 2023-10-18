/*
	Bhaskara
*/

#include <stdio.h>
#include <conio.h>
#include <math.h>

int main()
{
	int a, b, c, delta, x1, x2;
	
	printf("Informe o valor de ax2: ");
	scanf("%d", &a);
	
	if(a == 0)
	{
		printf("Nao e uma equacao de segundo grau");
	}
	
	printf("Informe o valor de bx: ");
	scanf("%d", &b);
	
	printf("Informe o valor de c: ");
	scanf("%d", &c);
	
	delta = (pow(b, 2)) - 4 * a * c;
	
	if(delta<0)
	{
		printf("\n-Nao possui raizes reais");
	}
	else if(delta==0)
	{
		printf("\n-So existe uma raiz real");
		x1 = ((-b) + sqrt(delta)) / 2+a;
		printf("\n-Raiz: %d", x1);
	}
	else
	{
		x1 = ((-b) + sqrt(delta)) / 2+a; 
		x2 = ((-b) - sqrt(delta)) / 2+a;
		
		printf("\n-Raize(x1): %d", x1);
		printf("\n-Raize(x2): %d", x2);
	}
}
