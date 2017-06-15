package movie;
/**
 * java.lang.IllegalMonitorStateException
 * 若不对方法进行锁定则会造成此错误
 * this.wait()，只能通过锁定对象进行调用，也就是说其所有者才能调用
 * @author 风潇潇
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
