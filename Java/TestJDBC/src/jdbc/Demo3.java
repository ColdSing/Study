package jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Demo3 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn= DriverManager.getConnection
					("jdbc:mysql://localhost:3306/mydata?useSSL=true","root","626115@Lm");
			String sql = "select id,username,pwd from t_user where id>?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, 2);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				System.out.println(rs.getInt(1)+"----"+rs.getString(2)+"----"+rs.getString(3));
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			
		}
		
	}

}
