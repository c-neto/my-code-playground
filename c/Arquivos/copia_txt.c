#include <stdio.h>

int main(int argc, char *argv[]) {

	FILE *E, *S;
	int c;

	if (argc==3) {
		E=fopen(argv[1],"r");
		S=fopen(argv[2],"w");

		if ((E!=NULL)&&(S!=NULL)){
			while((c=getc(E))!=EOF){ 
				putc(c,S);
			}

		} else{
			printf("Erro de abertura de arquivo\n");
			fclose(E); 
			fclose(S);
		}
	
	} else{
		printf("uso: copia <origem> <destino>\n", argv[0]);
	
	}
	return 0;
}
