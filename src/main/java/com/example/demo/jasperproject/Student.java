package com.example.demo.jasperproject;

import java.util.List;

public class Student {

	private String name;
	private int age;
	List<Courses> courses;
	List<Gadgets> gadgetsList;

	public Student(String name, int age, List<Courses> courses) {
		super();
		this.name = name;
		this.age = age;
		this.courses = courses;
	}

	public Student(String name, int age, List<Courses> courses, List<Gadgets> gadgetsList) {
		super();
		this.name = name;
		this.age = age;
		this.courses = courses;
		this.gadgetsList = gadgetsList;
	}

	public List<Gadgets> getGadgetsList() {
		return gadgetsList;
	}

	public void setGadgetsList(List<Gadgets> gadgetsList) {
		this.gadgetsList = gadgetsList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Courses> getCourses() {
		return courses;
	}

	public void setCourses(List<Courses> courses) {
		this.courses = courses;
	}

}
