package MySever2;

import java.io.IOException;

public abstract class Severlet{
	
	public void doSever(Request req, Response rep){
		doGet(req,rep);
		doPost(req,rep);
	}
	
	public abstract void doGet(Request req, Response rep);
	public abstract void doPost(Request req, Response rep);
	
}
