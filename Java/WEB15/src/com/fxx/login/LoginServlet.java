package com.fxx.login;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.fxx.domain.User;
import com.fxx.utils.C3P0DataSource;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Object server_img = request.getSession().getAttribute("checkcode_session");
		String user_img = request.getParameter("checkImg");
		if(server_img!=null&&((String)server_img).equals(user_img)) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			User user=null;
			try {
				user = login(username,password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(user==null) {
				request.setAttribute("false","账户名或密码错误");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
				requestDispatcher.forward(request, response);
			}else {
				response.sendRedirect("/WEB15");
			}
		}else {
			request.setAttribute("false","验证码错误");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(request, response);
		}
	}
	
	public User login(String username,String password) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0DataSource.getDataSource());
		String sql="select * from user where username=? and password=?";
		User user = qr.query(sql, new BeanHandler<User>(User.class),username,password);
		return user;
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}