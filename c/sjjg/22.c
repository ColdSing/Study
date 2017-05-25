#include<stdio.h>
#include<stdlib.h>

typedef int Elementtype;
typedef struct Node* List;
struct Node{
	Elementtype Data[2];
	List Next;
};

List read();
List mult(List l1,List l2);
List add(List l1,List l2);
void printList(List L);

int main(void)
{
	List l1=read();
	List l2=read();
	List l3=mult(l1,l2);
	List l4=add(l1,l2);
	printList(l3);
	printList(l4);
}

List read()
{
	int k;
	scanf("%d",&k);
	List L = (List)malloc(sizeof(struct Node));
	L->Next=NULL;
	List ptr=L;
	for(int i=0;i<k;i++)
	{
		List temp = (List)malloc(sizeof(struct Node));
		temp->Next=NULL;

		scanf("%d",&temp->Data[0]);
		scanf("%d",&temp->Data[1]);
		ptr->Next=temp;
		ptr=ptr->Next;
	}
	return L;
}

List mult(List l1,List l2)
{
	List L = (List)malloc(sizeof(struct Node));
	L->Next=NULL;
	List ptr1=l1->Next;
	List ptr2=l2->Next;
	while(ptr1)
	{
		List temp_L = (List)malloc(sizeof(struct Node));
		temp_L->Next=NULL;
		List ptr3=temp_L;
		ptr2=l2->Next;
		while(ptr2)
		{
			List temp_N = (List)malloc(sizeof(struct Node));
			temp_N->Next=NULL;
			temp_N->Data[0]=(ptr1->Data[0])*(ptr2->Data[0]);
			temp_N->Data[1]=(ptr1->Data[1])+(ptr2->Data[1]);
			ptr3->Next=temp_N;
			ptr3=ptr3->Next;
			ptr2=ptr2->Next;
		}
		L=add(L,temp_L);
		ptr1=ptr1->Next;
	}
	return L;
}

List add(List l1,List l2)
{
	List L = (List)malloc(sizeof(struct Node));
	L->Next=NULL;
	List ptr1=l1->Next;
	List ptr2=l2->Next;
	List ptr3=L;
	while(ptr1&&ptr2)
	{
		List l3 = (List)malloc(sizeof(struct Node));
		l3->Next=NULL;
		if(ptr1->Data[1]>ptr2->Data[1])
		{
			l3->Data[0]=ptr1->Data[0];
			l3->Data[1]=ptr1->Data[1];
			ptr1=ptr1->Next;
		}
		else if(ptr1->Data[1]==ptr2->Data[1])
		{
			l3->Data[0]=ptr1->Data[0]+ptr2->Data[0];
			l3->Data[1]=ptr1->Data[1];
			ptr1=ptr1->Next;
			ptr2=ptr2->Next;
		}
		else
		{
			l3->Data[0]=ptr2->Data[0];
			l3->Data[1]=ptr2->Data[1];
			ptr2=ptr2->Next;
		}
		ptr3->Next=l3;
		ptr3=ptr3->Next;
	}
	while(ptr1)
	{
	    List l3 = (List)malloc(sizeof(struct Node));
		l3->Next=NULL;
		l3->Data[0]=ptr1->Data[0];
		l3->Data[1]=ptr1->Data[1];
		ptr3->Next=l3;
		ptr3=ptr3->Next;
		ptr1=ptr1->Next;
	}
	while(ptr2)
	{
	    List l3 = (List)malloc(sizeof(struct Node));
		l3->Next=NULL;
		l3->Data[0]=ptr2->Data[0];
		l3->Data[1]=ptr2->Data[1];
		ptr3->Next=l3;
		ptr3=ptr3->Next;
		ptr2=ptr2->Next;
	}
	return L;
}

void printList(List L)
{
	List ptr=L->Next;
	if(!ptr)
	{
		printf("0 0\n");
	}
	while(ptr)
	{
		if(ptr->Next)
		{
			printf("%d %d ",ptr->Data[0],ptr->Data[1]);
		}
		else
		{
			printf("%d %d\n",ptr->Data[0],ptr->Data[1]);
		}
		ptr=ptr->Next;
	}
}