#include<stdio.h>

int main(){

	//	//	//	//	//	//	//	//	//	//	//	//	//	//	//


	//Declaração da Estrutura
	struct horario {
		int horas;
		int minutos;
		int segundos;
	};

	//Criando uma variável AGORA e DEPOIS, na estrura "horario"
	struct horario AGORA;
	struct horario DEPOIS;

	//Declarando valores a variavel AGORA, na estrutura "horario"
	//Chamando todas as variaveis da estrutura "horario"
	AGORA.horas = 15;
	AGORA.minutos = 17;
	AGORA.segundos = 30;

	DEPOIS.horas = AGORA.horas + 10;
	DEPOIS.minutos = AGORA.minutos;
	DEPOIS.segundos = AGORA.segundos-20;

	printf("AGORA: Horas: %d\nMinutos: %d\nSegundos: %d\n", AGORA.horas , AGORA.minutos , AGORA.segundos);
	printf("\n\nDEPOIS: Horas: %d\nMinutos: %d\nSegundos: %d\n", DEPOIS.horas , DEPOIS.minutos , DEPOIS.segundos);

	//	//	//	//	//	//	//	//	//	//	//	//	//	//	//

	struct data {
		int dia;
		int mes;
		int ano; 	//Quem nao tem valor atribuido recebe 0
	}DATA_1={10,10,10}, DATA_2;

	printf("DATA 1: Dia: %d\Mes: %d\nAno: %d\n", DATA_1.dia , DATA_1.mes , DATA_1.ano);
	printf("DATA 2: Dia: %d\Mes: %d\nAno: %d\n", DATA_2.dia , DATA_2.mes , DATA_2.ano);


	return 0;

}
