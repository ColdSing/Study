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
import com.fxx.service.EditProductService;

public class AdminEditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//若修改保存失败，request域中存入product对象，直接读取
		Product product =(Product) request.getAttribute("Product");
		//若product==null则为直接访问，从连接中提取参数pid，并传递至dao层后，从数据库中读取数据封装为product对象
		if(product==null) {
			String pid = request.getParameter("pid");
			EditProductService editProductService = new EditProductService();
			try {
				product = editProductService.getProduct(pid);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//读取Category列表为页面显示服务
		AdminCategoryListService adminCategoryListService = new AdminCategoryListService();
		List<Category> categoryList=null;
		try {
			categoryList =adminCategoryListService.findAllCategory();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//若获得product对象则，将categoryList和product存入requestyu中，转发至edit.jsp页面显示
		if(product!=null) {
			request.setAttribute("categoryList", categoryList);
			request.setAttribute("product", product);
			request.getRequestDispatcher("/admin/product/edit.jsp").forward(request, response);
		}else {
			//读取失败返回主页；
			response.sendRedirect(request.getContextPath()+"/admin/home.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}