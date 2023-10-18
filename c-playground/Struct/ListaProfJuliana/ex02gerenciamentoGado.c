#include <stdio.h>
#define MAX 2000

typedef struct{
  int mes;
  int ano;
}Nascimento;

typedef struct{
  int codigo;
  float leite;
  float alimento;
  char abate;
  Nascimento nascimento;
}Cabeca;

void inserir(Cabeca cabecas[], int indice){

  cabecas[indice].codigo = indice;

  printf("Entre com os litros de leite: ");
  scanf("%f", &cabecas[indice].leite);

  printf("Entre com kilo de alimento: ");
  scanf("%f", &cabecas[indice].alimento);

  printf("Entre com o mes de nascimento da vaca: ");
  scanf("%d", &cabecas[indice].nascimento.mes);

  printf("Entre com o ano de nascimento da vaca: ");
  scanf("%d", &cabecas[indice].nascimento.ano);

  int data = cabecas[indice].nascimento.ano;
  int idade=2017-data;

  if( (idade > 5) ||
      (cabecas[indice].leite < 40.0) ||
      (((cabecas[indice].leite >= 50.0) && (cabecas[indice].leite <= 70.0)) && ((cabecas[indice].alimento/7)>50)) )
  {
    cabecas[indice].abate='S';
    printf("Vai ser abatida\n");
  }
  else{
    printf("Nao vai para o abate");
    cabecas[indice].abate='N';
  }

}

float semanaLeite(Cabeca cabecas[], int index){
  float ak=0;
  int k;
  for (k = 0; k < index; k++) {
    ak+=cabecas[k].leite;
  }
  return ak;
}

float semanaAlimento(Cabeca cabecas[], int index){
  float ak=0;
  int k;
  for (k = 0; k < index; k++) {
    ak+=cabecas[k].alimento;
  }
  return ak;
}

float semanaLeitePosAbate(Cabeca cabecas[], int index){
  float ak=0;
  int k;
  for (k = 0; k < index; k++) {
    if(cabecas[k].abate == 'S'){
      continue;
    }
    ak+=cabecas[k].leite;
  }
  return ak;
}

float semanaAlimentoPosAbate(Cabeca cabecas[], int index){
  float ak=0;
  int k;
  for (k = 0; k < index; k++) {
    if(cabecas[k].abate == 'S'){
      continue;
    }
    ak+=cabecas[k].alimento;
  }
  return ak;
}

int cabecasParaAbate(Cabeca cabecas[], int index){
  int ak=0;
  int k;

  for (k = 0; k < index; k++) {
    if(cabecas[k].abate == 'S'){
      ak+=1;
      printf("COD: %d\n", cabecas[k].codigo);
    }
  }
  return ak;
}

void menu(){
  printf("0- Inserir vaca\n");
  printf("1- Devolver a quantidade total de leite produzida por semana na fazenda\n");
  printf("2- Devolver a quantidade total de alimento consumido por semana na fazenda\n");
  printf("3- Devolver a quantidade total de leite que vai ser produzido por semana na fazenda, após o abate\n");
  printf("4- Devolver a quantidade total de alimento que vai ser consumido por semana na fazenda, após o abate\n");
  printf("5- Devolver número de cabeças de gado que iram para o abate\n");
  printf("6- Sair\n");
  printf("Dugite a Opcao: \n");
}

void main(){
  Cabeca cabecas[MAX];
  int indice=0;
  int flag=1;
  char op;

  menu();

  do {
    printf(">>> ");
    __fpurge(stdin); scanf("%c", & op);

    switch (op) {

      case '0':{
        if(indice>=MAX){
          printf("Voce ja tem 2000 cabeca cadastrados\n");
          continue;
        }
        inserir(cabecas, indice);
        indice++;
        break;
      };

      case '1':{
        printf("Quatidade: %.2f Litros", semanaLeite(cabecas, indice) );
        break;
      };

      case '2':{
        printf("Quatidade: %.2f Kg", semanaAlimento(cabecas, indice) );
        break;
      };

      case '3':{
        printf("Quatidade: %.2f Litros", semanaLeitePosAbate(cabecas, indice) );
        break;
      };

      case '4':{
        printf("Quatidade: %.2f Kg", semanaAlimentoPosAbate(cabecas, indice) );
        break;
      };

      case '5':{
        printf("Cabecas para o abate: %d unidade", cabecasParaAbate(cabecas, indice) );
        break;
      };

      case '6':{
        flag=0;
        break;
      };

      default:{
        printf("Digite um opcao valida\n");
      };
    }
  }while(flag);
}
