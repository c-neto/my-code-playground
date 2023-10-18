#include <stdio.h>
#define MAX 100

void verifica(int a, int b, int *som, int *mul){
	*som=a+b;
	*mul=a*b;	
}

int main(){

    int x, y, soma, multi;
    
    printf("Digite o valor X: ");
    scanf("%d", & x);
    
    printf("Digite o valor Y: ");
    scanf("%d", & y);
    
    verifica(x, y, &soma, &multi);
    
    printf("Soma: %d\nMultiplicacao: %d", soma, multi);

}
