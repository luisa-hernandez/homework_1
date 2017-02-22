package Homework_1;

import java.util.Comparator;
import java.io.Serializable;
import java.util.ArrayList;

public class Course implements Serializable {
	// initializing variables
	public String Course_Name;
	public String Course_Id;
	public int Maximum_Students;
	public int Current_Students;
	public String Course_Instructor;
	public int Course_Section_Number;
	public String Course_Location;
	public ArrayList<Student> students;

	public boolean compareTo(Course c) {
		return c.Current_Students < this.Current_Students;
		// return c.Maximum_Students.compareTo(this.Maximum_Students);
	}

	public Course(String coursename, String courseid, int maximumstudents, int currentstudents, String courseinstructor,
			int coursesectionnumber, String courselocation) {
		this.Course_Name = coursename;
		this.Course_Id = courseid;
		this.Maximum_Students = maximumstudents;
		this.Current_Students = currentstudents;
		this.Course_Instructor = courseinstructor;
		this.Course_Section_Number = coursesectionnumber;
		this.Course_Location = courselocation;
		
		this.students = new ArrayList<Student>();
	}

	public String getId() {
		// TODO Auto-generated method stub
		return Course_Id;
	}

	public int getSection() {
		// TODO Auto-generated method stub
		return Course_Section_Number;
	}

	public void printInfo() {
		System.out.println("Course Name: " + Course_Name);
		System.out.println("Course ID: " + Course_Id);
		System.out.println("Maximum Students: " + Maximum_Students);
		System.out.println("Current Students: " + Current_Students);
		// System.out.println("List of Names: " +
		// List_Of_Names);
		System.out.println("Course Instructor: " + Course_Instructor);
		System.out.println("Course Section Number: " + Course_Section_Number);
		System.out.println("Course Location: " + Course_Location);
	}

}