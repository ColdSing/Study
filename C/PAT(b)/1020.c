#include<stdio.h>
#include<stdlib.h>
typedef struct mooncake{
	float storage;
	float total;
	float price;
}MC;

int cmp(const void *a,const void *b);

int main(void)
{
	int N,D;
	scanf("%d %d",&N,&D);
	MC mc[N];
	for(int i=0;i<N;i++)
	{
		scanf("%f",&(mc[i].storage));
	}
	for(int i=0;i<N;i++)
	{
		scanf("%f",&(mc[i].total));
		mc[i].price = mc[i].total/mc[i].storage;
	}
	qsort(mc,N,sizeof(mc[0]),cmp);
	float sum=0;
	for(int i=0;i<N;i++)
	{
		if(D>=mc[i].storage)
		{
			sum+=mc[i].total;
			D-=mc[i].storage;
		}
		else
		{
			sum+=(D/mc[i].storage)*mc[i].total;
			break;
		}
		if(D<=0)
		{
			break;
		}
	}
	printf("%.2f\n",sum);
}

int cmp(const void *a,const void *b)
{
	MC *aa=(MC *)a;
	MC *bb=(MC *)b;
	return aa->price>bb->price ? -1:1;
}