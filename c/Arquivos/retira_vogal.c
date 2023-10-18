#include <stdio.h>

int tratativa(FILE *file, int argumentos){

		if (argumentos != 3){
				printf("Erro de Sintaxe! uso correto: ./come_vogal <arq_origem> <aqr_destino>\n");
				return 1;
		}

		if ( (file==NULL) ){
				printf("Problemas foram encontrados ao ler os arquivos\n");
				return 1;
		}

		return 0;

}

int consoante (char let){

		if ( (let >= 65 && let <= 90)||(let >= 97 && let <= 122) ){

				if (let =='a' ||
						let =='e' ||
						let =='i' ||
						let =='o' ||
						let =='u'){
								return 0;
						}

				else{
						return 1;
				}

		}
		else{
				return 0;

		}
}

void main(int argc, char *argv[]) {

	  FILE *file_in, *file_out;

		char letra;

		file_in  = fopen (argv[1], "r");
		file_out = fopen (argv[2], "w");

		if( tratativa (file_in, argc) ){
				return;
		}

		while ( fscanf(file_in, "%c", &letra) != EOF ) {
				if ( consoante(letra) ){
						putc(letra,file_out);
				}
		}

		fclose(file_in);
		fclose(file_out);
		return;
}
