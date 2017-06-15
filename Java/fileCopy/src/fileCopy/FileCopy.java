package fileCopy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * io�����ļ��������ļ��и���
 * @author ������
 *
 */
public class FileCopy {

	public static void fileCopy(File src,File dst) throws IOException{
		
		FileInputStream is =new FileInputStream(src);
		FileOutputStream os=new FileOutputStream(dst,true);
			int len=0;
			byte[] isByte = new byte[1024]; 
			while(-1!=(len=is.read(isByte))){
				os.write(isByte,0,len);
			}
			os.flush();
			os.close();
			is.close();
	}
	public static void dirCopy(String srcPath,String dstPath){
		File src = new File(srcPath);
		File dst = new File(dstPath);
		if(!dst.exists()){
			dst.mkdirs();
		}
		File[] fileList = src.listFiles();
		for(File f : fileList){
			if(f.isFile()){
				File o = new File(dstPath+"/"+f.getName());
				try {
					fileCopy(f,o);
				} catch (IOException e) {
					System.out.println("�ļ���ȡʧ�ܻ����ر�ʧ��");
					e.printStackTrace();
				}
			}
			else if(f.isDirectory()){
				dirCopy(f.getAbsolutePath(),dstPath+"/"+f.getName());
			}
		}
	}
	public static void main(String[] args) throws IOException {
		String srcPath = "F:/test";
		String dstPath = "F:/dir";
		dirCopy(srcPath,dstPath);

	}

}
