package MySever2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/**
 * ◊¢≤·
 * @author ∑Á‰Ï‰Ï
 *
 */
public class ClcSeverlet extends Severlet {


	@Override
	public void doGet(Request req, Response rep) {
	}

	@Override
	public void doPost(Request req, Response rep) {
		File f = new File("G:\\Study\\Java\\MySever\\src\\MySever2\\page\\index.html");
		BufferedReader br=null;
		try {
			br=new BufferedReader(new FileReader(f));
			String str = null;
			while(null!=(str=br.readLine())){
				rep.contentPrintln(str);
			}
			rep.pushToClient(200);
		} catch (IOException e2) {
			e2.printStackTrace();
			try {
				rep.pushToClient(500);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}finally{
			try {
				if(br!=null){
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	

}
