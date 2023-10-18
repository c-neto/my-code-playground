#include<stdio.h>

int main(){

	int x=10, y=3;

	float COM_casting = x/y;
	float SEM_casting = (float)x/y;

	printf("COM Casting %f\n", COM_casting);
	printf("SEM Casting %f", SEM_casting);

}
