#include <stdio.h>
#include <stdio.h>
#include <locale.h>

int main()
{
	setlocale (LC_ALL,"");
	    
    int a, pa, pb, ppa, ppb;

	printf("Digite o numero da população A: ");
    scanf ("%d", & pa);
    
    printf("Digite o percentual de crescimento por ano da população A (em %%): ");
    scanf ("%d", & ppa);

    printf("Digite o numero da população B: ");
    scanf ("%d", & pb);
    
    printf("Digite o percentual de crescimento por ano da população B (em %%): ");
    scanf ("%d", & ppb);
    
    ppa = (pa*ppa)/100;
    ppb = (pb*ppb)/100;
    
 
    while (pa<pb){
	
	    pa = ppa+ppb;
	    pb = ppa+ppb;
	    a=a+1;
	    
	}

	while (pb<pa){
	
	    pa = ppa+ppb;
	    pb = ppa+ppb;
	    a=a+1;
	    
	}
    
    
    if (pa == pb && ppa == ppb){
    	
    	printf("Dados Iguais\n");
	}
	
	printf ("Quantidade de Anos: %d", ppa);

	  
}
