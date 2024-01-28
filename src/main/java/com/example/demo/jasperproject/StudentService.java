package com.example.demo.jasperproject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

	public List<Student> getStudentDetails() {
		List<Student> studentList = new ArrayList<>();
		Courses course1 = new Courses("sci","science");
		Courses course2 = new Courses("arts","arts");
		Courses course3 = new Courses("comm","comm");
		List<Courses> courseList1 = new ArrayList<>();
		List<Courses> courseList2 = new ArrayList<>();
		courseList1.add(course1);
		courseList1.add(course2);
		courseList2.add(course3);
		Gadgets gadget1 = new Gadgets("laptop","electronic");
		Gadgets gadget2 = new Gadgets("mobile","electronic");
		List<Gadgets> gadgetList = new ArrayList<>();
		gadgetList.add(gadget1);
		gadgetList.add(gadget2);
		Student student1 = new Student("Sambit", 30, courseList1, gadgetList);
		Student student2 = new Student("Ayan", 31, courseList2, gadgetList);
		studentList.add(student1);
		studentList.add(student2);
		return studentList;
	}
}
