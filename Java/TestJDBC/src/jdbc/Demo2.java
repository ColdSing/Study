package jdbc;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class Demo2 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn= DriverManager.getConnection
					("jdbc:mysql://localhost:3306/mydata?useSSL=true","root","626115@Lm");
			String sql = "insert into t_user (username,pwd,regtime) values (?,?,?)";
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setString(1, "Õı‰Ï1");
			stat.setString(2, "123456");
			stat.setDate(3, new Date(System.currentTimeMillis()));
			stat.execute();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
