#include<stdio.h>
#include<conio.h>
#include<locale.h>

int main (void)

{

	float r, pi, d, a, r2, per;

	setlocale(LC_ALL,"");

	pi = 3.141516;
	
	
	printf ("Indique o raio do Círculo em CM: ");
	scanf ("%f", & r);

	r2 = r*r;
	a = pi*r2;
	d = r+r;
	per = 2*pi*r;

	printf ("Área do Círculo: %.2f", a);
	printf (" CM²");
	printf ("\nDiâmetro: %.2f", d);
	printf (" CM");
	printf ("\nPerímetro: %.2f", per);
	printf (" CM");


}
