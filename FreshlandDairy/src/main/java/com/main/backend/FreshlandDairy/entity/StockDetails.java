package com.main.backend.FreshlandDairy.entity;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "stockdetails")
public class StockDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name = "SID")
	private String SID;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "discription")
	private String discription;
	
	@Column(name = "wight")
	private double wight;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "arrQty")
	private long arrQty;
	
	@Column(name = "reQty")
	private long reQty;
	
	@Column(name = "date")
	private String date;

	public StockDetails() {
		super();
	}

	public StockDetails(String sID, String name, String discription, double wight, double price, long arrQty,
			long reQty, String date) {
		super();
		SID = sID;
		this.name = name;
		this.discription = discription;
		this.wight = wight;
		this.price = price;
		this.arrQty = arrQty;
		this.reQty = reQty;
		this.date = date;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSID() {
		return SID;
	}

	public void setSID(String sID) {
		SID = sID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public double getWight() {
		return wight;
	}

	public void setWight(double wight) {
		this.wight = wight;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getArrQty() {
		return arrQty;
	}

	public void setArrQty(long arrQty) {
		this.arrQty = arrQty;
	}

	public long getReQty() {
		return reQty;
	}

	public void setReQty(long reQty) {
		this.reQty = reQty;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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
		StockDetails other = (StockDetails) obj;
		return id == other.id;
	}

}
