package com.fxx.regist;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.fxx.domain.User;
import com.fxx.utils.C3P0DataSource;

public class RegistServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Map<String, String[]> parameterMap = request.getParameterMap();
		User user = new User();
		try {
			BeanUtils.copyProperties(user, parameterMap);
			user.setUid(UUID.randomUUID().toString());
			if (regist(user)) {

			} else {

			}
		} catch (IllegalAccessException | InvocationTargetException | SQLException e) {
			e.printStackTrace();
		}
		

	}

	public boolean regist(User user) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0DataSource.getDataSource());
		String sql = "select * from user where username=?";
		User query = qr.query(sql, new BeanHandler<User>(User.class), user.getUsername());
		if (query != null) {
			return false;
		} else {
			sql="insert into user values(?,?,?,?,?,?,?,?,?,?)";
			qr.update(sql,user.getUid(),user.getUsername(),user.getPassword(),user.getName(),user.getEmail(),
					user.getTelephone(),user.getBirthday(),user.getSex(),null,null);
			return true;
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}