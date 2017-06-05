package practice;

public class Practice {
	
	public static void main(String[] args){
		String s= "abc";
		String ss="abc";
		String s3="abc"+"def";
		String s4="abcdef";
		String s5=ss +"def";
		String s2 = new String("abc");
		System.out.println(s==s4);
		System.out.println(s3==s4);
		System.out.println(s5==s4);
		System.out.println(s4.equals(s5));
		System.out.println(s==s2);
	}
}
