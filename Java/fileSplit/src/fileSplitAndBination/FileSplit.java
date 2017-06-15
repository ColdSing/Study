package fileSplitAndBination;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
/**
 * 文件的分割
 * @author 风潇潇
 *
 */
public class FileSplit {
	//文件路径
	private String srcPath;
	//文件对象
	private File src;
	//源文件大小
	private long fileSize;
	//源文件名
	private String name;
	//分割块数
	private int blocks;
	//每块大小
	private long blockSize;
	//分割后存储路径

	public FileSplit(String srcPath){
		this(srcPath,10);//默认分割为十块
	}
	/**
	 * 默认为读取源文件目录，和分割块数
	 * @param srcPath
	 * @param blocks
	 */
	public FileSplit(String srcPath,int blocks){
		this.srcPath = srcPath;
		this.blocks=blocks;
		initial();
	}
	/**
	 * 读取文件名，文件大小，计算分割后每块大小
	 */
	public void initial(){
		this.src=new File(srcPath);
		if(!src.isFile()){
			System.out.println("传入文件夹只能分割文件,或文件不存在");
			return;
		}
		this.fileSize=src.length();//文件大小
		this.name=src.getName();//文件名
		this.blockSize = fileSize/blocks;//分割块大小
	}
	/**
	 * 指定输出目录
	 * @param destPath
	 * @throws IOException
	 */
	public void split(String destPath) throws IOException{
		File dest = new File(destPath);
		if(dest.isFile()||dest.isDirectory()){
			System.out.println("无法存储到已有文件或文件夹中中，请指定未建立的文件夹路劲");//为方便合并，限定必须为未建立的文件夹路径
			return;
		}
		if(!dest.exists()){
			dest.mkdirs();
		}
		long head=0;
		long size=this.blockSize;
		for(int i=0;i<blocks;i++){
			if(i==blocks-1){
				size=this.fileSize-head;
			}
			splitDtails(i,dest,head,size);
			head+=size;
		}
		/**
		 * 输出分割信息
		 * 由于分割信息名制定
		 * 所以限定未建立的文件夹
		 * 以便合并时读取
		 */
		File info = new File(dest,"splitInfo");
		DataOutputStream dos = new DataOutputStream(
							   new BufferedOutputStream(
						       new FileOutputStream(info)));
		dos.writeUTF(this.name);
		dos.writeInt(this.blocks);
		dos.flush();
		dos.close();		
	}
			
	
	private void splitDtails(int idx,File dest,long head,long size) throws IOException{
		File destSplit = new File(dest,this.name+"第"+idx+"部分");
		if(destSplit.exists()){
			destSplit.delete();
		}//避免重复写入
		RandomAccessFile is = new RandomAccessFile(src,"r");
		OutputStream os = new BufferedOutputStream(new FileOutputStream(destSplit,true));
		is.seek(head);
		byte[] flush =new byte[1024];
		int len=0;
		long sum=0;
		//此处要尤为注意，应按实际size写入，最后一次
		//同文件复制不同，此处无法通过返回-1来推出循环
		//因为文件分割所以在size边界外还是有字节存在
		//若直接使用len，就无法正确读取！
		while(-1!=(len=is.read(flush))){
			if(size-len>=0){
				os.write(flush, 0, len);
				size-=len;
			}else{
				os.write(flush,0,(int)size);
				break;
			}
		}
		os.flush();
		os.close();
		is.close();
	}
	/**、
	 * 通过制定大小来分割文件
	 * @param destPath
	 * @param blockSize
	 * @throws IOException
	 */
	public void splitBySize(String destPath,long blockSize) throws IOException{
		if(blockSize>fileSize){
			blockSize = fileSize;
		}
		this.blockSize=blockSize;
		this.blocks = (int)(Math.ceil((fileSize*1.0/blockSize)));
		split(destPath);
	}
	public static void main(String[] args) {
		FileSplit fs = new FileSplit("G:/《Java核心技术 卷1 基础知识（原书第9版）》（完整中文版）.pdf");
		try {
			fs.split("G:/test");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
