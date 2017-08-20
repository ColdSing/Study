package com.fxx.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.fxx.domain.Product;
import com.fxx.utils.DataSourceUtil;

public class AdminProductDoEditDao {

	public boolean doEdit(Product product) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtil.getDataSource());
		boolean isEdited = false;
		String sql ="update product set pname=?,is_hot=?,market_price=?,shop_price=?,cid=?,pdesc=? where pid=?";
		int update = qr.update(sql,product.getPname(),product.getIs_hot(),product.getMarket_price(),
				product.getShop_price(),product.getCid(),product.getPdesc(),product.getPid());
		if(update>0) {
			isEdited=true;
		}
		return isEdited;
	}

}
