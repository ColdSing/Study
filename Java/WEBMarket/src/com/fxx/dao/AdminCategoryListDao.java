package com.fxx.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.fxx.domain.Category;
import com.fxx.utils.DataSourceUtil;

public class AdminCategoryListDao {

	public List<Category> findAllCategory() throws SQLException {
		// 使用DataSourceUtil获得C3P0连接池，并创建DBUtil sql执行者
		QueryRunner queryRunner = new QueryRunner(DataSourceUtil.getDataSource());
		// 创建sql语句
		String sql = "select * from category";
		// 执行sql
		List<Category> categoryList = queryRunner.query(sql, new BeanListHandler<Category>(Category.class));
		return categoryList;
	}

}
