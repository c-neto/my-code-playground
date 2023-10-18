#include <stdio.h>
#include <stdio.h>
#include <locale.h>

int main()
{
	setlocale (LC_ALL,"");
		    
    int ni, nf;
    
	printf("Número inicial: ");
	scanf ("%d", & ni);
	
	printf("Número final: ");
	scanf ("%d", & nf);
	
	for (ni ; ni<=nf ; ni++){
		
		printf("%d\n", ni);
		
	}
	
}
