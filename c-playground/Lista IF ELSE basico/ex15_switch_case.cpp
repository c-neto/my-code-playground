/*
	15. Faça um Programa que tendo como dados de entrada o preço de custo de um..
*/

#include<stdio.h>
#include<conio.h>
#include<locale.h>

int main (void)

{
	setlocale(LC_ALL,"");
		
	int cod_origem;
	float preco;
		
	printf ("Digite o Preço do Produto: R$ ");
	scanf ("%f", & preco);
	
	printf ("Código de Origem: ");
	scanf ("%d", & cod_origem);
	
	  switch ( cod_origem )
  	{
     case 1 :
		printf ("Origem do Produto: ");
		printf ("Sul\n");
		printf ("Preço R$: %.2f", preco);
     break;
 
     case 2 :
		printf ("Origem do Produto: ");
		printf ("Norte\n");
		printf ("Preço R$: %.2f", preco);       
     break;
 
     case 3 :
       	printf ("Origem do Produto: ");
		printf ("Leste\n");
		printf ("Preço R$: %.2f", preco); 
     break;
 
     case 4 :
        printf ("Origem do Produto: ");
		printf ("Oeste\n");
		printf ("Preço R$: %.2f", preco); 
     break;
 
     case 5 :
        printf ("Origem do Produto: ");
		printf ("Nordeste\n");
		printf ("Preço R$: %.2f", preco);         
        
     break;
 
     case 6 :
        printf ("Origem do Produto: ");
		printf ("Nordeste\n");
		printf ("Preço R$: %.2f", preco);  
     break;
 
     case 7 :
        printf ("Origem do Produto: ");
   		printf ("Centro-Oeste\n");
		printf ("Preço R$: %.2f", preco);  
     break;
     
	 case 8 :
        printf ("Origem do Produto: ");
   		printf ("Centro-Oeste\n");
		printf ("Preço R$: %.2f", preco);  
     break;     
 
     default :
        printf ("Origem do Produto: ");
   	 	printf ("Importado\n");
		printf ("Preço R$: %.2f", preco);  
	  
 	}
 
		
}
	

