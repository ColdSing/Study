package com.fxx.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fxx.domain.Category;
import com.fxx.domain.Product;
import com.fxx.service.AdminCategoryListService;
import com.fxx.service.ProductListService;

public class AdminProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 从数据库中查询所有product并通过request域跳转至list页面
		ProductListService productListService = new ProductListService();
		AdminCategoryListService adminCategoryListService = new AdminCategoryListService();
		List<Product> productList = null;
		List<Category> categoryList = null;
		try {
			productList = productListService.getProductList();
			categoryList= adminCategoryListService.findAllCategory();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("productList", productList);
		request.getRequestDispatcher("/admin/product/list.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}