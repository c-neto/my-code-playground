#include <stdio.h>

float ak=0;

float fatorial (int num){

	int k=1;
	float f=1;
	
	if (num==0){
		return 1+ak;	
	}
	
	else{
		
		for(k; k<=num ; k++){
			f*=k;	
		}
			
		printf("%d! = %f\n", num, f);
		
		ak+=1/f;
		
		printf("S = %f\n\n", ak);
		
		num-=1;
		fatorial(num);
	}
	
}

int main(){
	
	int n=0;
	
	printf("Digite o range, de 0 a: ");
	scanf("%d", & n);
	
	printf("\n\nS = %f", fatorial(n));
}
