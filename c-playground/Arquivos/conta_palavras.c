#include <stdio.h>
//carlos Teste 2.0

int tratativa(FILE *file, int argumentos){

		if (argumentos != 2){
				printf("Erro de Sintaxe! uso correto: ./ler_exe <arq_texto>\n");
				return 1;
		}

		if ( (file==NULL) ){
				printf("[!] Problemas na leitura do(s) arquivo(s)\n");
				return 1;
		}

		return 0;

}

int caracter_especial (char let){

	if ( (let >= 65 && let <= 90)||(let >= 97 && let <= 122) ) {
		return 0;
	}
	else{
		return 1;
	}
}

void main(int argc, char *argv[]){

	FILE *arq;
	int k=0, flag=0, palavra=0;
	char letra;

	arq = fopen(argv[1], "r");

	if ( tratativa(arq, argc) ){
			return;
	}

	while ( fscanf(arq, "%c", &letra) != EOF){

		if( caracter_especial(letra)&&k==0 ){
				continue;
		}

		k++;

		if ( caracter_especial(letra) ){
			flag = 1;
			printf("X");
			continue;
		}

		if (flag){
			++palavra;
			printf("P++");
			flag=0;
		}
		printf("%c", letra);


	}

	if(flag==1){
		printf("P++");
		++palavra;
	}

	fclose(arq);

	printf("\nPalavras %d\n", palavra);
	return;
}
