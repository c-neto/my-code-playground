/*
	strcasecmp - Verificacao não case sensitive
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
    char nome1[100], nome2[100];
    
	printf("Digite nome 1: ");
    scanf("%s", & nome1);
    setbuf(stdin,NULL);

	printf("Digite nome 2: ");
    scanf("%s", & nome2);
    setbuf(stdin,NULL);


	if( strcasecmp(nome1,nome2)==0 ){  //Valor 0 é verdadeiro - vetores são iguais
        printf("\n\nnomes iguais!\n\n");
    }
    else{
        printf("\n\nnomes diferentes!\n\n");
    }
    
    system ("pause");
	return 0 ;   
}
