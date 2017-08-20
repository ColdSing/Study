package com.fxx.service;

import java.sql.SQLException;
import java.util.List;


import com.fxx.dao.AdminCategoryListDao;
import com.fxx.domain.Category;

public class AdminCategoryListService {

	public List<Category> findAllCategory() throws SQLException{
		AdminCategoryListDao adminCategoryListDao =new AdminCategoryListDao();
		List<Category> categoryList=adminCategoryListDao.findAllCategory();
		return categoryList;
	}

}
