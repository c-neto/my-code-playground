/*
	Strlen - tamanho do vetor
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
    char nome1[100], nome2[100];

    printf("Digite o nome: ");
    gets(nome1);
    setbuf(stdin,NULL);


    printf("Nome tem %d letras\n", strlen(nome1)); //STRLEN retorna o TAMANHO DO VETOR

    system ("pause");
	return 0 ;   
}
