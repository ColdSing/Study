package com.fxx.service;

import java.sql.SQLException;

import com.fxx.dao.AdminProductSaveDao;
import com.fxx.domain.Product;

public class AdminProductSaveService {

	public boolean saveProduct(Product product) throws SQLException {
		//����װ�õ�product���󴫵���dao��
		AdminProductSaveDao adminProductSaveDao = new AdminProductSaveDao();
		boolean isSaved=adminProductSaveDao.saveProduct(product);
		return isSaved;
	}

	
}
