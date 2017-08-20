package MySever2;

import java.io.IOException;
/**
 * µÇÂ½ Severlet
 * @author ·çäìäì
 *
 */
public class LoginSeverlet extends Severlet{
	
	
	@Override
	public void doSever(Request req, Response rep) {
		if(JDBCUtil.checkPwd(req.getClientValue("username"),req.getClientValue("password"))){
			this.doGet(req, rep);
			this.doPost(req, rep);
		}
		else{
			this.doFault(req, rep);
		}
				
	}
	public void doFault(Request req, Response rep){
		rep.contentPrintln("<html><head><title>µÇÂ½Ê§°Ü</title>");
		rep.contentPrintln("</head><body>");
		rep.contentPrintln("µÇÂ¼Ê§°Ü");
		rep.contentPrintln("</body></html>");
		try {
			rep.pushToClient(200);
		} catch (IOException e) {
			try {
				rep.pushToClient(500);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	@Override
	public void doGet(Request req, Response rep){
		rep.contentPrintln("<html><head><title>µÇÂ½³É¹¦</title>");
		rep.contentPrintln("</head><body>");
		rep.contentPrintln("»¶Ó­£º"+req.getClientValue("username")+"»ØÀ´");
		rep.contentPrintln("</body></html>");
		try {
			rep.pushToClient(200);
		} catch (IOException e) {
			try {
				rep.pushToClient(500);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	@Override
	public void doPost(Request req, Response rep) {
		// TODO Auto-generated method stub
		
	}

}
