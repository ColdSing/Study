#include<stdio.h>


int main(void)
{
	char c ='c';
	int flag=0;
	int a,b;
	while(c!='\n')
	{
		scanf("%d %d",&a,&b);
		if(b!=0&&flag==0)
		{
			printf("%d %d",a*b,b-1);
		}
		else if(b!=0&&flag!=0)
		{
			printf(" %d %d",a*b,b-1);
		}
		else if(b==0&&flag==0)
		{
			printf("0 0");
		}
		scanf("%c",&c); 
		flag++;
	}
}

