package CloseUtil;

import java.io.Closeable;
import java.io.IOException;

public class Close {
	public static void closeAll(Closeable... io) {
		for(Closeable c:io){
			try {
				if(c!=null){
					c.close();
				}
			} catch (IOException e) {
			}
		}
	}
}
