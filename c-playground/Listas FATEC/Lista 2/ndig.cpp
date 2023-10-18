#include <stdio.h>

int main(){
 
    int c, i;			 //
    int ndig[10];		// Vetor de 10 posicoes
 
    for(i=0;i<10;i++){  // Loop que faz o input no vetor ndig [10] {0,1,2,3,4,5,6,7,8,9}
		ndig[i]=0;		// Estou zerando cada posicao do vetor, para nao pegar lixo
    } 	
 
/* 
	getchar pega APENAS UM digito, e enquanto for diferente de 10, que na tabela ASCII eh o "\n" (enter);
	ou seja, vai lendo os numeros ate voce clicar enter. 
	se estou utilizando getchar, por sí ele nao consegue identificar se eh numero letra, pois nao tem mascara
	como no scanf... 
*/	  								
 
    while ( (c=getchar() )!= 10 ) { 
    
		if (c>='0' && c<='9'){		// verifica se o numero digitado NA TABELA ASCII vale entre 0=48 e 9=57
			++ ndig[c-'0'];			// pega o numero digitado, e fazer menos -48 (decimal) 
    	}
    	
	}
 
    for(i=0;i<10;++i){
	     printf("digito:%d :%d ocorrencia\n",i,ndig[i]);    
	}
    
	getchar();
}
