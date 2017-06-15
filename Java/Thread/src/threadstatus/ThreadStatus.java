package threadstatus;

public class ThreadStatus {

	public static void main(String[] args) {
		Study s= new Study();
		Thread t= new Thread(s);
		t.start();
		for(int i=0;i<100;i++){
			if(50==i){
				s.stop();
			}
			System.out.println("main--->"+i);
		}
	}
	
}

class Study implements Runnable{
	private boolean flag=true;
	@Override
	public void run() {
		while(flag){
			System.out.println("study thread...");
		}
	}
	public void stop(){
		this.flag=false;
	}
	
}