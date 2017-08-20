package com.fxx.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fxx.domain.Product;
import com.fxx.service.ProductInfoService;

public class ProductInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ҳ���ȡpid���ȡproduct���󣬷���request���ת����product_info.jspҳ��
		String pid = request.getParameter("pid");
		ProductInfoService productInfoService = new ProductInfoService();
		Product product=null;
		try {
			product = productInfoService.getProduct(pid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("product", product);
		request.getRequestDispatcher("product_info.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}