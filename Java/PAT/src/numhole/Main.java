package numhole;


import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int[] N=new int[10];
		int flag=0;
		for(int i=0;i<10;i++){
			N[i]=in.nextInt();
			if(N[i]!=0&&i>0&&flag==0){
				flag=i;
			}
		}
		System.out.print(flag);
		N[flag]--;
		for(int i=0;i<10;i++){
			for(int j=0;j<N[i];j++){
				System.out.print(i);
			}
		}
	}
}
