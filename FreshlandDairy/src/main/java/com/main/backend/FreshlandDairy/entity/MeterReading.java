package com.main.backend.FreshlandDairy.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "meter_reading" )
public class MeterReading {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "vehicle_number")
	private String vehicle_number;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "start_read")
	private String start_read;
	
	@Column(name = "end_read")
	private String end_read;
	
	@Column(name = "balence")
	private String balence;
	
	public MeterReading() {}
	
	public MeterReading(long id, String vehicle_number, Date date, String start_read, String end_read, String balence) {
		super();
		this.id = id;
		this.vehicle_number = vehicle_number;
		this.date = date;
		this.start_read = start_read;
		this.end_read = end_read;
		this.balence = balence;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getVehicle_number() {
		return vehicle_number;
	}

	public void setVehicle_number(String vehicle_number) {
		this.vehicle_number = vehicle_number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStart_read() {
		return start_read;
	}

	public void setStart_read(String start_read) {
		this.start_read = start_read;
	}

	public String getEnd_read() {
		return end_read;
	}

	public void setEnd_read(String end_read) {
		this.end_read = end_read;
	}

	public String getBalence() {
		return balence;
	}

	public void setBalence(String balence) {
		this.balence = balence;
	}
	

}
