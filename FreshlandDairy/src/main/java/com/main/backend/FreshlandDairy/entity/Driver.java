package com.main.backend.FreshlandDairy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "driver" )
public class Driver {
	
	public Driver() {
		
	}
	
	public Driver(long id, String dfirstName, String license, String email) {
		super();
		this.id = id;
		this.dfirstName = dfirstName;
		this.license = license;
		this.email = email;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "dfirst_name")
	private String dfirstName;
	
	@Column(name = "license")
	private String license;
	
	@Column(name = "email")
	private String email;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDfirstName() {
		return dfirstName;
	}

	public void setDfirstName(String dfirstName) {
		this.dfirstName = dfirstName;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
