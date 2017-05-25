#include <stdio.h>
#include <stdlib.h>

void max_list(int l[],int size);

int main(void)
{
	int k;
	scanf("%d",&k);
	if(k<=0 || k>100000)
	{
		printf("k为不大于100000的正整数\n");
		return 1;
	}
	else
	{
		int NI[k];
		for(int i=0;i<k;i++)
		{
			scanf("%d",&NI[i]);
		}
		max_list(NI,k);
		return 0;
	}
}

void max_list(int l[],int size)
{
	int max = 0;
	int sum = 0;
	int node = 0;
	int first = l[0];
	int last=l[size-1];
	for(int i=0;i<size;i++)
	{
		sum +=l[i];
		if(sum > max ||(sum >= max && sum==0))
		{
			max = sum;
			last = l[i];
			first = l[node];
		}
		if(sum < 0)
		{
			sum=0;
			node = i+1;
		
		}
	}
	printf("%d %d %d\n",max,first,last) ;
}