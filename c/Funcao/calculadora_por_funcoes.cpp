/*
	calculadora por funcoes
*/

#include <stdio.h>
#include <conio.h>
#include <locale.h>

int var_int (){
	
	int var;
	
	printf ("Digite um valor: ");
	fflush(stdin);
	scanf ("%d", & var);
	
	return var;
	
}

float var_float (){
	
	float varf;
	
	printf ("Digite um valor: ");
	fflush(stdin);
	scanf ("%f", & varf);
	
	return varf;
	
}

int somar(){
	
	int n1, n2, r;
	
	n1 = var_int();
	n2 = var_int();
	
	r = n1+n2;
	
	return r;
}

int subtrair(){
	
	int n1, n2, r;
	
	n1 = var_int();
	n2 = var_int();
	
	r = n1-n2;
	
	return r;
}

int multiplicar(){
	
	int n1, n2, r;
	
	n1 = var_int();
	n2 = var_int();
	
	r = n1*n2;
	
	return r;
}

float dividir(){
	
	float n1, n2, r;
	
	n1 = var_float();
	n2 = var_float();
	
	r = n1/n2;
	
	return r;
}

float potencia(){
	
	int b, e, r=1, k=0;

	b = var_int(); 
	e = var_int();
	
	for (k;k<e;k++){
	
		r*=b;			
	
	}
	
	return r;
}

int tabuada (void){

	int f1, r, k;
	
	f1 = var_int();
	
	for (k=0 ; k<=10 ; k++){

		r=f1*k;
		
		printf("%d x ", f1);
		printf("%d ", k);
		printf("= %d\n", r);
		
	}
}


int main (){
	
	int n1, n2, r;
	float rf;
	char i;	
	
	printf ("|a| = Somar \n");
	printf ("|b| = Subtrair \n");
	printf ("|c| = Multiplicar \n");
	printf ("|d| = Dividir \n");
	printf ("|e| = Potencia \n");
	printf ("|f| = Tabuada \n ");
	printf ("|X| = Sair \n \n");	
	
	printf ("Digite o numero referente a operação matemática:  ");	
	scanf ("%c", & i);
	

	if (i=='a'){
		
		printf ("Você escolheu SOMAR \n \n");
		r = somar ();
		printf("Resultado: %d", r);
		
	}
	
	else if (i=='b'){
			
		printf ("Voce escolheu SUBTRAIR \n \n");
		r = subtrair ();
		printf("%d", r);
	
	}
	
	else if (i=='c'){
			
		printf ("Você escolheu MULTIPLICAR \n \n");
		r = multiplicar ();
		printf("Resultado: %d", r);
	
	}
	
	else if (i=='d'){
			
		printf ("Você escolheu DIVIDIR\n \n");
		rf = dividir ();
		printf("Resultado: %f", r);
	
	}

	else if (i=='e'){
			
		printf ("Você escolheu POTÊNCIA \n \n");
		r = potencia ();
		printf("Resultado: %d", r);
	
	}
	
	else if (i=='f'){
			
		printf ("Você escolheu TABUADA \n \n");
		r = tabuada ();
	
	}	
	
	else if (i=='x'){
		
		printf("Você saiu do Programa");
	}
	
		
}
