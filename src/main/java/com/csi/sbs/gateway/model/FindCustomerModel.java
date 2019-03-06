package com.csi.sbs.gateway.model;

import java.io.Serializable;

public class FindCustomerModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9067670765319443845L;

	private String ID;

	private String customerID;
	
	private String customerNumber;
	
	
	
	
	


	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

}
