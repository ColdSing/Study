package com.fxx.dao;


import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.fxx.domain.Product;
import com.fxx.utils.DataSourceUtil;

public class AdminProductSaveDao {

	public boolean saveProduct(Product product) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtil.getDataSource());
		String sql = "insert into product values(?,?,?,?,?,?,?,?,?,?,?,?)";
		boolean isSaved=false;
	
		int update = qr.update(sql,product.getPid(),product.getPname(),product.getMarket_price(),
				product.getShop_price(),product.getPimage(),product.getPdate(),product.getIs_hot(),
				product.getPdesc(),product.getPflag(),product.getCid(),product.getIsDelete(),null);
		if(update>0) {
			isSaved=true;
		}
		return isSaved;
	}

}
