#include <stdio.h>
#include <conio.h>
#include <locale.h>
#include <string.h>

int main (){
	
	setlocale(LC_ALL,"");
	
	char nome [100];
	char sexo, est_civil;
	float salario;
	int idade;
//	
	do{
		
	  	printf("Digite o nome: ");
	    gets(nome);
	    setbuf(stdin,NULL);
	    printf("Nome tem %d letras\n", strlen(nome)); //STRLEN retorna o TAMANHO DO VETOR
		
	} while (strlen(nome)<3);
//
	do{
	
		printf("\nDigite seu Sexo: ");
		scanf("%c", & sexo);
		setbuf (stdin, NULL);
		
	} while (sexo!='m' && sexo!='f');
		
	switch (sexo){
		
		case 'f':
		printf("\nFeminino\n");
		break;
		
		case 'm':
		printf("\nMasculino\n");
		break;
		
	}
//		

	do{
	
		printf("\nDigite a inicial do seu estado civil: ");
		scanf("%c", & est_civil);
		setbuf (stdin, NULL);
		
	} while (est_civil!='s' && est_civil!='c' && est_civil!='v' && est_civil!='d');
	
	switch (est_civil){
		case 's':
		printf("\nSolteiro\n");
		break;
		
		case 'c':
		printf("\nCasado\n");
		break;
		
		case 'v':
		printf("\nViúvo\n");
		break;
		
		
		case 'd':
		printf("\nDivorciado\n");
		break;
			
	}
//		
	do{
	
		printf("\nDigite sua idade: ");
		scanf("%d", & idade);
		setbuf (stdin, NULL);
		
	} while (idade<3);
//
	do{
	
		printf("\nDigite seu Salário: ");
		scanf("%f", & salario);
		setbuf (stdin, NULL);
		
	} while (salario<1);
	
}
