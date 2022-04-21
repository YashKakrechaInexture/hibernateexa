package com.inexture.onetomany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Entity
@Table(name="myStudents")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int sid;
	@Column(name="sname")
	private String name;
	@Transient
	private String city;
	@OneToMany(mappedBy="student")
	private List<Address> address;
	
	public Student() {
		
	}

	public Student(int sid, String name, String city) {
		this.sid = sid;
		this.name = name;
		this.city = city;
	}

	public int getSid() {
		return sid;
	}

	public void setId(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + ", city=" + city + ", address=" + address + "]";
	}

	
	
	
}
