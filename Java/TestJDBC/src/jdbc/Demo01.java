package jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Demo01 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn= DriverManager.getConnection
					("jdbc:mysql://localhost:3306/mydata?useSSL=true","root","626115@Lm");
			Statement stat = conn.createStatement();
			String sql = "insert into t_user (username,pwd,regtime) values ('ÍõÎå',12345,now())";
			stat.execute(sql);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
