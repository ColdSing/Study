#include <stdio.h>
#include <stdlib.h>

void output(int n,int m);


int main(void)
{
	char num[4];
	int k;
	scanf("%d",&k);
	sprintf(num,"%03d",k);
	output(num[0]-'0',1);
	output(num[1]-'0',2);
	output(num[2]-'0',3);
}

void output(int n,int m)
{
	if(m==1)
	{
		for(int i=0;i<n;i++)
		{
			printf("%c",'B');
		}
	}
	else if(m==2)
	{
		for(int i=0;i<n;i++)
		{
			printf("%c",'S');
		}
	}
	else
	{
		for(int i=0;i<n;i++)
		{
			printf("%d",i+1);
		}
	}
}
