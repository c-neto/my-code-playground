#include <stdio.h>
#include <string.h>
#define MAX 20

typedef struct {
  char marca[15];
  char cor[10];
  int ano;
  float preco;
}Carro;

void lerCarros(Carro carros[], int indice){
  int k;
  for (k=0 ; k<indice ; k++){
    printf("Carro[%d]\n", k);
    printf("\tMarca: %s", carros[k].marca);
    printf("\tcor: %s", carros[k].cor);
    printf("\tAno: %d\n", carros[k].ano);
    printf("\tPreco: %.2f\n", carros[k].preco);
  }
}

void lerMarca(Carro carros[], char marca[], int indice){
  int k;
  for (k=0 ; k<indice ; k++){
    if ((strcmp(marca, carros[k].marca))==0){
      printf("Carro[%d]\n", k);
      printf("\tMarca: %s\n", carros[k].marca);
      printf("\tcor: %s\n", carros[k].cor);
      printf("\tAno: %d\n", carros[k].ano);
      printf("\tPreco: %f\n\n", carros[k].preco);
    }
  }
}

float pesquisarCarro(Carro carros[], Carro carro, int indice){
  float preco=0;
  int k=0;
  for (k=0 ; k<indice ; k++){
    if( ((strcmp(carro.marca, carros[k].marca))==0) &&
    ((strcmp(carro.cor, carros[k].cor))==0) &&
    ( carro.ano==carros[k].ano )){
      preco = carros[k].preco;
    }
  }
  return preco;
}

Carro criarCarro(){
  Carro carro;
  printf("Entre com a marca do carro: ");
  __fpurge(stdin); fgets(carro.marca, 15 , stdin);

  printf("Entre com o cor do carro: ");
  __fpurge(stdin); fgets(carro.cor, 10 , stdin);

  printf("Entre a data de fabricacao do carro: ");
  __fpurge(stdin); scanf("%d", &carro.ano);

  printf("Entre com o preco do carro: R$ ");
  __fpurge(stdin); scanf("%f", &carro.preco);

  return carro;
}

void inserirCarros(Carro carros[],int k){
  carros[k] = criarCarro();
}

void menu(){
  printf("1 - Inserir carro\n");
  printf("2 - Ler carros\n");
  printf("3 - Buscar Marca\n");
  printf("4 - Buscar Carro\n");
  printf("5 - Sair\n");
  printf("Digite a opcao: \n");
}

void main(){
  int indice=0;
  char op;
  int flag = 1;
  Carro carros[MAX];

  menu();
  do {
    __fpurge(stdin); scanf("%c", & op);

    switch (op) {
      case '1':{
        if (indice>=MAX){
          printf("Voce ja tem 20 Carros cadastrados\n");
          continue;
        }

        inserirCarros(carros, indice);
        indice++;
        break;
      };

      case '2':{
        lerCarros(carros, indice);
        break;
      };

      case '3':{
        char marca[10];
        __fpurge(stdin); fgets(marca,10,stdin);
        lerMarca(carros, marca, indice);
        break;
      };

      case '4':{
        Carro carro = criarCarro();

        if (pesquisarCarro(carros, carro, indice) == 0){
          printf("Nao temos esse carro com estas especificacoes\n");
        }
        else{
          printf("Preco: R$ %.2f\n", pesquisarCarro(carros, carro, indice));
        }
        break;
      };

      case '5':{
        flag=0;
        break;
      };

      default:{
        printf("Digite um opcao valida\n");
      };

    }
  }while(flag);
}
