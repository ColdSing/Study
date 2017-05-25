#include<stdio.h>
#include <inttypes.h>
void exam(long int a,long int b,long int c,int d);

int main(void)
{
	int n;
	scanf("%d",&n);
	long int a,b,c;
	for(int i=0;i<n;i++)
	{
		scanf("%ld %ld %ld",&a,&b,&c);
		exam(a,b,c,i+1);
	}
}
void exam(long int a,long int b,long int c,int d)
{
	if(a+b>c)
	{
		printf("Case #%d: true\n",d);
	}
	else
	{
		printf("Case #%d: false\n",d);
	}
}