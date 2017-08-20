package com.fxx.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fxx.service.ProductListService;

public class AjaxIndexSerchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String serchWord = request.getParameter("serchWord");
		if(serchWord==null||serchWord.trim().equals("")) {
			return;
		}
		ProductListService productListService = new ProductListService();
		List<Object> pnameList=null;
		try {
			pnameList = productListService.getSerchingPnameList(serchWord);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		StringBuffer sb = new StringBuffer();
		sb.append("{\"pnameList\":[");
		int flag=0;
		for (Object object : pnameList) {
			String pname = (String)object;
			if(flag==0) {
				sb.append("\""+pname+"\"");
			}else {
				sb.append(",\""+pname+"\"");
			}
			flag++;
		}
		sb.append("]}");
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(sb.toString());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}