package com.fxx.dao;


import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.fxx.utils.DataSourceUtil;

public class AdminDeleteProductDao {

	public boolean doDelete(String pid) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtil.getDataSource());
		String sql = "update product set isDelete=1 where pid=?";
		boolean isDelete = false;
		int update = qr.update(sql,pid);
		if(update>0) {
			isDelete=true;
		}
		return isDelete;
	}

}
