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
		//���ñ����ʽ����������
		request.setCharacterEncoding("UTF-8");
		//��ҳ����ȡ������֤����Ϣ���ӷ���������ȡ��֤������
		String user_checkcode = request.getParameter("checkImg");
		String service_checkcode = (String) request.getSession().getAttribute("checkcode_session");
		//��֤��У��
		if(service_checkcode!=null&&service_checkcode.equals(user_checkcode)) {
			//��ҳ�������ȡ�û�����������Ϣ
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			User user=null;
			//����loginService�������䴫���û��ύ��Ϣ
			LoginService loginService = new LoginService();
			try {
				user = loginService.login(username,password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//�˻�������������½ʧ�ܣ��ض����¼ҳ�沢���õ�½ʧ����ʾ��Ϣ
			if(user==null) {
				request.setAttribute("failInfo","�˻������������");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
				requestDispatcher.forward(request, response);
			}else {
				//��½�ɹ�����use�������session���У����ض�������ҳ
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				Cookie cookie = new Cookie("JSESSIONID",session.getId());
				cookie.setMaxAge(30*60);
				cookie.setPath(request.getContextPath());
				response.addCookie(cookie);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
				requestDispatcher.forward(request, response);
			}
			//��֤����������½ʧ�ܣ��ض����¼ҳ�沢���õ�½ʧ����ʾ��Ϣ
		}else {
			request.setAttribute("failInfo","��֤�����");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}