package MySever2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Sever {
	private ServerSocket sever;
	private boolean isRunning=true;
	public void start(){
		this.start(8888);
	}
	public void start(int code){
		try {
			sever = new ServerSocket(code);
			contact();
		} catch (IOException e) {
			stop();
		}
	}
	public void contact() throws IOException{
		while(isRunning){
			Socket client =sever.accept();
			new Thread(new Dispatch(client)).start();
		}
	}
	public void stop(){
		isRunning=false;
		try {
			if(sever!=null){
				sever.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Sever sever = new Sever();
		sever.start();
	}

}

