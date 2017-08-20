package com.fxx.service;

import java.sql.SQLException;

import com.fxx.dao.AdminProductSaveDao;
import com.fxx.domain.Product;

public class AdminProductSaveService {

	public boolean saveProduct(Product product) throws SQLException {
		//将封装好的product对象传递至dao层
		AdminProductSaveDao adminProductSaveDao = new AdminProductSaveDao();
		boolean isSaved=adminProductSaveDao.saveProduct(product);
		return isSaved;
	}

	
}
