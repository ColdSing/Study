package fileSplitAndBination;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileBination {
	private String srcPath;
	private String destPath;
	private String fileName;
	private int blocks;
	public FileBination(String srcPath, String destPath) throws IOException {
		this.srcPath = srcPath;
		this.destPath = destPath;
		binationIntial();
	}
	public void binationIntial() throws IOException{
		File src = new File(srcPath);
		File splitInfo = new File(src,"splitInfo");
		if(!src.isDirectory()){
			System.out.println("请提供分割文件绝对路径！");
			return;
		}else if(!splitInfo.exists()||!splitInfo.isFile()){
			System.out.println("分割信息文件不存在或损坏");
			return;
		}else{
			DataInputStream dis = new DataInputStream(
							      new BufferedInputStream(
							      new FileInputStream(splitInfo)));
			this.fileName=dis.readUTF();
			this.blocks = dis.readInt();
		}
	}
	public void bination() throws IOException{
		File bFile = new File(destPath, fileName);
		for(int i=0 ;i<blocks;i++){
			if(!binationDtail(bFile,i)){
				bFile.delete();
				break;
			}
		}
	}

	private boolean binationDtail(File bFile,int i) throws IOException{
		File inFile = new File(srcPath,fileName+"第"+i+"部分");
		OutputStream os = new BufferedOutputStream(new FileOutputStream(bFile,true));
		InputStream is=null;
		boolean ok=true;
		if(!inFile.exists()){
			System.out.println("第"+i+"个分割文件损坏");
			ok=false;
		}else{
			is = new BufferedInputStream(new FileInputStream(inFile));
			int len =0;
			byte[] flush = new byte[1024];
			while(-1!=(len=is.read(flush))){
				os.write(flush, 0, len);
			}
		}
		os.flush();
		os.close();
		is.close();
		return ok;
	}
	public static void main(String[] args) {
		try {
			FileBination fb =new FileBination("G:/test","D:/");
			fb.bination();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
