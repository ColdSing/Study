#include<stdio.h>
#include<stdlib.h>

typedef struct Node *List;
struct Node{
	int Data;
	char Address[6];
	char NextAddress[6];
	List Next;
};

List read(List Nd,int* n,char *f);
List revers(List N,List L,int n,int k);
void print(List L,int n);

int main(void)
{
	char first[6];
	int n;
	int k;
	scanf("%s %d %d",first,&n,&k);
	struct Node Nd[n];
	List L= read(Nd,&n,first);
	struct Node New[n];
	List Back=revers(New,L,n,k);
	print(Back,n);
}

List read(List Nd,int *n,char *f)
{
	for(int i=0;i<n;i++)
	{
		scanf("%s %d %s",Nd[i].Address,&(Nd[i].Data),Nd[i].NextAddress);
		if(atoi(Nd[i].Address)==atoi(f))
		{
			struct Node temp = Nd[0];
			Nd[0]=Nd[i];
			Nd[i]=temp;
		}
	}
	temp=1;
	for(int i=1;i<n;i++)//n-2次调换
	{
		for(int j=i;j<n;j++)
		{
			if(atoi(Nd[i-1].NextAddress)==atoi(Nd[j].Address))
			{
				struct Node temp = Nd[i];
				Nd[i]=Nd[j];
				Nd[j]=temp;
				temp++;
				break;
			}
		}
	}
	n=temp;
	return Nd;
}

List revers(List N,List L,int n,int k)
{
	if(k>n)
	{
		return L;
	}
	else
	{
		int m =n/k;
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<k;j++)
			{
				N[(i+1)*k-1-j]=L[i*k+j];
			}
		}
		for(int i=m*k;i<n;i++)
		{
			N[i]=L[i];
		}
		return N;
	}
	
}

void print(List L,int n)
{
	for(int i=0;i<n-1;i++)
	{
		printf("%s %d %s\n",L[i].Address,L[i].Data,L[i+1].Address);
	}
	printf("%s %d -1\n",L[n-1].Address,L[n-1].Data);
}

