package com.student;
import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;



@Entity
@Table(name="world")
@EntityListeners(AuditingEntityListener.class)

public class Student {	
 public Student() {
		super();
	}

 @Id
 @GeneratedValue(strategy=GenerationType.AUTO)
 private int id;
 
 @Size(min=3, max=30)
 private String firstName;
 
 @Size(min=3, max=30)
 private String lastName;
 
 @NotEmpty
 private String sex;
 
 @Temporal(TemporalType.TIMESTAMP)
 @LastModifiedDate
 private Date date;
 
 @NotBlank
 private String email;
 
 @NotBlank
 private String country;
 
 public String getCountry() {
	return country;
}
 
public void setCountry(String country) {
	this.country = country;
}
 


public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getSex() {
	return sex;
}

public void setSex(String sex) {
	this.sex = sex;
}

public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}
 
}
