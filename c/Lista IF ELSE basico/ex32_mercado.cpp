/*
	Fomatacao, condicoes, mercado..	
*/

#include<stdio.h>	
#include<conio.h>
#include<locale.h>

int main (){

	setlocale (LC_ALL,"");

	printf("O Hipermercado Tabajara está com uma promoção de carnes que é imperdível. \nConfira:\n\n");	
	
	inicio:
	
	int val_op;
	float kg_1, des, kg_2, kg_3, kg=0, conta;
	char pcento='%';
	

	printf("Opção			Até 5 Kg		Acima de 5Kg\n");
	printf("|1|   Filé Duplo	R$ 4,90 por Kg		R$ 5,0 por Kg\n");
	printf("|2|   Alcatra		R$ 5,90 por Kg		R$ 6,80 por Kg\n");
	printf("|3|   Picanha		R$ 6,90 por Kg		R$ 7,80 por Kg\n");

	printf("\nDigite o número da Opção referente a carne desejada: ");
	scanf("%d", & val_op);
	
//op1	
	if (val_op==1){
	
		printf ("\n\nVocê escolheu a opção |1| = Filé Duplo\n\n");
		printf ("Digite a quantidade em Kg: ");	
		scanf ("%f", & kg);

	
		if (kg_1<=5){
		
			kg_1=kg_1+kg*4.90;
		
		}
		
		else {
			
			kg_1=kg_1+kg*5.80;
			
		}
		
	}
	
//op2
	if (val_op==2){
	
		printf ("\n\nVocê escolheu a opção |2| = Alcátra\n\n");
		printf ("Digite a quantidade em Kg: ");	
		scanf ("%f", & kg);

	
		if (kg_2<=5){
		
			kg_2=kg_2+kg*5.90;
		
		}
		
		else {
			
			kg_2=kg_2+kg*6.80;
			
		}
		
	}	
	
//op3
	if (val_op==3){
	
		printf ("\n\nVocê escolheu a opção |3| = Picanha\n\n");
		printf ("Digite a quantidade em Kg: ");	
		scanf ("%f", & kg);

	
		if (kg_3<=5){
		
			kg_3=kg_3+kg*6.90;
		
		}
		
		else {
			
			kg_3=kg_3+kg*7.80;
			
		}	
	}
		
	else if (val_op>3){
			
	printf("\n\nOPÇÃO INVÁLIDA!!!\n\n");
	goto inicio;
	
	}	
				
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
		conta=kg_1+kg_2+kg_3;
	}

	desicao:

	printf("\nDigite o Método de Pagamento:\n");
	printf(" |1|		Dinheiro\n |2|		Cartão de Crédito TABAJARA\n\n	--Obs* 5 %c de desconto para pagamentos no Cartão TABAJARA-- \n\nOpção: ", pcento);
	scanf("%d", & val_op);

	if(val_op==1){
		
		printf("\n\n		---Cupom Fical---\n\n");
			
		if (kg_1!=0){
			printf("Filé Duplo: ............... R$: %.2f\n", kg_1);
		}
			
		else if (kg_2!=0){
			printf("Alcatra: .................. R$: %.2f\n", kg_2);
		}
			
		else if (kg_3!=0){
			printf("Picanha: .................. R$: %.2f\n", kg_3);
		}
			
		printf("\nConta Final: ................ R$: %.2f\n", conta);		
	}

			
	else if(val_op==2){
		
		des = (conta*5)/100;
		conta=conta-des;
		
		printf("\n\n		---Cupom Fical---\n");
		
		if (kg_1!=0){
			printf("Filé Duplo: ............... R$: %.2f\n", kg_1);
		}

		if (kg_2!=0){
			printf("Alcatra: .................. R$: %.2f\n", kg_2);
		}
		
		if (kg_3!=0){
			printf("Picanha: .................. R$: %.2f\n", kg_3);
		}
		
		printf("Desconto: ..................... R$: %.2f\n", des);	
		printf("\nConta Final: ................ R$: %.2f\n", conta);
	
	}
		
	if (val_op>2){
			
		printf("OPÇÃO INVÁLIDA!!!\n");
		goto desicao;

	}
	
}
