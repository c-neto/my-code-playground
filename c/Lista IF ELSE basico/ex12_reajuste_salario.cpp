/*
	12. As Organizações Tabajara resolveram dar um aumento de salário aos seus..
*/

#include<stdio.h>
#include<conio.h>
#include <locale.h>  //

int main (void)
{
	
	setlocale(LC_ALL,"");
	
	float v, vp, ns;
	int p;

  	printf("Digite o seu Salário: ");
	scanf("%f", & v);

	if (v<258)
	{
		
		p=20;		
	
	}
		
	else
	{
	
		if (v>=280 && v<700)
		{
		
		p=15;	
		
		}
		
		
		else 
		{
			
			if (v>=700 && v<1500)
			{
	
			p=10;
			
			}
			
			else 
			{
			
			p=5;
			
			}		
		

		}
	}
	
		
	vp=((p*v)/100);
	ns=vp+v;
	
	
	printf("Você teve reajuste salarial, Seu salário passará de R$: %.2f", v);
	printf(" Para R$: %.2f", ns);	
	printf("\nIsso significa que você teve um aumento de R$: %.2f", vp);
	printf("\nPois seu salário teve um porcentual de reajuste de: %d", p);
	printf(" por cento\n");
	
}
 	

