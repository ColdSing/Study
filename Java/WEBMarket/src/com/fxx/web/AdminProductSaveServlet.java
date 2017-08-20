package com.fxx.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.fxx.domain.Product;
import com.fxx.service.AdminProductSaveService;

public class AdminProductSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//������������Map
		Map<String, String[]> parameterMap = request.getParameterMap();
		//ʹ��BeanUtils����������װ��Product����
		Product product = new Product();
		try {
			BeanUtils.populate(product, parameterMap);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		//����ҳ����������Ĳ���
		//1.pid
		product.setPid(UUID.randomUUID().toString());
		//2.pimage
		product.setPimage("products/1/timg.jpg");
		//3.pdate
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd");
		String pdate = formate.format(new Date());
		product.setPdate(pdate);
		//4.pflag
		product.setPflag(0);
		//5.isDelete
		product.setIsDelete(0);
		//����װ�õ�product������service��
		AdminProductSaveService adminProductSaveService =new AdminProductSaveService();
		boolean isSaveed=false;
		try {
			isSaveed = adminProductSaveService.saveProduct(product);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(isSaveed) {
			response.sendRedirect(request.getContextPath()+"/adminProductList");
		}else {
			request.setAttribute("product", product);
			request.getRequestDispatcher("/admin/product/add.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}