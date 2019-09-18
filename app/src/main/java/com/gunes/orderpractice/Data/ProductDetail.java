package com.gunes.orderpractice.Data;

import com.google.gson.annotations.SerializedName;

public class ProductDetail{

	@SerializedName("summaryPrice")
	private double summaryPrice;

	@SerializedName("orderDetail")
	private String orderDetail;

	public void setSummaryPrice(double summaryPrice){
		this.summaryPrice = summaryPrice;
	}

	public double getSummaryPrice(){
		return summaryPrice;
	}

	public void setOrderDetail(String orderDetail){
		this.orderDetail = orderDetail;
	}

	public String getOrderDetail(){
		return orderDetail;
	}
}