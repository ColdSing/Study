package MySever2;

import java.io.IOException;
import java.net.Socket;
/**
 * 与客户端进行消息传递的线程体
 * @author 风潇潇
 *
 */
public class Dispatch implements Runnable{
	private Request req;
	private Response rep;
	private int code =200;
	public Dispatch(Socket client) {
		try {
			req = new Request(client);
			rep = new Response(client);
		} catch (IOException e) {
			//e.printStackTrace();
			code =500;//服务器故障
			return;
		}
	}
	@Override
	public void run() {
		//使用多态通过Severlet不同的子类进行不同request的response
		Severlet sl=null;
		try {
			sl = WebApp.getSeverlet(req.getURL());
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(null==sl){
			code=404;//页面未找到
		}
		else{
			sl.doSever(req, rep);
		}
		
		try {
			rep.pushToClient(code);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
