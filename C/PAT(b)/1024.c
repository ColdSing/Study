#include<stdio.h>
#include<stdlib.h>
#include<string.h>

int main(void)
{
	char num[1000];
	scanf("%s",num);
	int lenth = strlen(num);
	int e;
	for(int i=0;i<lenth;i++)
	{
		if(num[i]=='E')
		{
			e=i;
			break;
		}
	}
	char temp[lenth-e-2];
	for(int i=0;i<lenth-e-2;i++)
	{
		temp[i]=num[e+2+i];
	}
	int zs =atoi(temp);
	if(num[0]=='-')
	{
		printf("-");
	}
	if(num[e+1]=='-')
	{
		
	}
}