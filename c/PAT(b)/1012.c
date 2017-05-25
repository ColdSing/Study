#include <stdio.h>

int main(void)
{
	int n;
	scanf("%d",&n);
	int num;
	int sum1=0;
	int sum2=0,count2=1;
	int count3=0;
	int sum4=0,count4=0;
	int max5=0;
	for(int i=0;i<n;i++)
	{
		scanf("%d",&num);
		if(num%5==0&&num%2==0)
		{
			sum1+=num;
		}
		else if(num%5==1)
		{
			if(count2%2!=0) sum2+=num;else sum2-=num;
			count2++;
		}
		else if(num%5==2)
		{
			count3++;
		}
		else if(num%5==3)
		{
			sum4+=num;
			count4++;
		}
		else if(num%5==4&&num>max5)
		{
			max5=num;
		}	
	}
	if(sum1==0) printf("N "); else printf("%d ",sum1);
	if(count2==1) printf("N "); else printf("%d ",sum2);
	if(count3==0) printf("N "); else printf("%d ",count3);	
	if(sum4==0) printf("N "); else printf("%.1f ",(float)sum4/count4);
	if(max5==0) printf("N"); else printf("%d",max5);
}