#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

typedef struct Node* List;
struct Node
{
	int Data;
	bool IsKey;
	List Next;
};

bool exam(List *L,int n,int i);
List calz(List D);
int cmp(const void *a,const void *b);

int main(void)
{
	int n;
	scanf("%d",&n);
	List L[n];
	for(int i=0;i<n;i++)
	{
		L[i]=(List)malloc(sizeof(struct Node));
		scanf("%d",&(L[i]->Data));
		L[i]->IsKey=true;
		L[i]->Next=NULL;
		L[i]=calz(L[i]);
	}
	for(int i=0;i<n;i++)
	{
		if(!exam(L,n,i))
		{
			L[i]->IsKey=false;
		}
	}
	int flag=0;
	int result[n];
	for(int i=0;i<n;i++)
	{
		if(L[i]->IsKey!=false)
		{
			result[flag++]=L[i]->Data;
		}
	}
	qsort(result,flag,sizeof(int),cmp);
	for(int i=0;i<flag;i++)
	{
		if(i==0)
		{
			printf("%d",result[i]);
		}
		else
		{
			printf(" %d",result[i]);
		}
	}
}


bool exam(List *L,int n,int i)
{
	for(int j=0;j<n;j++)
	{
		List ptr=L[j];
		if(L[j]->IsKey==true&&i!=j)
		{
			while(ptr&&L[i]->Data!=ptr->Data)
			{
				ptr=ptr->Next;
			}
			if(ptr!=NULL)
			{
				return false;
			}
		}
	}
	return true;
}
List calz(List D)
{
	int k =D->Data;
	List ptr = D;
	while(k!=1)
	{
		if(k%2==0)
		{
			List temp =(List)malloc(sizeof(struct Node));
			temp->Data=k/2;
			temp->IsKey=false;
			temp->Next=NULL;
			ptr->Next=temp;
			ptr=ptr->Next;
			k=k/2;
		}
		else
		{
			List temp =(List)malloc(sizeof(struct Node));
			temp->Data=(3*k+1)/2;
			temp->IsKey=false;
			temp->Next=NULL;
			ptr->Next=temp;
			ptr=ptr->Next;
			k=(3*k+1)/2;
		}
	}
	return D;
}
int cmp(const void *a,const void *b)
{
	return *(int *)a-*(int *)b ? 1:-1;
}

