package com.edu.po;

public class Order {
	private Integer id;
	private Integer busertable_id;
	private Integer amount;
	private Integer status;
	private String orderdate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getBusertable_id() {
		return busertable_id;
	}
	public void setBusertable_id(Integer busertable_id) {
		this.busertable_id = busertable_id;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}

}
