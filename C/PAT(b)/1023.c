#include<stdio.h>

int main(void)
{
	int N[10];
	int flag=0;
	for(int i=0;i<10;i++)
	{
		scanf("%d",&N[i]);
		if(N[i]!=0&&i>0&&flag==0)
		{
			flag=i;
		}
	}
	printf("%d",flag);
	N[flag]--;
	for(int i=0;i<10;i++)
	{
		for(int j=0;j<N[i];j++)
		{
			printf("%d",i);
		}
	}
}