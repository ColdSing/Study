package com.fxx.dao;


import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.fxx.domain.User;
import com.fxx.utils.DataSourceUtil;

public class LoginDao {

	public User login(String username, String password) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtil.getDataSource());
		String sql="select * from user where username=? and password=?";
		User user = queryRunner.query(sql, new BeanHandler<User>(User.class),username,password);
		return user;
	}

}
