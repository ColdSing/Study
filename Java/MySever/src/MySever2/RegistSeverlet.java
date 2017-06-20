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
		rep.contentPrintln("<html><head><title>∑Á‰Ï‰Ï</title>");
		rep.contentPrintln("</head><body>");
		rep.contentPrintln("∏––ª"+req.getClientValue("username")+"◊¢≤·");
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
