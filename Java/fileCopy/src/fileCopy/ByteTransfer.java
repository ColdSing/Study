package fileCopy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class  ByteTransfer {
	
	
	public static void main(String[] args) throws IOException{
		String a="abc";
		int b=1;
		int c=2;
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		bout.write(a.getBytes());
		bout.write(b);
		bout.write(c);
		byte[] buff = bout.toByteArray();
		System.out.println(bout.toString());
		System.out.println("***********************");
		ByteArrayInputStream bin = new ByteArrayInputStream(buff);
		while((b=bin.read())!=-1) {
			System.out.println(b);
		}
	
	}
}
