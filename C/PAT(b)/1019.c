#include<stdio.h>
#include<stdlib.h>
#include<string.h>

void printhole(char *N);
int cmp1(const void *a,const void *b);
int cmp2(const void *a,const void *b);

int main(void)
{
	int n;
	char num[5];
	scanf("%d",&n);
	sprintf(num,"%04d",n);
	printhole(num);
}


void printhole(char *N)
{
	qsort(N,4,sizeof(N[0]),cmp1);
	int a=atoi(N);
	qsort(N,4,sizeof(N[0]),cmp2);
	int b=atoi(N);
	printf("%04d - %04d = %04d\n",a,b,a-b);
	if(a!=b&&a-b!=6174)
	{
		char S[5];
		sprintf(S,"%04d",a-b);
		printhole(S);
	}
}
int cmp1(const void *a,const void *b)
{
	return *(char*)b-*(char*)a;
}
int cmp2(const void *a,const void *b)
{
	return *(char*)a-*(char*)b;
}
