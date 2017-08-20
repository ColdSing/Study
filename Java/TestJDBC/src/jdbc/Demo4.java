package jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Demo4 {

	public static void main(String[] args) {
		Connection conn=null;
		Statement stat =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn= DriverManager.getConnection
					("jdbc:mysql://localhost:3306/mydata?useSSL=true","root","626115@Lm");
			conn.setAutoCommit(false);
			stat = conn.createStatement();
			for(int i=0;i<20000;i++){
				stat.addBatch("insert into t_user (username,pwd,regtime) values('fxx"+i+"',666666,now())");
			}
			stat.executeBatch();
			conn.commit();
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
				try {
					if(stat!=null){
						stat.close();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				try {
					if(conn!=null){
					conn.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
	}

}
