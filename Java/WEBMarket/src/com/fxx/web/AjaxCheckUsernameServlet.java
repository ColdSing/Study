package com.fxx.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fxx.service.CheckUsernameService;

public class AjaxCheckUsernameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		CheckUsernameService checkUsernameService = new CheckUsernameService();
		boolean usernameExist=false;
		try {
			usernameExist = checkUsernameService.check(username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.getWriter().write(""+!usernameExist);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}