#include<stdio.h>
int main(void)
{
	int n;
	scanf("%d",&n);
	int IsPrime[n];
	IsPrime[0]=0;
	for(int i=1;i<n;i++)
	{
		IsPrime[i]=1;
	}
	for(int i=1;i<n;i++)
	{
		if(IsPrime[i])
		{
			for(int m=2;m*(i+1)<=n;m++)
			{
				IsPrime[m*(i+1)-1]=0;
			}
		}
	}
	int flag=0;
	int a=2;
	int b;
	for(int i=1;i<n;i++)
	{
		if(IsPrime[i])
		{
			b=i+1;
			if(b-a==2)
			{
				flag++;
			}
			a=b;
		}
	}
	printf("%d\n",flag);
}