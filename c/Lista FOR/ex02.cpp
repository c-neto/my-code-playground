#include <stdio.h>
#include <conio.h>
#include <locale.h>
#include <string.h>

int main (){
	
	setlocale (LC_ALL,"");
	
	char id[20], senha[20];
	
	printf("Digite seu Nome de usuário: ");
	gets(id);
	
	setbuf (stdin, NULL);
		
	printf("Digite sua Senha: ");
	gets(senha);
	
	setbuf (stdin, NULL);	

//compara o valor que está na memória, quando valores iguais, resultado igual a 0, então é feito uma comparação lógica
	while ( strcasecmp (id,senha)==0){
		
		printf("\nERRO!!! nome de usuário e senha iguais, por favor alterar, pois só assim o cadastro poderá ser efetuado\n\n");
		
		printf("Digite seu Nome de usuário: ");
		scanf("%c", & id);
		
		setbuf (stdin, NULL);
			
		printf("Digite sua Senha: ");
		scanf("%c", & senha);
		
		setbuf (stdin, NULL);
	}
		
	
	printf("\nCadastro efetuado com Sucesso!");
	printf("\n	***ANOTE***\nNome: %s\n", id);	
	printf("Senha: %s", senha);
	
	
}
