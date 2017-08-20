package MySever2;

import java.io.IOException;
import java.net.Socket;
/**
 * ��ͻ��˽�����Ϣ���ݵ��߳���
 * @author ������
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
			code =500;//����������
			return;
		}
	}
	@Override
	public void run() {
		//ʹ�ö�̬ͨ��Severlet��ͬ��������в�ͬrequest��response
		Severlet sl=null;
		try {
			sl = WebApp.getSeverlet(req.getURL());
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(null==sl){
			code=404;//ҳ��δ�ҵ�
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
