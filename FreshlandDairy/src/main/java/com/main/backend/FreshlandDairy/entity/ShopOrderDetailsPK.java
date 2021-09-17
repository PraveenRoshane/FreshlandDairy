package com.main.backend.FreshlandDairy.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ShopOrderDetailsPK implements Serializable{
	
	
	private Long transactionID;
	
	
	private Long productID;

	public ShopOrderDetailsPK() {
		super();
	}

	public ShopOrderDetailsPK(Long transactionID, Long productID) {
		super();
		this.transactionID = transactionID;
		this.productID = productID;
	}

	public Long getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(Long transactionID) {
		this.transactionID = transactionID;
	}

	public Long getProductID() {
		return productID;
	}

	public void setProductID(Long productID) {
		this.productID = productID;
	}
	
	

}
