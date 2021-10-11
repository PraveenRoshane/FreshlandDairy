package com.main.backend.FreshlandDairy.entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Supply {
	@Id
	@GeneratedValue
	private Long sid;
	private String sname;
	private int amount;
	private int qty;
	private Date date;
	private String username;
	
	
	protected Supply() {
		
	}
	
	public Supply(Long sid, String sname, int amount, int qty, Date date, String username) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.amount = amount;
		this.qty = qty;
		this.date = date;
		this.username = username;
	}


	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public int hashCode() {
		return Objects.hash(sid);
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Supply other = (Supply) obj;
		return sid == other.sid;
	}





}
