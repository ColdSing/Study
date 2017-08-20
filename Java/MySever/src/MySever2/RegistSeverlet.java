package MySever2;

import java.io.IOException;
/**
 * ◊¢≤·
 * @author ∑Á‰Ï‰Ï
 *
 */
public class RegistSeverlet extends Severlet {


	@Override
	public void doGet(Request req, Response rep) {
		
	}

	@Override
	public void doPost(Request req, Response rep) {
		boolean flag = saveDate(req, rep);
		rep.contentPrintln("<html><head><title>∑Á‰Ï‰Ï</title>");
		rep.contentPrintln("</head><body>");
		if(flag){
			rep.contentPrintln("∏––ª"+req.getClientValue("username")+"◊¢≤·");
		}else{
			rep.contentPrintln("◊¢≤· ß∞‹£¨”√ªß“—¥Ê‘⁄");
		}
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
	
	public boolean saveDate(Request req, Response rep){
		String uname = req.getClientValue("username");
		String pwd = req.getClientValue("password");
		if(JDBCUtil.checkUser(uname)){
			return false;
		}else{
			JDBCUtil.saveUser(uname, pwd);
			return true;
		}
	}

}
