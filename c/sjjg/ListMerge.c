typedef struct Node *PtrToNode;
struct Node {
    ElementType Data; /* 存储结点数据 */
    PtrToNode   Next; /* 指向下一个结点的指针 */
};
typedef PtrToNode List; /* 定义单链表类型 */

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
	return L3;
}
