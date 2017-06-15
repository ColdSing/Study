package FileUtil;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtil {
	public static void copyDir(String srcPath,String desPath) throws IOException{
		if(srcPath.equals(desPath)){
			return;
		}
		File src=new File(srcPath);
		File dest = new File(desPath);
		copyDirAndFile(src,dest);
	}
	public static void copyDirAndFile(File src,File dest) throws IOException{
		if(src.isFile()){
			fileCopy(src, dest);
		}else if(dest.getAbsolutePath().contains(src.getAbsolutePath())){
			System.out.println("��Ŀ¼���ܿ�������Ŀ¼��");
			return;
		}else{
			if(!dest.exists()){
				dest.mkdirs();
			}
			File[] fileList = src.listFiles();
			for(File f:fileList){
				if(f.isDirectory()){
					copyDirAndFile(f,new File(dest,f.getName()));
				}else{
					fileCopy(f, new File(dest,f.getName()));
				}
			}
		}
	}
	public static void fileCopy(File src,File dest) throws IOException{
		if(src.isDirectory()||null==src){
			System.out.println("�������ļ�,���ļ�Ϊ��");
			return;
		}else if(dest.isDirectory()){
			System.out.println("�����ļ�����Ŀ��·��Ϊ�ļ����޷�����");
			return;
		}
		else{
			InputStream is =new BufferedInputStream(new FileInputStream(src));
			OutputStream os = new BufferedOutputStream(new FileOutputStream(dest,true));
			byte[] car = new byte[1024];
			int len=0;
			while(-1!=(len=is.read(car))){
				os.write(car, 0, len);
			}
			os.flush();
			os.close();
			is.close();
			
		}
	}
	
}
