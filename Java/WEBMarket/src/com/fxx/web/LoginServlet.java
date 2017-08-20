package com.fxx.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fxx.domain.User;
import com.fxx.service.LoginService;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码格式，避免乱码
		request.setCharacterEncoding("UTF-8");
		//从页面提取表单中验证码信息，从服务器中提取验证码内容
		String user_checkcode = request.getParameter("checkImg");
		String service_checkcode = (String) request.getSession().getAttribute("checkcode_session");
		//验证码校验
		if(service_checkcode!=null&&service_checkcode.equals(user_checkcode)) {
			//从页面表单从提取用户名与密码信息
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			User user=null;
			//生成loginService对象并向其传递用户提交信息
			LoginService loginService = new LoginService();
			try {
				user = loginService.login(username,password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//账户名或密码错误登陆失败，重定向登录页面并设置登陆失败显示信息
			if(user==null) {
				request.setAttribute("failInfo","账户名或密码错误");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
				requestDispatcher.forward(request, response);
			}else {
				//登陆成功，将use对象放入session域中，并重定向至主页
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				Cookie cookie = new Cookie("JSESSIONID",session.getId());
				cookie.setMaxAge(30*60);
				cookie.setPath(request.getContextPath());
				response.addCookie(cookie);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
				requestDispatcher.forward(request, response);
			}
			//验证码输入错误登陆失败，重定向登录页面并设置登陆失败显示信息
		}else {
			request.setAttribute("failInfo","验证码错误");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}