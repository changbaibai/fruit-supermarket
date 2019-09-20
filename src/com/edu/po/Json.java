package com.edu.po;

public class Json {
	private String status;
	private String isSuccess;
	public Json() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Json(String status, String isSuccess) {
		super();
		this.status = status;
		this.isSuccess = isSuccess;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(String isSuccess) {
		this.isSuccess = isSuccess;
	}
	
}
