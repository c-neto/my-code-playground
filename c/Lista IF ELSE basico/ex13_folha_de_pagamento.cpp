/*
	13. entra com o preco da hora de trabalho e retorna FGTS, Liquido, Bruto..
*/

#include<stdio.h>
#include<conio.h>
#include <locale.h>  //

int main (void)
{
	
	setlocale(LC_ALL,"");
	
	
	float valor_hora, sal_bruto, sal_liq, imp_renda, total_desc, fgts, inss;
	int quanti_hora, ir;
	char pc='%';
	

  	printf("Digite o VALOR MONETÁRIO correpondente a cada HORA de seu trabalho: R$ ");
	scanf("%f", & valor_hora);
	
  	printf("Digite a quantidade de horas trabalhadas no mês: ");
	scanf("%d", & quanti_hora);
	
	sal_bruto=valor_hora*quanti_hora;
	
	
	if (sal_bruto<=900)
	{
		printf("\nisento\n");
		ir = 0;	
		
	}
	
	else 
	{
			
		if (sal_bruto<1500)
		{
			printf("\n5 por cento\n");
			ir = 5;
	
		}
	
		else
		{
		
			if (sal_bruto<=2500)
			{
				printf("\n10 por cento\n");
				ir = 10;	
				
			}
			
			else
			{
				
				if (sal_bruto>2500)
				{
					printf("\n20 por cento\n");
					ir=20;
					
				}
			}
		} 
	
	}	

	inss = (sal_bruto*10)/100;
	fgts = (sal_bruto*11)/100;
	imp_renda = (sal_bruto*ir)/100;
	
	total_desc = inss+fgts+imp_renda;
		
	sal_liq = sal_bruto-inss-fgts-fgts;
	
	
	
	printf ("Salário Bruto: ");
	printf("(%d horas", quanti_hora);
	printf(" * ");
	printf(" R$ %.2f)", valor_hora);
	printf("	: R$  %.2f", sal_bruto);
	
	printf("\n(-) IR (%d", ir);
	printf("%c)", pc);
	printf("				: R$  %.2f", imp_renda);	
	
	printf("\n(-) INSS (10%c)", pc);
	printf("				: R$  %.2f", inss);
		
	printf("\nFGTS (11%c)", pc);
	printf("				: R$  %.2f", fgts);
	
	printf("\nTotal de descontos");
	printf("			: R$  %.2f", total_desc);
	
	printf("\n\nSalário Liquido");
	printf("			: R$  %.2f", sal_liq);	

}
 	

