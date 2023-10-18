/*
	Como pegar CARACTERE
*/

#include <stdio.h>

int main()
{
    char letra;

    printf("Insira um caractere: ");
    letra = getchar();
    printf("Você digitou: '%c'", letra);
}
