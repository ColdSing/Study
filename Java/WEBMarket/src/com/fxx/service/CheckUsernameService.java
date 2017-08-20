package com.fxx.service;

import java.sql.SQLException;

import com.fxx.dao.CheckUsernameDao;

public class CheckUsernameService {

	public boolean check(String username) throws SQLException {
		CheckUsernameDao checkUsernameDao = new CheckUsernameDao();
		boolean usernameExsit = checkUsernameDao.check(username);
		return usernameExsit; 
	}

}
