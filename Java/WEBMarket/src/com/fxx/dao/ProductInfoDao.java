package com.fxx.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.fxx.domain.Product;
import com.fxx.utils.DataSourceUtil;

public class ProductInfoDao {

	public Product getProduct(String pid) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtil.getDataSource());
		String sql= "select * from product where pid=?";
		Product product = queryRunner.query(sql, new BeanHandler<Product>(Product.class), pid);
		return product;
	}

}
