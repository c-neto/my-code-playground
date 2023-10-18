/*
	Turma por idade..
*/
#include<stdio.h>
#include<conio.h>
#include <locale.h> //setlocale(LC_ALL,""); 

int main (void)
{
  
	setlocale(LC_ALL,""); 
  
 	int id1, id2, id3, med_id, tur_jov, tur_adu, tur_ido;
  
 	printf ("Informe a primeira idade: ");
  	scanf ("%d", & id1);
  	
  	printf ("Informe a segunda idade: ");
  	scanf ("%d", & id2);
  	
  	printf ("Informe a terceira idade: ");
  	scanf ("%d", & id3);
  	
  	med_id = (id1+id2+id3)/3;
  	
  	
	if (med_id<25)
	{
		printf("Turma Jovem %d", med_id);
	}
	
	else 
	{
		
		if (med_id>=25 && med_id<=40)
		{
			printf ("Turma Adulta");
		}
		
		else 
		{
			printf ("Turma Idosa");
		
		}
	}
}	
	

  
