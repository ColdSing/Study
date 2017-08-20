package com.fxx.service;

import java.sql.SQLException;

import com.fxx.dao.AdminDeleteProductDao;

public class AdminDeleteProductService {

	public boolean doDelete(String pid) throws SQLException {
		AdminDeleteProductDao adminDeleteProductDao = new AdminDeleteProductDao();
		boolean isDelet=adminDeleteProductDao.doDelete(pid);
		return isDelet;
	}

}
