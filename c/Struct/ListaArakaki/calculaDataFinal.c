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

struct dma fim_evento (struct dma datainicio, int duracao) {
	struct dma datafim;
	int k=0, flag=0, fim=0;

	datafim.dia=datainicio.dia-1;
	datafim.mes=datainicio.mes;
	datafim.ano=datainicio.ano;

	for(k=0 ; k<duracao ; k++, datafim.dia++){

		if ( bissexto(datafim.ano) ){
			flag=1;
		}

		else {
			flag=0;
		}

		switch (datafim.mes){

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

		if (datafim.dia==fim){
			datafim.mes+=1;
			datafim.dia=0;
		}

		if (datafim.mes==12){
			datafim.ano+=1;
			datafim.mes=1;
		}

	}

	return datafim;
}

int main(){

	int duracao, flag=0;

	struct dma DATA_INICIO;
	struct dma DATA_FIM;

	do{
		printf("Digite o dia inicial do evento: ");
		scanf("%d", & DATA_INICIO.dia);

		printf("Digite o mes: ");
		scanf("%d", & DATA_INICIO.mes);

		printf("Digite o ano: ");
		scanf("%d", & DATA_INICIO.ano);

	}while( erro_data(DATA_INICIO) );


	printf("\nInsira a duracao em DIAS do evento: ");
	scanf("%d", & duracao);

	DATA_FIM=fim_evento(DATA_INICIO, duracao);

	printf("\nDATA FINAL\n");

	printf("O evento terminara em:\n");
	printf("%d / ", DATA_FIM.dia);

	printf("%d (", DATA_FIM.mes);

	switch (DATA_FIM.mes){

		case 1:
			printf("Janeiro");
			break;

		case 2:
			printf("Fevereiro");
			break;

		case 3:
			printf("Marco");
			break;

		case 4:
			printf("Abril");
			break;

		case 5:
			printf("Maio");
			break;

		case 6:
			printf("Junho");
			break;

		case 7:
			printf("Julho");
			break;

		case 8:
			printf("Agosto");
			break;

		case 9:
			printf("Setembro");
			break;

		case 10:
			printf("Outubro");
			break;


		case 11:
			printf("Novembro");
			break;

		case 12:
			printf("Dezembro");
			break;
	}

	printf(") / %d\n", DATA_FIM.ano);

	return 0;
}
