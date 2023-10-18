#include <stdio.h>
/*
	Escreva uma função que recebes 3 valores reais X, Y e Z e que verifique se esses valores podem ser os comprimentos dos lados de um triângulo e, neste caso, retornar qual o tipo de triângulo formado. Para que X, Y e Z formem um triângulo é necessário que a seguinte propriedade seja satisfeita: o comprimento de cada lado de um triângulo é menor do que a soma do comprimento dos outros dois lados. O procedimento deve identificar o tipo de triângulo formado observando as seguintes definições:
	-> Triângulo Equilátero: os comprimentos dos 3 lados são iguais.
	-> Triângulo Isósceles: os comprimentos de 2 lados são iguais.
	-> Triângulo Escaleno: os comprimentos dos 3 lados são diferentes.
*/

float triangulo (float catA, float catB, float catC){
	
	if (catA == catB && catB == catC){
		return 0;//printf("EQUILATERO");
	}
	
	if ( (catA != catB && catA != catC) && (catB != catA && catB != catA) && (catC != catA && catC != catB) ){
		return 1;//printf("ESCALENO");
	}
	
	else{	//( (catA == catB && catB != catC) || (catB == catC && catC != catA) ){
		return 2;//printf("ISOSCELES");
	}
}

int main(){
	
	float X=0, Y=0, Z=0;
	
	do {
		printf("Digite X");
		scanf("%f", & X);	
		
		printf("Digite Y");
		scanf("%f", & Y);
		
		printf("Digite Z");
		scanf("%f", & Z);
		
		if ( (X > X+Z) || (Y > Y+Z) || (Z > X+Y) ){
			printf("Medidas dos catetos nao formam um triangulo...\n\n");
		}
		
	} while ( (X > X+Z) || (Y > Y+Z) || (Z > X+Y) );

	if (triangulo(X, Y, Z) == 0){
		printf("EQUILATERO");
	}
	
	if (triangulo(X, Y, Z) == 1){
		printf("ESCALENO");
	}	
	
	if (triangulo(X, Y, Z) == 2){
		printf("ISOSCELES");
	}
}
