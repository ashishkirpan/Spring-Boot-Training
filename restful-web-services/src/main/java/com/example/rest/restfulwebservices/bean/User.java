package com.example.rest.restfulwebservices.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "All details about User")
@Entity
public class User {

	@Id
	@GeneratedValue
	private Integer id;

	@Size(min = 2, message = "Name at least have 2 chars")
	@Schema(description = "Name at least have 2 chars")
	//@Column(name = "user_name")
	private String name;

	@Past(message = "Date must be less than today")
	@Schema(description = "Birthdate should be in the past")
	private Date birthDate;

	public User() {
	}
	
	public User(Integer id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}

}
