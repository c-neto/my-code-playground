#include <stdio.h>
#include <stdio.h>

int main()
{
	    
    int k, n=0;

	for (k=1; k<=50 ; k+=2){
		
		printf("%d\n", k);
		n=k+n;	
	}
	
	printf("\nSoma: %d", n);
}
