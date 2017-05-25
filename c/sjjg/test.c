#include <stdio.h>
#include <stdlib.h>

typedef int ElementType;
typedef struct Node *PtrToNode;
struct Node {
    ElementType Data;
    PtrToNode   Next;
};
typedef PtrToNode List;

List Read(); /* 细节在此不表 */
void Print( List L ); /* 细节在此不表；空链表将输出NULL */

List Merge( List L1, List L2 );

int main()
{
    List L1, L2, L;
    L1 = Read();
    L2 = Read();
    L = Merge(L1, L2);
    Print(L);
    Print(L1);
    Print(L2);
    return 0;
}

/* 你的代码将被嵌在这里 */
List Merge( List L1, List L2 )
{
	List ptr1=L1->Next;
	List ptr2=L2->Next;
	List L3 = (List)malloc(sizeof(struct Node));
	L3->Next = NULL;
	List ptr3 = L3;
	while(ptr1&&ptr2)
	{
		if(ptr1->Data < ptr2->Data)
		{
			ptr3->Next = ptr1;
			ptr1=ptr1->Next;
		}
		else
		{
			ptr3->Next = ptr2;
			ptr2=ptr2->Next;
		}
		ptr3=ptr3->Next;
	}
	if(ptr1)
	{
		ptr3->Next = ptr1;
	}
	if(ptr2)
	{
		ptr3->Next = ptr2;
	}
	L1->Next=NULL;
	L2->Next=NULL;
	return L3;
}
List Read()
{
	int k;
	scanf(%d,&k);
	List L=(List)malloc(sizeof(struct Node));
	L->Next=NULL;
	List ptr = L;
	for(int i=0;i<k;i++)
	{
		List temp =(List)malloc(sizeof(struct Node));
		scanf(%d,&(temp->Data));
		temp->Next=NULL;
		ptr->Next=temp;
		ptr=ptr->Next;
	}
	return L;
}

void Print( List L )
{
	List ptr = L->Next;
	if(!ptr)
	{
		printf("NULL\n");
	}
	while(ptr)
	{
		printf("%d",ptr->Data);
		ptr=ptr->Next;
	}
}