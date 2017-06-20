package MySever2;

import java.io.IOException;
import java.net.Socket;

public class Dispatch implements Runnable{
	private Request req;
	private Response rep;
	
	public Dispatch(Socket client) {
		try {
			req = new Request(client);
			rep = new Response(client);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		try {
			Severlet sl = new Severlet(req,rep);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
