/*
	11. Faça um Programa que pergunte em que turno você estuda. Peça para digitar Mmatutino
*/

#include <stdio.h>
#include <conio.h>
#include <locale.h> 

int main (){
	
	setlocale(LC_ALL,"");
	
	char letra, matutino = 'm', Matutino = 'M', noturno = 'n', Noturno = 'N', vespertino = 'v', Vespertino = 'v';

	printf("Idique a letra inicial do Período em qual você estuda: ");
	printf("\nM - Matutino \nV-Vespertino \nN- Noturno\n");
	scanf("%c", & letra);
	
	if (letra==matutino || letra==Matutino){
		
		printf("Bom dia !!!");
		
	}
	
	else if (letra==vespertino || letra==Vespertino){
		
		printf("Boa Tarde !!!");
		
	}
	
	else if (letra==noturno || letra==Noturno){
		
		printf("Boa Noite!!!");
		
	}
	
	else {
		
		printf("Valor Inválido!");
	}
	
}
