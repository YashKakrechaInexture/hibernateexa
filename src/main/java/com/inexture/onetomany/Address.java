package com.inexture.onetomany;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Entity
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int aid;
	private String home;
	private String country;
	@ManyToOne
	private Student student;
	
	
	public Address() {
		
	}

	public Address(String home, String country) {
		this.home = home;
		this.country = country;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Address [aid=" + aid + ", home=" + home + ", country=" + country + "]";
	}
	
	
}
