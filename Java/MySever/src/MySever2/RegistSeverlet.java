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
		rep.contentPrintln("<html><head><title>������</title>");
		rep.contentPrintln("</head><body>");
		rep.contentPrintln("��л"+req.getClientValue("username")+"ע��");
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

}
