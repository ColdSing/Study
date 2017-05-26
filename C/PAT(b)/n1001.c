#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

typedef struct Node{
	int colum;
	int row;
	int num;
}ND;

int cmp(const void *a,const void *b);
int step(int x1,int y1,int x2,int y2);
bool out(int x,int step);


int main (void)
{
	int M,N,K;
	scanf("%d %d %d",&M,&N,&K);
	ND P[M*N];
	int count=0;
	int a;
	for(int i=0;i<M;i++)
	{
		for(int j=0;j<N;j++)
		{
			scanf("%d",&a);
			if(a!=0)
			{
				P[count].num=a;
				P[count].row=i;
				P[count].colum=j;
				count++;
			}
		}
	}
	qsort(P,count,sizeof(P[0]),cmp);
	if(P[0].row*2+3>K)
	{
		printf("0\n");
		return 0;
	}
	int steps=P[0].row+2;
	int sum=P[0].num;
	for(int i=1;i<count;i++)
	{
		steps=steps+1
		+step(P[i-1].row,P[i-1].colum,P[i].row,P[i].colum);
		if(!out(P[i-1].row,K-steps))
		{
			break;
		}
		else
		{
			sum+=P[i].num;
		}
	}
	printf("%d\n",sum);
}

int cmp(const void *a,const void *b)
{
	ND *aa=(ND *)a;
	ND *bb=(ND *)b;
	return bb->num-aa->num;
}

int step(int x1,int y1,int x2,int y2)
{
	return abs(x2-x1)+abs(y2-y1);
}

bool out(int x,int step)
{
	return (step>x+1);
}
