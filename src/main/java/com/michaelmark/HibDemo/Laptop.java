package com.michaelmark.HibDemo;

import java.util.*;

import javax.persistence.*;

@Entity
public class Laptop {
	@Id 
	private int lid;
	private String lname;
	@ManyToMany // mapping for one student having multiple laptops
	private List<Student> student = new ArrayList<>();
	
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "Laptop [lid=" + lid + ", lname=" + lname + "]";
	}
	
	
	

}
