package maxlist;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in =new Scanner(System.in);
		int k = in.nextInt();
		int[] Nk = new int[k];
		int max=0;
		int sum=0;
		int first = 0;
		int temp= 0;
		int last = k;
		for(int i=0;i<k;i++){
			Nk[i]=in.nextInt();
			sum += Nk[i];
			if(sum>max||(sum >= max && sum==0)){
				max=sum;
				last =i;
				first =temp;
			}
			if(sum<0){
				sum = 0;
				temp = i+1;
			}
		}
		System.out.println(""+max+" "+Nk[first]+" "+Nk[last]);
		in.close();
	}

}
