#include<stdio.h>
#include<stdlib.h>
#include<string.h>

int main(void)
{
	char A[1001],* p=A;
	int B;
	scanf("%s %d",A,&B);
	int n=strlen(A);
	int a=0;
	for(int i=0;i<n;i++)
	{
		int b =a*10+A[i]-'0';
		A[i]=(char)(b/B+'0');
		a=b%B;
	}
	if(A[0]=='0'&&A[1] != '\0') p++;
	printf("%s %d",p,a);
}