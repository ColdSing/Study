#include <stdio.h>

int main(void)
{
	int n,m;
	scanf("%d %d",&n,&m);
	int A[n];
	m=m%n;
	for(int i=0;i<n;i++)
	{
		if(i+m<n)
		{
			scanf("%d",&A[i+m]);
		}
		else
		{
			scanf("%d",&A[i+m-n]);
		}
	}
	for(int i=0;i<n;i++)
	{
		if(i==0)
		{
			printf("%d",A[i]);
		}
		else
		{
			printf(" %d",A[i]);
		}
	}
}