#include<stdio.h>

int main(void)
{
	int n;
	scanf("%d",&n);
	int step=0;
	while(n!=1)
	{
		if(n%2==0)
		{
			n=n/2;
		}
		else
		{
			n=(3n+1)/2;
		}
		step++;	
	}
	printf("%d",step);
}