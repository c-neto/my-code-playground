/*
		Valor INT ou FLOAT
*/

#include <stdio.h>
#include <conio.h>

int main()
{
    float num;
    int aux;
     
    printf ("Informe um numero\n");
    scanf ("%f", & num);	
	
	aux=num;

    if(aux==num){
	
	printf ("Numero inteiro\n");
	
	printf("AUX: %d\n", aux);	
	printf("NUM: %f", num);
	
	}
          
	else if (aux!=num){
	
	printf ("Numero decimal\n");
	
	}
    
	

}
