package mycastle;

public class HandlerGo extends Handler {
	
	public HandlerGo(Game g) {
		super(g);
		// TODO Auto-generated constructor stub
	}
	public void doCmd(String value){
		g.outdoor(value);
	}
}
