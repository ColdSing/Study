#include<stdio.h>
#include<stdlib.h>
#include<string.h>


int read();
void print(int n);

int main(void)
{
	int n =read();
	print(n);
}

int read()
{
	char k;
	scanf("%1c",&k);
	int sum=0;
	while(k !='\n')
	{
		sum =sum+k-'0';
		scanf("%1c",&k);
	}
	return sum;
}

void print(int n)
{
	char *num[10];
	num[0] =(char*)malloc(sizeof(char)*5);
	num[0]="ling";
	num[1] =(char*)malloc(sizeof(char)*3);
	num[1]="yi";
	num[2] =(char*)malloc(sizeof(char)*3);
	num[2]="er";
	num[3] =(char*)malloc(sizeof(char)*4);
	num[3]="san";
	num[4] =(char*)malloc(sizeof(char)*3);
	num[4]="si";
	num[5] =(char*)malloc(sizeof(char)*5);
	num[5]="wu";
	num[6] =(char*)malloc(sizeof(char)*4);
	num[6]="liu";
	num[7] =(char*)malloc(sizeof(char)*3);
	num[7]="qi";
	num[8] =(char*)malloc(sizeof(char)*3);
	num[8]="ba";
	num[9] =(char*)malloc(sizeof(char)*4);
	num[9]="jiu";
	char s[5];
	sprintf(s,"%d",n);
	for(int i=0;i<strlen(s);i++)
	{
		if(i==0)
		{
			printf("%s",num[s[i]-'0']);
		}
		else
		{
			printf(" %s",num[s[i]-'0']);

		}
	}
}