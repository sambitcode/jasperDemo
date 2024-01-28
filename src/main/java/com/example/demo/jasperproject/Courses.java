package com.example.demo.jasperproject;

public class Courses {
	
	public String courseName;
	public String courseDetails;
	public Courses(String courseName, String courseDetails) {
		super();
		this.courseName = courseName;
		this.courseDetails = courseDetails;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseDetails() {
		return courseDetails;
	}
	public void setCourseDetails(String courseDetails) {
		this.courseDetails = courseDetails;
	}
	
	
}
