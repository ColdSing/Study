package MySever2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {
	public static Connection getConnection(){
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn= DriverManager.getConnection
					("jdbc:mysql://localhost:3306/users?useSSL=true","root","626115@Lm");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(ResultSet rs , PreparedStatement ps,Connection conn){
		try {
			if(rs!=null){
				rs.close();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			if(ps!=null){
				ps.close();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	public static void close( PreparedStatement ps,Connection conn){
		try {
			if(ps!=null){
				ps.close();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	//用户名检查
	public static boolean checkUser(String uname){
		Connection conn=getConnection();
		PreparedStatement ps =null;
		ResultSet rs=null;
		boolean flag=false ;
		try {
			String sql = "select uname from userdata where uname=?";
			ps = conn.prepareStatement(sql);
			ps.setObject(1, uname);
			rs=ps.executeQuery();
			flag=rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs,ps,conn);
		}
		return flag;
	}
	//密码检查
	public static boolean checkPwd(String uname,String pwd){
		Connection conn=getConnection();
		PreparedStatement ps =null;
		ResultSet rs=null;
		boolean flag=false ;
		try {
			String sql = "select uname,pwd from userdata where uname=? and pwd =?";
			ps = conn.prepareStatement(sql);
			ps.setObject(1, uname);
			ps.setObject(2, pwd);
			rs=ps.executeQuery();
			flag=rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs,ps,conn);
		}
		return flag;
	}
	//注册数据存储
	public static void saveUser(String uname,String pwd){
		Connection conn=getConnection();
		PreparedStatement ps =null;
		try {
			String sql = "insert into userdata (uname,pwd) values (?,?)";
			ps = conn.prepareStatement(sql);
			ps.setObject(1, uname);
			ps.setObject(2, pwd);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(ps,conn);
		}
	}
	
}
