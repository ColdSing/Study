package MySever2;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Test {

	public static void main(String[] args) throws IOException {
		InputStream is = new BufferedInputStream(new FileInputStream(new File("C:/Users/hj/Desktop/post.txt")));
		byte[] flush = new byte[1024];
		int len =0;
		StringBuilder sb = new StringBuilder();
		while(-1!=(len=is.read(flush))){
			sb.append(new String(flush,0,len));
		}
		String allInfo = (sb.toString()).trim();
		System.out.println(allInfo);
	}
}