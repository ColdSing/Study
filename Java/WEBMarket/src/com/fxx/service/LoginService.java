package com.fxx.service;

import java.sql.SQLException;

import com.fxx.dao.LoginDao;
import com.fxx.domain.User;

public class LoginService {

	public User login(String username, String password) throws SQLException {
		//向Dao层传递用户数据
		LoginDao loginDao=new LoginDao();
		User user = loginDao.login(username,password);
		return user;
	}

}
