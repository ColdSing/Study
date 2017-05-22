package mycastle;

public class HandlerHelp extends Handler {
	
	public HandlerHelp(Game g) {
		super(g);
		// TODO Auto-generated constructor stub
	}

	public void doCmd(String s){
		System.out.println("迷路了吗？你可以做的命令有：向  再见  帮助");
	    System.out.println("如：\t向东");
	}
}
