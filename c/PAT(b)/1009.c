#include<stdio.h>
#include<string.h>
#include<stdlib.h>

int main(void)
{
	char s[90];
	fgets(s,81,stdin);
	int n=strlen(s);
	int a=n-1;
	for(int i=n-2;i>=0;i--)
	{
		if(s[i]==' ')
		{
			for(int j=i+1;j<a;j++)
			{
				printf("%c",s[j]);
			}
			if(i!=0)
			{
				printf(" ");
			}
			a=i;
		}
	}
	for(int j=0;j<a;j++)
	{
		printf("%c",s[j]);
	}
}