#include <stdio.h>
#include <stdlib.h>
typedef struct student
{
	int num;
	int scor1;
	int scor2;
}STU;
void sort(STU s[],int n);
int cmp (const void *a,const void*b);

int main (void)
{
	int N,L,H;
	scanf("%d %d %d",&N,&L,&H);
	STU stu1[N],stu2[N],stu3[N],stu4[N];
	int count1=0,count2=0,count3=0,count4=0;
	for(int i=0;i<N;i++)
	{
		int a,b,c;
		scanf("%d %d %d",&a,&b,&c);
		if(b>=H&&c>=H)
		{
			stu1[count1].num=a;
			stu1[count1].scor1=b;
			stu1[count1].scor2=c;
			count1++;
		}
		else if(b>=H&&c>=L)
		{
			stu2[count2].num=a;
			stu2[count2].scor1=b;
			stu2[count2].scor2=c;
			count2++;
		}
		else if(b>=L&&c>=L&&b>=c)
		{
			stu3[count3].num=a;
			stu3[count3].scor1=b;
			stu3[count3].scor2=c;
			count3++;
		}
		else if(b>=L&&c>=L)
		{
			stu4[count4].num=a;
			stu4[count4].scor1=b;
			stu4[count4].scor2=c;
			count4++;
		}
	}
	printf("%d\n",count1+count2+count3+count4);
	sort(stu1,count1);
	sort(stu2,count2);
	sort(stu3,count3);
	sort(stu4,count4);
}


void sort(STU s[],int n)
{
	qsort(s,n,sizeof(s[0]),cmp);
	for(int i=0;i<n;i++)
	{
		printf("%d %d %d\n",s[i].num,s[i].scor1,s[i].scor2);
	}
}

int cmp (const void *a,const void*b)//qsort函数通过返回值的正负排序降序负值，升序正值，适用于结构体。
{
	STU *aa = (STU *)a;
	STU *bb = (STU *)b;
	if((aa->scor1+aa->scor2)!=(bb->scor1+bb->scor2))
	{
		return (bb->scor1+bb->scor2)-(aa->scor1+aa->scor2);
	}
	else if(aa->scor1!=bb->scor1)
	{
		return bb->scor1-aa->scor1;
	}
	else
	{
		return aa->num-bb->num;
	}
}