#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<stdbool.h>

bool exam(char *s);
int main (void)
{
	char s[102];
	int k;
	scanf("%d",&k);
	for(int i=0;i<k;i++)
	{
		scanf("%s",s);
		if(exam(s))
		{
			printf("YES\n");
		}
		else
		{
			printf("NO\n");
		}
	}
}

bool exam(char *s)
{
	int a=0;
	int b=0;
	int c=0;
	for(int i=0;i<strlen(s);i++)
	{
		if(s[i]!='A'&&s[i]!='P'&&s[i]!='T')
		{
			return false;
		}
		if(s[i]=='P')
		{
			a=i;
		}
		if(s[i]=='T')
		{
			b=i;
		}
	}
	c=strlen(s)-b-1;
	b=b-a-1;
	if(b>0&&c==a*b)
	{
		return true;
	}
	else
	{
		return false;
	}
	
}