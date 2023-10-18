#include <stdio.h>

/*
	A função soma(), irá assumir os parametros POR ORDEM, ou seja, A, B, C são os nomes
	Genéricos das variáveis dessa função, por isso é necessário declarar o tipo delas
	por que ela não sabe por sí o quais as tipos de variaveis que vão ser declarado nela
	então, NO CASO DESTA LÓGICA ela trabalhará com os nomes das variáevis A,B,C no 
	lugar do nome das variáveis X,Y,Z da função main() que está a chamar a função soma; 
	A==X;
	B==Y;
	C==Z;
*/

//float é o tipo da variável do return desta função
float soma (int A, int B, int C){ 	
	
	return A+B+C;			
}

// Função main (), sempre vem por ultimo... para identificar as funções anteriores
int main(){		
	
	// Declaração de Variáveis, percebe-se que tem nomes distintos das variaveis da funcao soma()
	int X=0, Y=0, Z=0; 
	
	
	printf("Digite X: ");
	scanf("%d", & X);	
		
	printf("Digite Y: ");
	scanf("%d", & Y);
		
	printf("Digite Z: ");
	scanf("%d", & Z);
	
	// Lógica simples... vai chamar a função soma, passando como parametro as variaveis X,Y,Z;
	// Ou seja, "soma(X, Y, Z)" vai ser o valor do return da funcao soma();
	// lembrando que a mascara tem que %f, uma vez que foi declarado como float a função soma();
	printf ("%.2f", soma(X, Y, Z) ); 
}
