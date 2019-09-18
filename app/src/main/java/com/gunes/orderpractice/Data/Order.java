package com.gunes.orderpractice.Data;

import com.google.gson.annotations.SerializedName;

public class Order{

	@SerializedName("date")
	private String date;

	@SerializedName("marketName")
	private String marketName;

	@SerializedName("month")
	private String month;

	@SerializedName("productDetail")
	private ProductDetail productDetail;

	@SerializedName("productState")
	private String productState;

	@SerializedName("productPrice")
	private double productPrice;

	@SerializedName("orderName")
	private String orderName;

	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}

	public void setMarketName(String marketName){
		this.marketName = marketName;
	}

	public String getMarketName(){
		return marketName;
	}

	public void setMonth(String month){
		this.month = month;
	}

	public String getMonth(){
		return month;
	}

	public void setProductDetail(ProductDetail productDetail){
		this.productDetail = productDetail;
	}

	public ProductDetail getProductDetail(){
		return productDetail;
	}

	public void setProductState(String productState){
		this.productState = productState;
	}

	public String getProductState(){
		return productState;
	}

	public void setProductPrice(double productPrice){
		this.productPrice = productPrice;
	}

	public double getProductPrice(){
		return productPrice;
	}

	public void setOrderName(String orderName){
		this.orderName = orderName;
	}

	public String getOrderName(){
		return orderName;
	}
}