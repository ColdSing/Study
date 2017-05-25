#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

void kick(int n,bool *B);
int cmp(const void *a,const void *b);

int main(void)
{
	int n;
	bool IsKey[101];
	for(int i=0;i<101;i++)
	{
		IsKey[i]=true;
	}
	scanf("%d",&n);
	int num[n];
	for(int i=0;i<n;i++)
	{
		scanf("%d",&num[i]);
		kick(num[i],IsKey);
	}
	qsort(num,n,sizeof(num[0]),cmp);
	int flag=0;
	for(int i=n-1;i>=0;i--)
	{
		if(IsKey[num[i]])
		{
			if(flag==0)
			{
				printf("%d",num[i]);
			}
			else
			{
				printf(" %d",num[i]);
			}
			flag++;
		}
	}
	
}

void kick(int n,bool *B)
{
	int t=n;
	while(n!=1)
	{
		if(B[t])
		{
			if(n%2==0)
			{
				n=n/2;
				if(n<=100)
				{
					B[n]=false;
				}
			}
			else
			{
				n=(3*n+1)/2;
				if(n<=100)
				{
					B[n]=false;
				}
			}
		}
		else
		{
			break;
		}
	}
}

int cmp(const void *a,const void *b)
{
	return *(int*)a > *(int*)b ? 1:-1;
}