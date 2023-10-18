#include<stdio.h>

struct horario {
	int horas;
	int minutos;
	int segundos;
};

struct data {
	int dia;
	int mes;
	int ano;
}DATA_1={10,10,10}, DATA_2;

void imprimi_tempo(struct horario X){ //Declarar "struct com o nome da estrutura do qual o parametro vai pegar"

	printf("Horas: %d\nMinutos: %d\nSegundos: %d\n", X.horas , X.minutos , X.segundos);

}


void imprimi_tempo(struct data X){ //Declarar "struct com o nome da estrutura do qual o parametro vai pegar"

	printf("Dia: %d\nMes: %d\nAno: %d\n", X.horas , X.minutos , X.segundos);

}

int main(){

	struct horario AGORA;
	struct horario DEPOIS;

	AGORA.horas = 15;
	AGORA.minutos = 17;
	AGORA.segundos = 30;

	printf("AGORA: ");
	imprimi_tempo(AGORA);

	return 0;

}

