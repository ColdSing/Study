package movie;
/**
 * java.lang.IllegalMonitorStateException
 * �����Է����������������ɴ˴���
 * this.wait()��ֻ��ͨ������������е��ã�Ҳ����˵�������߲��ܵ���
 * @author ������
 *
 */

public class Movie {
	private String pic;
	private boolean flag = true;
	public synchronized void make(String pic){
		if(!flag){
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.pic = pic;
		this.notify();
		this.flag = !flag;
	}
	public synchronized void watch(){
		if(flag){
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(pic);
		this.notify();
		this.flag = !flag;
	}
}
