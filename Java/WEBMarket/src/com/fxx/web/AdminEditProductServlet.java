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
		//���޸ı���ʧ�ܣ�request���д���product����ֱ�Ӷ�ȡ
		Product product =(Product) request.getAttribute("Product");
		//��product==null��Ϊֱ�ӷ��ʣ�����������ȡ����pid����������dao��󣬴����ݿ��ж�ȡ���ݷ�װΪproduct����
		if(product==null) {
			String pid = request.getParameter("pid");
			EditProductService editProductService = new EditProductService();
			try {
				product = editProductService.getProduct(pid);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//��ȡCategory�б�Ϊҳ����ʾ����
		AdminCategoryListService adminCategoryListService = new AdminCategoryListService();
		List<Category> categoryList=null;
		try {
			categoryList =adminCategoryListService.findAllCategory();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//�����product�����򣬽�categoryList��product����requestyu�У�ת����edit.jspҳ����ʾ
		if(product!=null) {
			request.setAttribute("categoryList", categoryList);
			request.setAttribute("product", product);
			request.getRequestDispatcher("/admin/product/edit.jsp").forward(request, response);
		}else {
			//��ȡʧ�ܷ�����ҳ��
			response.sendRedirect(request.getContextPath()+"/admin/home.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}