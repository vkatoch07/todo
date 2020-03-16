package com.vk.todo.spring.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "todos")
public class Todos {

 @Id
 @Column(name = "id")
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Integer id;
 
 @Column(name = "user")
 private String user;
 
 @Column(name = "desc")
 private String desc;
 
 @Column(name = "targetDate")
 private String targetDate;
 
 @Column(name = "status")
 private String status;

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getUser() {
	return user;
}

public void setUser(String user) {
	this.user = user;
}

public String getDesc() {
	return desc;
}

public void setDesc(String desc) {
	this.desc = desc;
}



public String getTargetDate() {
	return targetDate;
}

public void setTargetDate(String targetDate) {
	this.targetDate = targetDate;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

@Override
public String toString() {
	return "todos [id=" + id + ", user=" + user + ", desc=" + desc + ", targetDate=" + targetDate + ", status=" + status
			+ "]";
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((desc == null) ? 0 : desc.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((status == null) ? 0 : status.hashCode());
	result = prime * result + ((targetDate == null) ? 0 : targetDate.hashCode());
	result = prime * result + ((user == null) ? 0 : user.hashCode());
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
	Todos other = (Todos) obj;
	if (desc == null) {
		if (other.desc != null)
			return false;
	} else if (!desc.equals(other.desc))
		return false;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	if (status == null) {
		if (other.status != null)
			return false;
	} else if (!status.equals(other.status))
		return false;
	if (targetDate == null) {
		if (other.targetDate != null)
			return false;
	} else if (!targetDate.equals(other.targetDate))
		return false;
	if (user == null) {
		if (other.user != null)
			return false;
	} else if (!user.equals(other.user))
		return false;
	return true;
}
  
 
}