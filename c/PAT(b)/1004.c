#include <stdio.h>
#include <stdlib.h>

typedef struct student
{
	char name[11];
	char num[11];
	int score;
}STU;

int cmp(const void *a,const void *b);

int main(void)
{
	int n;
	scanf("%d",&n);
	STU st[n];
	for(int i=0;i<n;i++)
	{
		scanf("%s %s %d",st[i].name,st[i].num,&(st[i].score));
	}
	qsort(st,n,sizeof(st[0]),cmp);
	printf("%s %s\n",st[n-1].name,st[n-1].num);
	printf("%s %s\n",st[0].name,st[0].num);
}

int cmp(const void *a,const void *b)
{
	STU *aa=(STU *)a;
	STU *bb=(STU *)b;
	return aa->score>bb->score ? 1:-1;
}