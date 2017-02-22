package Homework_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Student extends User implements Serializable {

	private String firstName;
	private String lastName;
	private ArrayList<Course> courses;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Student() {

	}

	public Student(String password, String firstName, String lastName) {
		super(new String(firstName + lastName), password);
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public void printCourses() {
		for (Course course : courses) {
			System.out.println(course.Course_Name + " " + course.Course_Section_Number);
		}

	}

	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}

	public void addCourse(Course course) {
		courses.add(course);
	}

	public int courseIndex() {
		/**
		 * find index of course in courses ArrayList, or -1 if not found
		 */
		Scanner sc = new Scanner(System.in);
		// asking admin to enter course ID
		System.out.println("Enter course ID: ");
		String id = sc.nextLine();

		// asking admin to enter course name
		System.out.println("Enter course section number: ");
		int section = sc.nextInt();

		int index = -1;
		for (int x = 0; x < courses.size(); x++) {
			// find index of matching course, if it exists
			Course course = courses.get(x);
			if (section == course.getSection() && id.compareTo(course.getId()) == 0) {
				index = x;
			}
		}

		return index;
	}

	public void removeCourse(Course course) {
		/**
		 * remove a course
		 */
		courses.remove(courseIndex());
	}

	// public boolean equals(Student stu) {
	// /*
	// * return true if student has same first and last name
	// */
	// if (firstName.equals(stu.getFirstName()) &&
	// lastName.equals(stu.getLastName())) {
	// return true;
	// }
	// return false;
	// }

}