package MySever2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * 手写服务器
 * @author 风潇潇
 *
 */

public class Sever {
	private ServerSocket sever;
	private boolean isRunning=true;
	public void start(){
		this.start(8888);
	}
	/**
	 * 指定端口
	 * @param code
	 */
	public void start(int code){
		try {
			sever = new ServerSocket(code);
			contact();
		} catch (IOException e) {
			stop();
		}
	}
	/**
	 * 通过服务器监听同客户端建立联系，
	 * 并新建线程，获取客户端request，以及向客户端response
	 * @throws IOException
	 */
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

