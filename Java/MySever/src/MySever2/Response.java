package MySever2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.sql.Date;

public class Response {
	public static final String CRLF="\r\n";
	public static final String BLANK=" ";
	
	private StringBuilder stateline;
	private StringBuilder ResponseHead;
	private StringBuilder contents;
	private int contentLen =0;
	boolean severFault = false;
	
	private BufferedWriter bw;
	
	public Response(){
		this.stateline = new StringBuilder();
		ResponseHead = new StringBuilder();
		this.contents = new StringBuilder();
	}
	public Response(OutputStream os){
		this();
		this.bw=new BufferedWriter(new OutputStreamWriter(os));
	}
	public Response(Socket client){
		this();
		try {
			this.bw = new BufferedWriter(
					new OutputStreamWriter(
							client.getOutputStream()));
		} catch (IOException e) {
			severFault=true;
		}
	}
	private void setState(int code){
		stateline.append("HTTP/1.1");
		stateline.append(BLANK);
		stateline.append(code);
		stateline.append(BLANK);
		switch(code){
		case 200:stateline.append("OK");break;
		case 404:stateline.append("Not Found");break;
		case 500:stateline.append("Internal Server Error");break;
		}
		stateline.append(CRLF);
	}
	private void setResponseHead(){
		ResponseHead.append("Server: nginx").append(CRLF);
		ResponseHead.append("Date:").append(BLANK).append(new Date(System.currentTimeMillis())).append(CRLF);
		ResponseHead.append("Content-Type: text/html;;charset=utf-8").append(CRLF);
		ResponseHead.append("Content-Length: ").append(contentLen).append(CRLF);
		ResponseHead.append(CRLF);
	}
	public Response contentPrint(String s){
		contents.append(s);
		contentLen+=(s.getBytes()).length;
		return this;
	}
	public Response contentPrintln(String s){
		contents.append(s).append(CRLF);
		contentLen+=((s+CRLF).getBytes()).length;
		return this;
	}
	public void pushToClient(int code) throws IOException{
		if(severFault){
			code = 503;
		}
		 setState(code);
		 setResponseHead();
		 bw.append(stateline.toString());
		 bw.append(ResponseHead.toString());
		 bw.append(contents.toString());
		 bw.flush(); 
	}
	public void close() throws IOException{
		if(bw!=null){
			bw.close();
		}
	}
	
}
