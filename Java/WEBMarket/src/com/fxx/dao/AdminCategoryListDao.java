package com.fxx.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.fxx.domain.Category;
import com.fxx.utils.DataSourceUtil;

public class AdminCategoryListDao {

	public List<Category> findAllCategory() throws SQLException {
		// ʹ��DataSourceUtil���C3P0���ӳأ�������DBUtil sqlִ����
		QueryRunner queryRunner = new QueryRunner(DataSourceUtil.getDataSource());
		// ����sql���
		String sql = "select * from category";
		// ִ��sql
		List<Category> categoryList = queryRunner.query(sql, new BeanListHandler<Category>(Category.class));
		return categoryList;
	}

}
