package com.fxx.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fxx.service.ProductListService;
import com.fxx.vo.PageBean;

public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//向service层传递请求
		ProductListService productListService = new ProductListService();
		PageBean pageBean = null;
		int currentPage = 1;
		String pageStr=request.getParameter("page");
		if(pageStr!=null&&!pageStr.equals("")) {
			currentPage=Integer.parseInt(pageStr);
		}
		int productPerPage=12;
		try {
			pageBean = productListService.getPageBean(currentPage,productPerPage);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//将数据保存至request域
		request.setAttribute("pageBean", pageBean);
		//转发至product_list.jsp页面展示
		request.getRequestDispatcher("product_list.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}