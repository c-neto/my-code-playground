/*
Soma, Subtração e Adição de Fração 
COM STRUCT
*/

#include <stdio.h>

struct frac{
	int den;
	int num;
};

void exibefracao(struct frac FracaoA){
	printf("%d/%d\n\n", FracaoA.num, FracaoA.den);
};

struct frac subtrai(struct frac FracaoA, struct frac FracaoB){
	struct frac subt;
	subt.num = (FracaoA.num * FracaoB.den) - (FracaoB.num * FracaoA.den);
	subt.den = FracaoB.den * FracaoA.den;
	return subt;
};

struct frac somafracao(struct frac FracaoA, struct frac FracaoB){
	struct frac soma;
	soma.num = (FracaoA.num * FracaoB.den) + (FracaoB.num * FracaoA.den);
	soma.den = FracaoA.den * FracaoB.den;
	return soma;
};

struct frac multiplica(struct frac FracaoA, struct frac FracaoB){
	struct frac produto;
	produto.num = FracaoA.num * FracaoB.num;
	produto.den = FracaoA.den * FracaoB.den;
	return produto;
};

int main(){

	struct frac FRACAO_A;
	struct frac FRACAO_B;

	printf("Fracao A:\n");
	printf("Digite o Numerador: ");
	scanf("%d", & FRACAO_A.num);

	printf("Digite o Denominador: ");
	scanf("%d", & FRACAO_A.den);

	printf("\nFracao B:\n");
	printf("Digite o Numerador: ");
	scanf("%d", & FRACAO_B.num);

	printf("Digite o Denominador: ");
	scanf("%d", & FRACAO_B.den);

	printf("PRODUTO:\n");
	exibefracao( multiplica(FRACAO_A , FRACAO_B) );

	printf("SOMA:\n");
	exibefracao( somafracao(FRACAO_A , FRACAO_B) );

	printf("SUBTRACAO\n");
	exibefracao( subtrai(FRACAO_A , FRACAO_B) );
}
