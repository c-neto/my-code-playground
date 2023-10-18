#include <stdio.h>
#include <string.h>
#define MAX 100

typedef struct{
  char nome[15];
  char setor;
  int quantidade;
  float preco;
}Produto;

void lerProdutos(Produto produtos[], int indice){
  int k;
  for (k=0 ; k<indice ; k++){
    printf("Produto[%d]\n", k);
    printf("\tNome: %s", produtos[k].nome);
    printf("\tSetor: %c", produtos[k].setor);
    printf("\tQuantidade: %d\n", produtos[k].quantidade);
    printf("\tPreco: %.2f\n", produtos[k].preco);
  }
}

int verificarSetor(Produto produtos[], char setor, int indice){
  int j, k, diferentes=1;

  for (j=1 ; j<indice ; j++) {

    for (k=0 ; k<=j ; k++) {

      if ((strcmp(produtos[j].nome, produtos[k].nome))==0){
        break;
      }
      if(k==j-1){
        diferentes+=1;
      }

    }

  }
  return diferentes;
}

void inserir(Produto produtos[], int indice){
  printf("Produto[%d]\n", indice);

  printf("\n\tNome: ");
  __fpurge(stdin); fgets(produtos[indice].nome, 15 , stdin);

  printf("\n\tSetor: ");
  __fpurge(stdin); scanf("%c", &produtos[indice].setor);

  printf("\n\tQuantidade: ");
  __fpurge(stdin); scanf("%d", &produtos[indice].quantidade);

  printf("\n\tPreco: R$ ");
  __fpurge(stdin); scanf("%f", &produtos[indice].preco);

}

float capitalTotal(Produto produtos[], int index){
  float ak=0;
  int k;
  for (k = 0; k < index; k++) {
    ak+=produtos[k].preco*produtos[k].quantidade;
  }
  return ak;
}

void menu(){
  printf("0- Inserir Produto\n");
  printf("1- Ler o vetor estoque\n");
  printf("2- Recebe um setor e devolve o número de diferentes produtos desse setor\n");
  printf("3- Calcula e devolva o total de capital investido em produtos do supermercado\n");
  printf("4- Sair do Programa\n");
  printf("Digite a Opcao: \n");
}

void main(){
  Produto produtos[MAX];
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
          printf("Voce ja tem 100 produtos cadastrados\n");
          continue;
        }
        inserir(produtos, indice);
        indice++;
        break;
      };

      case '1':{
        lerProdutos(produtos, indice);
        break;
      };

      case '2':{
        char setor;
        printf("Setor: ");
        __fpurge(stdin); scanf("%c", &setor);
        printf("Produtos diferentes (variedade): %d\n", verificarSetor(produtos, setor, indice));
        break;
      };

      case '3':{
        printf("Capital: R$ %.2f\n", capitalTotal(produtos, indice));
        break;
      };

      case '4':{
        flag=0;
        break;
      };

      default:{
        printf("Digite um opcao valida\n");
      };
    }
  }while(flag);
}
