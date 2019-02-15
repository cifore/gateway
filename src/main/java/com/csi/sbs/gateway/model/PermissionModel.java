package com.csi.sbs.gateway.model;

public class PermissionModel {

	private String userID;

	private String countryCode;

	private String clearingCode;

	private String branchCode;

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
