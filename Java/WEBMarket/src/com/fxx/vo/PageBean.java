package com.fxx.vo;

import java.util.ArrayList;
import java.util.List;

import com.fxx.domain.Product;

public class PageBean {

	//当前页数
	private int currentPage;
	//当前页商品
	private List<Product> productList = new ArrayList<Product>();
	//每页商品数量
	private int productPerPage;
	//总页数
	private int totalPages;
	//商品总数量
	private int totalProduct;
	public int getCurrentPage() {
		return currentPage;
	}
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	public int getProductPerPage() {
		return productPerPage;
	}
	public void setProductPerPage(int productPerPage) {
		this.productPerPage = productPerPage;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getTotalProduct() {
		return totalProduct;
	}
	public void setTotalProduct(int totalProduct) {
		this.totalProduct = totalProduct;
	}
}
