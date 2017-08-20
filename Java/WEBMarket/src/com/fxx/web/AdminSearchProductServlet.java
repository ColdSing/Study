package com.fxx.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.fxx.domain.Category;
import com.fxx.domain.Product;
import com.fxx.service.AdminCategoryListService;
import com.fxx.service.ProductListService;
import com.fxx.vo.Condition;

public class AdminSearchProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Map<String, String[]> parameterMap = request.getParameterMap();
		Condition condition = new Condition();
		AdminCategoryListService adminCategoryListService =new AdminCategoryListService();
		ProductListService productListService = new ProductListService();
		List<Product> productList=null;
		//为页面准备数据
		List<Category> categoryList=null;
		try {
			BeanUtils.populate(condition, parameterMap);
			productList=productListService.getProductListByConditon(condition);
			categoryList = adminCategoryListService.findAllCategory();
		} catch (IllegalAccessException | InvocationTargetException | SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("condition", condition);
		request.setAttribute("productList", productList);
		request.getRequestDispatcher("/admin/product/list.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}