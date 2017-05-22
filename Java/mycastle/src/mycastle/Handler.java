package mycastle;

public class Handler {
	protected Game g;
	public Handler(Game g) {
		this.g = g;
	}
	public void doCmd(String value){}
	public boolean bye(){
		return false;
	}
}
