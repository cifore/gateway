package com.csi.sbs.gateway.model;

public class HeaderModel {

	private String userID;

	private String countryCode;

	private String clearingCode;

	private String branchCode;
	
	private String customerNumber;
	
	private String loginName;
	
	private String sandBoxId;
	
	
	
	

	public String getSandBoxId() {
		return sandBoxId;
	}

	public void setSandBoxId(String sandBoxId) {
		this.sandBoxId = sandBoxId;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getClearingCode() {
		return clearingCode;
	}

	public void setClearingCode(String clearingCode) {
		this.clearingCode = clearingCode;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

}
