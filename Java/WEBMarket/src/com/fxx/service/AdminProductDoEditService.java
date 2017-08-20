package com.fxx.service;

import java.sql.SQLException;

import com.fxx.dao.AdminProductDoEditDao;
import com.fxx.domain.Product;

public class AdminProductDoEditService {

	public boolean doEdit(Product product) throws SQLException {
		AdminProductDoEditDao adminProductDoEditDao = new AdminProductDoEditDao();
		boolean isEdited=adminProductDoEditDao.doEdit(product);
		return isEdited;
	}

}
