package com.main.backend.FreshlandDairy.entity;


import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Supplier {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String username;
	private String name;
	private String item;
	private int price;
	private int phoneNo;
	private String address;
	private long accNo;
	
	
	
	protected Supplier() {
		
	}
	
	
	public Supplier(Long id, String username, String name, String item, int price, int phoneNo, String address, long accNo) {
		super();
		this.id = id;
		this.username = username;
		this.name = name;
		this.item = item;
		this.price = price;
		this.phoneNo = phoneNo;
		this.address = address;
		this.accNo = accNo;
	}
	

	




	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getAccNo() {
		return accNo;
	}

	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Supplier other = (Supplier) obj;
		return id == other.id;
	}
	
	
}
