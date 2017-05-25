#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<ctype.h> 


int main(void)
{
	char s[4][61];
	for(int i=0;i<4;i++)
	{
		scanf("%s",s[i]);
	}

	int day,hour,m;
	int flag=0;
	for(int i=0;;i++)
	{
		if(s[0][i]==s[1][i]&&s[0][i]>='A'&&s[0][i]<='G'&&flag==0)
		{
			day=s[1][i]-'A'+1;
			flag++;
		}
		else if(s[0][i]==s[1][i]&&flag==1&&(((s[0][i])>='A'&&(s[0][i])<='N')||(s[0][i]>='0'&&s[0][i]<='9')))
		{
			hour=s[0][i]-'0';
			if(hour<0||hour>9)
			{
				hour=toupper(s[0][i])-'A'+10;
			}
			break;
		}
	}
	for(int i=0;;i++)
	{
		if(s[2][i]==s[3][i]&&toupper(s[2][i])>='A'&&toupper(s[2][i])<='Z')
		{
			m=i;
			break;
		}
	}
	switch (day)
	{
		case 1:printf("MON ");break;
        case 2:printf("TUE ");break;
        case 3:printf("WED ");break;
        case 4:printf("THU ");break;
        case 5:printf("FRI ");break;
        case 6:printf("SAT ");break;
        case 7:printf("SUN ");break;
	}
	printf("%02d:%02d",hour,m);
}

