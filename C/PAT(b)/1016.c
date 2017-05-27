#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int part(int A,int DA);

int main (void)
{
	int A,DA,B,DB;
	scanf("%d %d %d %d",&A,&DA,&B,&DB);
	printf("%d",part(A,DA)+part(B,DB));
	return 0;
}

int part(int A,int DA)
{
	int PA=0;
	char s[12];
	sprintf(s,"%d",A);
	int count=1;
	for(int i=0;i<strlen(s);i++)
	{
		if(s[i]-'0'==DA)
		{
			PA=PA+count*DA;
			count*=10;
		}
	}
	return PA;
}