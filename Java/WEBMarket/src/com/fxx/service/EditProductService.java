package com.fxx.service;

import java.sql.SQLException;

import com.fxx.dao.EditProductDao;
import com.fxx.domain.Product;

public class EditProductService {

	public Product getProduct(String pid) throws SQLException {
		EditProductDao editProductDao = new EditProductDao();
		Product product = editProductDao.getProduct(pid);
		return product;
	}

}
