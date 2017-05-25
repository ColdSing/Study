#include<stdio.h>

int main(void)
{
	int num[104730];
	for(int i=0;i<104730;i++)
	{
		num[i]=1;
	}
	int m,n;
	scanf("%d %d",&m,&n);
	int count=0;
	int p=0;
	for(int i=2;i<104730;i++)
	{
		if(num[i])
		{
			p++;
			for(int j=2;i*j<104730;j++)
			{
				num[i*j]=0;
			}
			if(p>=m&&p<n&&count!=9)
			{
				printf("%d ",i);
				count++;
			}
			else if(p>=m&&p<n&&count==9)
			{
				printf("%d\n",i);
				count=0;
			}
			else if(p==n)
			{
				printf("%d",i);
			}
		}
	}
}