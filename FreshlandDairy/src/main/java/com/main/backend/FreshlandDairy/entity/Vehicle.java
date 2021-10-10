package com.main.backend.FreshlandDairy.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle" )
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "reg_number")
	private String reg_number;
	
	@Column(name = "veh_modle")
	private String veh_modle;
	
	@Column(name = "veh_category")
	private String veh_category;
	
	@Column(name = "year")
	private Date year;
	
	@Column(name = "deparment")
	private String deparment;
	
	
	public Vehicle() {}
	
	public Vehicle(long id, String reg_number, String veh_modle, String veh_category, Date year, String deparment) {
		super();
		this.id = id;
		this.reg_number = reg_number;
		this.veh_modle = veh_modle;
		this.veh_category = veh_category;
		this.year = year;
		this.deparment = deparment;
	}
	
	public String getDeparment() {
		return deparment;
	}

	public void setDeparment(String deparment) {
		this.deparment = deparment;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getReg_number() {
		return reg_number;
	}
	public void setReg_number(String reg_number) {
		this.reg_number = reg_number;
	}
	public String getVeh_modle() {
		return veh_modle;
	}
	public void setVeh_modle(String veh_modle) {
		this.veh_modle = veh_modle;
	}
	public String getVeh_category() {
		return veh_category;
	}
	public void setVeh_category(String veh_category) {
		this.veh_category = veh_category;
	}
	public Date getYear() {
		return year;
	}
	public void setYear(Date year) {
		this.year = year;
	}

	
}
