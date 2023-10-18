/*
	Formatação, menu, acougue...
*/

#include<stdio.h>	
#include<conio.h>
#include<locale.h>

int main (){

	setlocale (LC_ALL,"");

	printf("O Hipermercado Tabajara está com uma promoção de carnes que é imperdível. \nConfira:\n\n");	
	
	inicio:
	
	int val_op;
	float kg_1, des, kg_2, kg=0, conta, kg_total, kg_maca, kg_morango;
	char pcento='%';
	

	printf("Opção			Até 5 Kg		Acima de 5Kg\n");
	printf("|1|   Maça		R$ 2,50 por Kg		R$ 2,20 por Kg\n");
	printf("|2|   Morango		R$ 1,80 por Kg		R$ 1,50 por Kg\n");

	printf("\nDigite o número da Opção referente a carne desejada: ");
	scanf("%d", & val_op);
	
//op1	
	if (val_op==1){
	
		printf ("\n\nVocê escolheu a opção |1| = Maça\n\n");
		printf ("Digite a quantidade em Kg: ");	
		scanf ("%f", & kg_maca);
	

		if (kg_1<=5){
		
			kg_1=kg_1+kg_maca*2.50;
		
		}
		
		else {
			
			kg_1=kg_1+kg_maca*2.20;
			
		}
		
	}
	
//op2
	if (val_op==2){
	
		printf ("\n\nVocê escolheu a opção |2| = Morango\n\n");
		printf ("Digite a quantidade em Kg: ");	
		scanf ("%f", & kg_morango);

	
		if (kg_2<=5){
			
			kg_2=kg_2+kg_morango*1.80;
		
		}
		
		else {
			
			kg_2=kg_2+kg_morango*1.50;
			
		}
		
	}	

		
	else if (val_op>2){
				
		printf("\n\nOPÇÃO INVÁLIDA!!!\n\n");
		goto inicio;
	
	}	
	
	desicao:
	printf ("\nDESEJA EFETUAR OUTRA COMPRA? \n ");
	printf ("|1| SIM \n |2| NAO \n \n");
	printf("\nOpção: ");
	scanf ("%d", & val_op);
	
//inicio	
	if (val_op==1)
	{
		goto inicio;
	}
	
	
	else if (val_op==2)
	{
		kg_total=kg_maca+kg_morango;
		conta=kg_1+kg_2;
	
		if (kg_total>=8 || conta > 25){
			des = (conta*10)/100;

			printf("\n\n		---Cupom Fical---\n");
			
			if (kg_1>0){
				printf("Morango: ............... R$: %.2f\n", kg_1);
			}
	
			if (kg_2>0){
				printf("Maça: .................. R$: %.2f\n", kg_2);
			}
					
			printf("Desconto: ..................... R$: %.2f\n", des);	
			printf("\nConta Final: ................ R$: %.2f\n", conta);		
		}
		
		else {
			
			des=0;
			printf("\n\n		---Cupom Fical---\n");
			
			if (kg_1>0){
				printf("Morango: ............... R$: %.2f\n", kg_1);
			}
	
			if (kg_2>0){
				printf("Maça: .................. R$: %.2f\n", kg_2);
			}
					
			printf("Desconto: ..................... R$: %.2f\n", des);	
			printf("\nConta Final: ................ R$: %.2f\n", conta);		
			
		}
	}
	
	if (val_op>2){
			
		printf("OPÇÃO INVÁLIDA!!!\n");
		goto desicao;

	}
	
}
