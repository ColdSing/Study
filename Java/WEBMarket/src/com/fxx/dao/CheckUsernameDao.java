package com.fxx.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.fxx.utils.DataSourceUtil;

public class CheckUsernameDao {

	public boolean check(String username) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtil.getDataSource());
		String sql ="select count(*) from user where username=?";
		Long query = (Long)qr.query(sql, new ScalarHandler(), username);
		return query>0?true:false;
	}

}
