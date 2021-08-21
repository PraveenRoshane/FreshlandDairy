package com.main.backend.FreshlandDairy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Shop_Orders")
public class ShopOrder {
	
	@Id
	@Column(name = "TransactionID" )
	private Long transactionID;
	
	@Column(name = "CustomerID" )
	private String customerID;
	
	@Column(name = "CustomerName" )
	private String customerName;
	
	@Column(name = "TransactionAmount" )
	private Double amount;
	
	public ShopOrder() {}

	public ShopOrder(Long transactionID, String customerID, String customerName, Double amount) {
		super();
		this.transactionID = transactionID;
		this.customerID = customerID;
		this.customerName = customerName;
		this.amount = amount;
	}

	public Long getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(Long transactionID) {
		this.transactionID = transactionID;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}	

}


