package com.main.backend.FreshlandDairy.entity;

//import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
//table name
public class MyApp {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String username; //adding new
	private String name; ///added new stuff
	private String nic;
	private String eid;
	private String address;
	private String gender;
	private int contactno;
	private String designation;
	private String targetDate;
	private String email;
	private boolean isDone;
	
	protected MyApp() {
		
	}
	
		
								//added new stuff
	public MyApp(long id, String username, String name, String nic, String eid, String address, String gender, int contactno, String designation, String targetDate, boolean isDone, String email) { //adding new
		super();
		this.id = id;
		this.username = username;
		this.name=name;  //added new stuff
		this.nic=nic;
		this.eid=eid;
		this.address = address;
		this.gender=gender;
		this.contactno=contactno;
		this.designation=designation;
		this.targetDate = targetDate;
		this.isDone = isDone;
		this.email=email;
	}
	
		
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	//adding new get and set
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	
	//added new stuff
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	


	public String getNic() {
		return nic;
	}


	public void setNic(String nic) {
		this.nic = nic;
	}
	
	


	public String getEid() {
		return eid;
	}


	public void setEid(String eid) {
		this.eid = eid;
	}


	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
	  //gender
	public String getGender() {
		return gender;
	}

	public String getAddress() {
		return address;
	}

		//address
	public void setAddress(String address) {
		this.address = address;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}	
		//contactno
	public int getContactno() {
		return contactno;
	}


	public void setContactno(int contactno) {
		this.contactno = contactno;
	}
	
		
	
	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public String getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(String targetDate) {
		this.targetDate = targetDate;
	}
	public boolean isDone() {
		return isDone;
	}
	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyApp other = (MyApp) obj;
		if (id != other.id)
			return false;
		return true;
	}
		
	

}
 