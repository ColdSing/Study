package MySever2;

import java.io.IOException;
/**
 * ע��
 * @author ������
 *
 */
public class RegistSeverlet extends Severlet {


	@Override
	public void doGet(Request req, Response rep) {
		
	}

	@Override
	public void doPost(Request req, Response rep) {
		boolean flag = saveDate(req, rep);
		rep.contentPrintln("<html><head><title>������</title>");
		rep.contentPrintln("</head><body>");
		if(flag){
			rep.contentPrintln("��л"+req.getClientValue("username")+"ע��");
		}else{
			rep.contentPrintln("ע��ʧ�ܣ��û��Ѵ���");
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
