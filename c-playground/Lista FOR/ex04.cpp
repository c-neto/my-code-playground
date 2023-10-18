#include <stdio.h>
#include <stdio.h>

int main()
{
    
    int a, pa=80000, pb=200000;
    
    while(pa<pb){
    	
    	pa=pa+(pa*0.3);
    	pb=pb+(pb*0.15);
    	a=a++;
	}
    
    
    printf ("Quantidade de Anos: %d", a);

  
}
