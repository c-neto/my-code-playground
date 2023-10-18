/*
	Salario Minimo
*/

#include<stdio.h>
#include<conio.h>

int main (void)
{
    float sm=500, sa, r=0;
    
	printf ("entre com o salario atual:");
	scanf ("%f", & sa);
	
	printf ("entre com o salario minimo:");
	scanf ("%f", & sm);
	
	r= (sa/sm);
	printf("a quantidade de salarios minimo entre o salario atual e:%f:", r);
	
	getch();
}
