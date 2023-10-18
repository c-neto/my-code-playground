#include<stdio.h>
#include<conio.h>
#include<locale.h>

int main (void)

{
	
	float capTanque, medCons, autonomia;

	printf ("Indique a capacidade total do tanque de combustível do seu Veiculo em litros:\n" ,setlocale(LC_ALL,""));
	scanf ("%f", & capTanque);

	printf ("\nEm um KM, seu carro gasta quantos litros de Combustível: \n");
	scanf ("%f", & medCons);

	autonomia = capTanque*medCons;

	printf ("\nA autonomia do seu veículo é de: %.2f", autonomia);
	printf ("KM \nOu seja, seu veículo com o tanque cheio, Consiguirá porcorrer em média %.0f KM", autonomia);
	
}
