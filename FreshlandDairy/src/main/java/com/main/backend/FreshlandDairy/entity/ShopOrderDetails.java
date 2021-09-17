package com.main.backend.FreshlandDairy.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "shop_orders_details")
public class ShopOrderDetails {
	
	@EmbeddedId
	ShopOrderDetailsPK shopOrderDetailsPK;
	
	@Column(name = "ProductName" )
	private String name;
	
	@Column(name = "Quantity" )
	private int quantity;
	
	@Column(name = "Total" )
	private Double total;	

	public ShopOrderDetails() {
		super();
	}	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ShopOrderDetailsPK getShopOrderDetailsPK() {
		return shopOrderDetailsPK;
	}

	public void setShopOrderDetailsPK(ShopOrderDetailsPK shopOrderDetailsPK) {
		this.shopOrderDetailsPK = shopOrderDetailsPK;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	
	
	
}
