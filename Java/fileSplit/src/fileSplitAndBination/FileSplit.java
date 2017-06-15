package fileSplitAndBination;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
/**
 * �ļ��ķָ�
 * @author ������
 *
 */
public class FileSplit {
	//�ļ�·��
	private String srcPath;
	//�ļ�����
	private File src;
	//Դ�ļ���С
	private long fileSize;
	//Դ�ļ���
	private String name;
	//�ָ����
	private int blocks;
	//ÿ���С
	private long blockSize;
	//�ָ��洢·��

	public FileSplit(String srcPath){
		this(srcPath,10);//Ĭ�Ϸָ�Ϊʮ��
	}
	/**
	 * Ĭ��Ϊ��ȡԴ�ļ�Ŀ¼���ͷָ����
	 * @param srcPath
	 * @param blocks
	 */
	public FileSplit(String srcPath,int blocks){
		this.srcPath = srcPath;
		this.blocks=blocks;
		initial();
	}
	/**
	 * ��ȡ�ļ������ļ���С������ָ��ÿ���С
	 */
	public void initial(){
		this.src=new File(srcPath);
		if(!src.isFile()){
			System.out.println("�����ļ���ֻ�ָܷ��ļ�,���ļ�������");
			return;
		}
		this.fileSize=src.length();//�ļ���С
		this.name=src.getName();//�ļ���
		this.blockSize = fileSize/blocks;//�ָ���С
	}
	/**
	 * ָ�����Ŀ¼
	 * @param destPath
	 * @throws IOException
	 */
	public void split(String destPath) throws IOException{
		File dest = new File(destPath);
		if(dest.isFile()||dest.isDirectory()){
			System.out.println("�޷��洢�������ļ����ļ������У���ָ��δ�������ļ���·��");//Ϊ����ϲ����޶�����Ϊδ�������ļ���·��
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
		 * ����ָ���Ϣ
		 * ���ڷָ���Ϣ���ƶ�
		 * �����޶�δ�������ļ���
		 * �Ա�ϲ�ʱ��ȡ
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
		File destSplit = new File(dest,this.name+"��"+idx+"����");
		if(destSplit.exists()){
			destSplit.delete();
		}//�����ظ�д��
		RandomAccessFile is = new RandomAccessFile(src,"r");
		OutputStream os = new BufferedOutputStream(new FileOutputStream(destSplit,true));
		is.seek(head);
		byte[] flush =new byte[1024];
		int len=0;
		long sum=0;
		//�˴�Ҫ��Ϊע�⣬Ӧ��ʵ��sizeд�룬���һ��
		//ͬ�ļ����Ʋ�ͬ���˴��޷�ͨ������-1���Ƴ�ѭ��
		//��Ϊ�ļ��ָ�������size�߽��⻹�����ֽڴ���
		//��ֱ��ʹ��len�����޷���ȷ��ȡ��
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
	/**��
	 * ͨ���ƶ���С���ָ��ļ�
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
		FileSplit fs = new FileSplit("G:/��Java���ļ��� ��1 ����֪ʶ��ԭ���9�棩�����������İ棩.pdf");
		try {
			fs.split("G:/test");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
