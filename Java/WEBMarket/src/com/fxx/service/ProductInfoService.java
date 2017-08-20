package com.fxx.service;

import java.sql.SQLException;

import com.fxx.dao.ProductInfoDao;
import com.fxx.domain.Product;

public class ProductInfoService {

	public Product getProduct(String pid) throws SQLException {
		ProductInfoDao productInfoDao =new ProductInfoDao();
		Product product=productInfoDao.getProduct(pid);
		return product;
	}

	

}
