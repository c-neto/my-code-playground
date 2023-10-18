/*
	Separar Caracteres.. ou numeros
	10 = '1' '0'
*/

#include <stdio.h>

int main()
{
    char letra1, letra2;

    printf("Insira um caractere: ");
    letra1 = getc(stdin);

    printf("Insira outro caractere: ");
    letra2 = getc(stdin);

    printf("Você digitou: '%c' e '%c'", letra1, letra2);
}
