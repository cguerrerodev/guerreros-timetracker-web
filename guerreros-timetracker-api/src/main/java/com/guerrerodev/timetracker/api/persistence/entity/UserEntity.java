package com.guerrerodev.timetracker.api.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "gstt_user")
public class UserEntity {

	@Id
	private int id;
	
	private String name;
	
	private String eMail;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
