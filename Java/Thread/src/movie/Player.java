package movie;

public class Player implements Runnable{
	Movie m;
	
	public Player(Movie m) {
		this.m = m;
	}
	
	@Override
	public void run() {
		for(int i=0;i<20;i++){
			if(i%2==0){
				m.make(i+"×óÇàÁú");
			}
			else{
				m.make(i+"ÓÒ°×»¢");
			}
		}
	}

}
