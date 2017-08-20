package com.fxx.service;

import java.sql.SQLException;
import java.util.List;

import com.fxx.dao.ProductListDao;
import com.fxx.domain.Product;
import com.fxx.vo.Condition;
import com.fxx.vo.PageBean;

public class ProductListService {

	public List<Product> getProductList() throws SQLException {
		//将数据请求转发给Dao层
		ProductListDao productListDao = new ProductListDao();
		List<Product> productList = productListDao.getProductList();
		return productList;
	}

	public List<Product> getProductListByConditon(Condition condition) throws SQLException {
		ProductListDao productListDao = new ProductListDao();
		List<Product> productList = productListDao.getProductListByConditon(condition);
		return productList;
	}

	public PageBean getPageBean(int currentPage, int productPerPage) throws SQLException{
		//将数据请求转发给Dao层
		ProductListDao productListDao = new ProductListDao();
		int totalProduct = productListDao.getTotalProduct();
		int totalPages = (int) Math.ceil(1.0*totalProduct/productPerPage);
		int index = (currentPage-1)*productPerPage;
		List<Product> productList = productListDao.getProductListForPage(index,productPerPage);
		
		PageBean pageBean = new PageBean();
		pageBean.setCurrentPage(currentPage);
		pageBean.setProductPerPage(productPerPage);
		pageBean.setTotalProduct(totalProduct);
		pageBean.setTotalPages(totalPages);
		pageBean.setProductList(productList);
		return pageBean;
	}

	public List<Object> getSerchingPnameList(String serchWord) throws SQLException {
		ProductListDao productListDao = new ProductListDao();
		List<Object> pnameList = productListDao.getSerchingPnameList(serchWord);
		return pnameList;
	}

}
