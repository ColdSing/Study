#include<stdio.h>
#include<stdlib.h>
int game(char a,char b);
char max(int*A);

int main(void)
{
	int N;
	scanf("%d",&N);
	while(getchar() != '\n');//使用scanf("%c %c",&a,&b);好帮手
	int A[75],B[75];
	A[(int)'C']=0;
	A[(int)'B']=0;
	A[(int)'J']=0;
	B[(int)'C']=0;
	B[(int)'B']=0;
	B[(int)'J']=0;
	for(int i=0;i<N;i++)
	{
		char a,b;
		scanf("%c %c",&a,&b);//可以尝试使用fgets(line, 5, stdin);
		while(getchar() != '\n');
		if(game(a,b)==1)
		{
			A[(int)a]++;
		}
		else if(game(a,b)==-1)
		{
			B[(int)b]++;
		}
	}
	int win = A[(int)'C']+A[(int)'B']+A[(int)'J'];
	int lose = B[(int)'C']+B[(int)'B']+B[(int)'J'];
	int equal =N-win-lose;
	printf("%d %d %d\n",win,equal,lose);
	printf("%d %d %d\n",lose,equal,win);
	printf("%c %c\n",max(A),max(B));
}

int game(char a,char b)
{
	if(a==b)
	{
		return 0;
	}
	else if((a=='C'&&b=='J')||
			(a=='J'&&b=='B')||
			(a=='B'&&b=='C'))
	{
		return 1;
	}
	else
	{
		return -1;
	}
}

char max(int*A)
{
	if(A[(int)'B']>=A[(int)'C']&&A[(int)'B']>=A[(int)'J'])
	{
		return 'B';
	}
	else if(A[(int)'C']>=A[(int)'B']&&A[(int)'C']>=A[(int)'J'])
	{
		return 'C';
	}
	else
	{
		return 'J';
	}
}

