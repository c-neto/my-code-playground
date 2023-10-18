/*
	strcat - concatena duas variaveis
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
	char nome1 [100], nome2 [100];
	
    printf("Digite o nome: ");
    gets(nome1);
    setbuf(stdin,NULL);
 
    printf("Digite o sobrenome: ");
    gets(nome2);
    strcat(nome1," ");

    strcat(nome1,nome2);
    printf("\n\nNome: %s\n", nome1);

    system("pause");
    return 0;
}
