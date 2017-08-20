package com.fxx.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.fxx.domain.Product;
import com.fxx.utils.DataSourceUtil;
import com.fxx.vo.Condition;

public class ProductListDao {

	public List<Product> getProductList() throws SQLException {
		// 使用DataSourceUtil获得C3P0连接池，并创建DBUtil sql执行者
		QueryRunner queryRunner = new QueryRunner(DataSourceUtil.getDataSource());
		// 创建sql语句
		String sql = "select * from product where isDelete=0";
		// 执行sql
		List<Product> productList = queryRunner.query(sql, new BeanListHandler<Product>(Product.class));

		return productList;
	}

	public List<Product> getProductListByConditon(Condition condition) throws SQLException {
		// 使用DataSourceUtil获得C3P0连接池，并创建DBUtil sql执行者
		QueryRunner queryRunner = new QueryRunner(DataSourceUtil.getDataSource());
		// 创建sql语句,准备参数
		StringBuffer sql = new StringBuffer();
		List<String> paramsList = new ArrayList<String>();
		sql.append("select * from product where isDelete=0 ");
		// 商品名称条件
		if ( condition.getPname() != null && condition.getPname().trim() != "") {
			sql.append(" and pname like ? ");
			paramsList.add("%" + condition.getPname().trim() + "%");
		}
		// 商品热门条件
		if (condition.getIs_hot() != null && condition.getIs_hot().trim() != "") {
			sql.append(" and is_hot=? ");
			paramsList.add(condition.getIs_hot().trim());
		}
		// 商品最低价格条件
		if (condition.getLow_price() != null && condition.getLow_price().trim() != "") {
			sql.append(" and shop_price>? ");
			paramsList.add(condition.getLow_price().trim());
		}
		// 商品最高价格条件
		if (condition.getHigh_price() != null && condition.getHigh_price().trim() != "") {
			sql.append(" and shop_price<? ");
			paramsList.add(condition.getHigh_price().trim());
		}
		// 商品种类条件
		if (condition.getCid() != null && condition.getCid().trim() != "") {
			sql.append(" and cid=? ");
			paramsList.add(condition.getCid().trim());
		}
		// 执行sql
		List<Product> productList = queryRunner.query(sql.toString(), new BeanListHandler<Product>(Product.class),paramsList.toArray());

		return productList;
	}

	public int getTotalProduct() throws SQLException {
		//查询未删除商品总数量
		QueryRunner qr = new QueryRunner(DataSourceUtil.getDataSource());
		String sql = "select count(*) from product where isDelete=0";
		Long query = (Long) qr.query(sql, new ScalarHandler());
		return query.intValue();
	}

	public List<Product> getProductListForPage(int index, int productPerPage) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtil.getDataSource());
		String sql = "select * from product where isDelete=0 limit ?,?";
		List<Product> productList = qr.query(sql, new BeanListHandler<Product>(Product.class),index,productPerPage);
		return productList;
	}

	public List<Object> getSerchingPnameList(String serchWord) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtil.getDataSource());
		String sql = "select pname from product where pname like ?";
		List<Object> pnameList = null;
		pnameList=qr.query(sql, new ColumnListHandler(),"%"+serchWord+"%");
		return pnameList;
	}

}
