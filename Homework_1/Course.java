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
	// TODO maybe dn't need, were using it for registering students
	// public ArrayList<String> List_Of_Names;
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
		// TODO maybe delete
		// this.List_Of_Names = listofnames;
		this.Course_Instructor = courseinstructor;
		this.Course_Section_Number = coursesectionnumber;
		this.Course_Location = courselocation;
	}

	public String getId() {
		// TODO Auto-generated method stub
		return Course_Id;
	}

	public int getSection() {
		// TODO Auto-generated method stub
		return Course_Section_Number;
	}

}