/*
	CSI etec..
*/

#include<stdio.h>
#include<conio.h>
#include <locale.h> //setlocale(LC_ALL,""); 

int main (void)
{
  
	setlocale(LC_ALL,""); 
  
 	int p1, p2, p3, p4, p5, soma_p;
  
 	printf ("Telefonou para a vítima?");  	
	printf ("\n|1| - Sim\n|0| - Não\n -> ");
	scanf ("%d", & p1);
  	
  	printf ("\nEsteve no local do crime?\n");
   	printf ("\n|1| - Sim\n|0| - Não\n -> ");
  	scanf ("%d", & p2);	
  	 	
  	printf ("\nMora perto da vítima?\n"); 
	   	
   	printf ("\n|1| - Sim\n|0| - Não\n -> ");
  	scanf ("%d", & p3);
  	
  	printf ("\nDevia para a vítima?\n");
  	
   	printf ("\n|1| - Sim\n|0| - Não\n -> ");
  	scanf ("%d", & p4);	
  	 	
  	printf ("\nJá trabalhou com a vítima?\n"); 	
  	 	
   	printf ("\n|1| - Sim\n |0| - Não\n -> ");
  	scanf ("%d", & p5);
  	
  	soma_p=p1+p2+p3+p4+p5;
  	
	if (soma_p==1){
		
		printf ("\nInocente");
		
	}
	
	else if (soma_p==2){
		
		printf ("\nSuspeita");
		
	}
	
	else if (soma_p>=2 && soma_p<5){
		
		printf ("\nCúmplice");
		
	}
	
	else if (soma_p==5){
		
		printf ("\nAssasino");
		
	}
  
}
