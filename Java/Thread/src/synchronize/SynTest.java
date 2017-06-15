package synchronize;

public class SynTest {

	public static void main(String[] args) {
		Web12306 web = new Web12306();
		Thread a= new Thread(web,"a");
		Thread b= new Thread(web,"b");
		Thread c= new Thread(web,"c");
		a.start();
		b.start();
		c.start();
	}

}

class Web12306 implements Runnable{
	private int num = 50;
	@Override
	public void run() {
		while(true){
			if(num<1){
				break;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"抢到了第"+num--+"张票");
		}
	}
	
	
	
}