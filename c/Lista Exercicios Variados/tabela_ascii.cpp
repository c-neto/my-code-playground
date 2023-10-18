/*
	Mostra a Tabela Ascii
*/

#include <stdio.h>
#include <conio.h>

int main (){
	
	char i;
	int p=32;
	
	for (i=33;i<250;i++ && p++)
	{
	printf ("\n Posicao %d: ", p);
	printf (":	%c", i);
	}

	
	
}
