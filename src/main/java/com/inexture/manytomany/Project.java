package com.inexture.manytomany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Component
@Scope("prototype")
public class Project {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int pid;
	private String pname;
	@ManyToMany(mappedBy="projects",fetch = FetchType.EAGER)
	private List<Employee> employees;
	
	public Project() {
		
	}

	public Project(int pid, String pname) {
		this.pid = pid;
		this.pname = pname;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	

	@Override
	public String toString() {
		
		String list = "";
		
		for(Employee e : employees) {
			if(!list.equals("")) {
				list += ", ";
			}
			list += e.getEid() + " : " + e.getEmpname();
		}
		
		return "Project [pid=" + pid + ", pname=" + pname + ", employees=[" + list + "]";
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	
}
