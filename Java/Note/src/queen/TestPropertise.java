package queen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class TestPropertise {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties pro = new Properties();
		pro.setProperty("driver","oracle.jdbc.driver.OracleDriver");
		pro.setProperty("url","jdbc:oracle:thin:@localhost:1521:orcl");
		pro.setProperty("user","scott");
		pro.setProperty("pwd","tiger");
		String url = pro.getProperty("url", "fxx");
		pro.store(new FileOutputStream(new File("G:/db.propertise")), "db≈‰÷√");
		
	}

}
