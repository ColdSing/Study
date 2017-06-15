package TestStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
/**
 * Io流小计，通过File将文件对象化
 * 将文件对象与输入输出流对接
 * 通过流获取或写入相关数据
 * @author 风潇潇
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
