#include<stdio.h>
#include<stdlib.h>

void populaVetor(int vetor[]){

  for(int k=0 ; k<100 ; k++){
    vetor[k]=rand()%100;
  }

}

void printVetor(int vetor[]){

  for(int k=0 ; k<100 ; k++){
    printf("Vetor[%d]: \t%d\n", k, vetor[k]);
  }

}

int buscaMenor(int vetor[], int *indice){
  int menor=vetor[0];

  for(int k=0 ; k<100 ; k++){
    if (menor>vetor[k]){
      menor=vetor[k];
      *indice=k;
    }
  }
  return menor;
}

void main() {

  int vetor[100];
  int indice;
  char opcao;

  populaVetor(vetor);
  printf("Menor valor do vetor é: %d\n", buscaMenor(vetor, &indice));
  printf("Ele se encontra no indice: %d\n\n", indice);
  printf("Deseja varrer o vetor? [y]/[n]\n");
  scanf("%c", & opcao);

  if (opcao=='y'){
    printVetor(vetor);
  }
}
