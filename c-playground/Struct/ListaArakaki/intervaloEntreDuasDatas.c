#include<stdio.h>

struct dma{
	int dia;
	int mes;
	int ano;
};

int bissexto(ano){
	int flag;

	if(ano%4==0 && (ano%100!=0 || ano%400==0) ){
		flag=1;
	}

	else {
		flag=0;
	}

	return flag;
}

int erro_data(struct dma DATA){

	if ( DATA.dia<1
		|| (DATA.mes==2 && bissexto(DATA.ano) && DATA.dia>29 )
		|| (DATA.mes==2 && bissexto(DATA.ano)==0 && DATA.dia>28 )
		|| ( (DATA.mes==4 || DATA.mes==6 || DATA.mes==9 || DATA.mes==11)&&(DATA.dia>30) )
		|| DATA.dia>31 || DATA.mes>12
		){

		return 1;
	}

	else{
		return 0;
	}

}

int distancia (struct dma datainicio, struct dma datafim) {

	int dias=0, flag=0, fim=0;

	while(1){

		if( datainicio.dia==datafim.dia && datainicio.mes==datafim.mes && datainicio.ano==datafim.ano ){
			break;
		}

		if ( bissexto(datafim.ano) ){
			flag=1;
		}

		else {
			flag=0;
		}

		switch (datainicio.mes){

			case 1:
				fim=31;
				break;

			case 2:

				fim=28;

				if (flag){
					fim+=1;
				}

				break;

			case 3:
				fim=31;
				break;

			case 4:
				fim=30;
				break;

			case 5:
				fim=31;
				break;

			case 6:
				fim=30;
				break;

			case 7:
				fim=31;
				break;

			case 8:
				fim=31;
				break;

			case 9:
				fim=30;
				break;

			case 10:
				fim=31;
				break;

			case 11:
				fim=30;
				break;

			case 12:
				fim=31;
				break;
		}

		if (datainicio.dia==fim){
			datainicio.mes+=1;
			datainicio.dia=0;
		}

		if (datainicio.mes==12){
			datainicio.ano+=1;
			datainicio.mes=1;
		}
		datainicio.dia+=1;
		dias+=1;
	}

	return dias;
}

int main(){

	struct dma DATA_INICIO;
	struct dma DATA_FIM;

	printf("PRIMEIRA data\n\n");
	do{
		printf("Digite o dia inicial do evento: ");
		scanf("%d", & DATA_INICIO.dia);

		printf("Digite o mes: ");
		scanf("%d", & DATA_INICIO.mes);

		printf("Digite o ano: ");
		scanf("%d", & DATA_INICIO.ano);

	}while( erro_data(DATA_INICIO) );

	printf("SEGUNDA data\n\n");
	do{
		printf("Digite o dia inicial do evento: ");
		scanf("%d", & DATA_FIM.dia);

		printf("Digite o mes: ");
		scanf("%d", & DATA_FIM.mes);

		printf("Digite o ano: ");
		scanf("%d", & DATA_FIM.ano);

	}while( erro_data(DATA_FIM) );

	printf("%d dias", distancia(DATA_INICIO, DATA_FIM) );

}
