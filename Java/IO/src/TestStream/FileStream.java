package TestStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
/**
 * Io��С�ƣ�ͨ��File���ļ�����
 * ���ļ�����������������Խ�
 * ͨ������ȡ��д���������
 * @author ������
 *
 */
public class FileStream {

	public static void main(String[] args) {
		File src = new File("G:/test.txt");
		InputStream is =null;
		try {
			is= new FileInputStream(src);
			byte[] car = new byte[1024];
			int len=0;
			StringBuilder sb = new StringBuilder();
			while(-1!=(len=is.read(car))){
				String info = new String(car,0,len,"utf-8");
				sb.append(info);
			}
			System.out.println(sb.toString());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(null!=is){
				is.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
