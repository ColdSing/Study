package com.fxx.service;

import java.sql.SQLException;

import com.fxx.dao.LoginDao;
import com.fxx.domain.User;

public class LoginService {

	public User login(String username, String password) throws SQLException {
		//��Dao�㴫���û�����
		LoginDao loginDao=new LoginDao();
		User user = loginDao.login(username,password);
		return user;
	}

}
