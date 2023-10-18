#include <stdio.h>
#include <stdlib.h>

void multsoma(int a, int b, int *soma, int *mult){
	*soma = a + b;
	*mult = a * b;
}

void zera_vetor(int *vetor, int cont){
	if(!cont)

	return;

	*vetor = 0;

	return zera_vetor(vetor+1, cont-1);
}

int main()
{
	int i, *pi, **ppi, m, s, vetor[10];
	
	i = 10;
	
	pi = &i;
	
	ppi = &pi;
	
	printf("i = %d\n", i);
	printf("&i = %p\n", &i);
	
	printf("\n\npi = %p\n", pi);
	printf("&pi = %p\n", &pi);
	printf("*pi = %d\n", *pi);
	
	printf("\n\nppi = %p\n", ppi);
	printf("&ppi = %p\n", &ppi);
	printf("*ppi = %p\n", *ppi);
	
	multsoma(3, 5, &s, &m);
	
	printf("\n\nsoma = %d\nmult = %d\n", s, m);
	
	for(i = 0; i < 10; i++)
		printf("vetor[%d] = %d\n", i, vetor[i]);
	
	zera_vetor(vetor, 10);
	
	for(i = 0; i < 10; i++)
		printf("vetor[%d] = %d\n", i, vetor[i]);

	return 0;
}
