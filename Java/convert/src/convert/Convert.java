package convert;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Convert {
	public static byte[] convertToByte(double n) throws IOException{
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(bo);
		dos.writeDouble(n);
		byte[] temp=bo.toByteArray();
		dos.flush();
		bo.flush();
		dos.close();
		bo.close();
		return temp;
	}
	public static double convertToDouble(byte[] b) throws IOException{
		ByteArrayInputStream bi = new ByteArrayInputStream(b,0, b.length);
		DataInputStream dis = new DataInputStream(bi);
		double n=dis.readDouble();
		bi.close();
		dis.close();
		return n;
		
	}
	public static void main(String[] args) {
		double n=1.23;
		try {
			n=convertToDouble(convertToByte(n));
			System.out.println(n);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
