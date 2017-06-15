package movie;

public class Watcher implements Runnable{
	Movie m;

	public Watcher(Movie m) {
		this.m = m;
	}

	@Override
	public void run() {
		for(int i=0;i<20;i++){
			m.watch();
		}
	}
	
}
