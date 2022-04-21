package com.inexture.manytomany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Component
@Scope("prototype")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int eid;
	private String empname;
	@ManyToMany
	private List<Project> projects;
	
	public Employee() {
		
	}

	public Employee(int eid, String empname) {
		this.eid = eid;
		this.empname = empname;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", empname=" + empname + ", projects=" + projects + "]";
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	
}
