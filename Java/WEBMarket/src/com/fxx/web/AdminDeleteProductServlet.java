package com.fxx.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fxx.service.AdminDeleteProductService;

public class AdminDeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid = request.getParameter("pid");
		AdminDeleteProductService adminDeleteProductService = new AdminDeleteProductService();
		boolean isDelete=false;
		try {
			isDelete = adminDeleteProductService.doDelete(pid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(isDelete) {
			response.sendRedirect(request.getContextPath()+"/adminProductList");
		}else {
			request.setAttribute("isDelete", isDelete);
			request.getRequestDispatcher("/adminProductList").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}