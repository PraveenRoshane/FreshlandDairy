package com.main.backend.FreshlandDairy.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Attend {
		
		@Id
		@GeneratedValue
		private Long aid;
		private String eid;
		private String username;
		
		private String month;
		private int acount;
		
		public Attend() {
			
		}
		
		public Attend(Long aid, String eid, String username, String month, int acount) {
			super();
			this.aid = aid;
			this.eid =eid;
			this.username = username;
			
			this.month = month;
			this.acount= acount;
		}
		public Long getAid() {
			return aid;
		}
		public void setAid(Long aid) {
			this.aid = aid;
		}
		
				
		public String getEid() {
			return eid;
		}

		public void setEid(String eid) {
			this.eid = eid;
		}

		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		
		public String getMonth() {
			return month;
		}
		public void setMonth(String month) {
			this.month = month;
		}
		
				
		public int getAcount() {
			return acount;
		}

		public void setAcount(int acount) {
			this.acount = acount;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (int) (aid ^ (aid >>> 32));
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
			Attend other = (Attend) obj;
			if (aid != other.aid)
				return false;
			return true;
		}
		

		
		
	

}
