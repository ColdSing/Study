#include<stdio.h>

int main (void)
{
	int A,B;
	int D;
	scanf("%d %d %d",&A,&B,&D);
	int C=A+B;
	int power=1;
	while(C/power>=D)
	{
		power*=D;
	}
	for(;power>0;power/=D)
	{
		printf("%d",C/power);
		C=C%power;
	}
	return 0;
}