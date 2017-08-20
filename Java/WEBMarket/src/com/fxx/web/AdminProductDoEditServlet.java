package com.fxx.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.fxx.domain.Product;
import com.fxx.service.AdminProductDoEditService;

public class AdminProductDoEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//修改字符集，解决乱码问题
		request.setCharacterEncoding("UTF-8");
		//将表单参数存入Map
		Map<String, String[]> parameterMap = request.getParameterMap();
		//使用BeanUtils，将参数封装入Product对象
		Product product = new Product();
		try {
			BeanUtils.populate(product, parameterMap);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		AdminProductDoEditService adminProductDoEditService = new AdminProductDoEditService();
		boolean isEdited=false;
		try {
			isEdited=adminProductDoEditService.doEdit(product);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//修改成功返回至列表页，修改失败，再次将product作为参数传至edit页面修改
		if(isEdited) {
			response.sendRedirect(request.getContextPath()+"/adminProductList");
		}else {
			request.setAttribute("product", product);
			request.getRequestDispatcher("/editProduct").forward(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}