package MyArray;
/**
 * StringBuilder(线程不安全，效率高)，StringBuffer(线程安全，效率低）
 * String ：不可变字符序列
 * @author 风潇潇
 *
 */

public class TestString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="abcd";
		StringBuilder sb = new StringBuilder(); //初始长度为16
		sb.append(1);
		sb.reverse();
	}

}
