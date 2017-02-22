package Homework_1;

import java.awt.Choice;
import java.io.BufferedWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class Admin extends User {

	ArrayList<Student> students;
	ArrayList<Course> courses;

	// create a constructor
	public Admin(String username, String password, ArrayList<Student> students, ArrayList<Course> courses) {
		super(username, password);
		this.students = students;
		this.courses = courses;
	}

	// add a course method
	public void addCourse() {
		// ask user to enter new course name
		Scanner cs = new Scanner(System.in);
		System.out.println("Enter course name: ");
		String courseName = cs.nextLine();

		// ask user to enter new course ID
		System.out.println("Enter course ID: ");
		String courseId = cs.nextLine();

		// ask user to enter new maximum number of students
		System.out.println("Enter Maximum Number of Students: ");
		int maxStudents = cs.nextInt();

		// ask user to enter new current number of students
		System.out.println("Enter Current Number of Students: ");
		int currentStudents = cs.nextInt();

		// ask user to enter new course instructor
		System.out.println("Enter course Instructor: ");
		cs.nextLine();
		String courseInstructor = cs.nextLine();

		// ask user to enter new course section
		System.out.println("Enter course Section: ");
		int courseSection = cs.nextInt();

		// ask user to enter new course location
		System.out.println("Enter course Location: ");
		cs.nextLine();
		String courseLocation = cs.nextLine();

		// create new objects of class Course
		Course c = new Course(courseName, courseId, maxStudents, currentStudents, courseInstructor, courseSection,
				courseLocation);

		// add these objects to the class list
		courses.add(c);
	}

	// delete a course method
	public void deleteCourse() {
		// create scanner
		Scanner sc = new Scanner(System.in);

		// asking admin to enter course ID
		System.out.println("Enter course ID: ");
		String id = sc.nextLine();

		// asking admin to enter course name
		System.out.println("Enter course section number: ");
		int section = sc.nextInt();

		// loop through the array list
		int index = -1;
		for (int x = 0; x < courses.size(); x++) {
			// find index of matching course, if it exists
			Course course = courses.get(x);
			if (section == course.getSection() && id.compareTo(course.getId()) == 0) {
				index = x;
			}
		}
		if (index > -1) {
			courses.remove(index);
		}
	}

	// edit a course method
	public void editCourse() {
		int index = findCourse();

		// looping through the array list
		if (index > -1) {
			Course course = courses.get(index);
			// if the course ID user input matches an existing ID, display which
			// course information they would like to edit
			System.out.println("Which field do you want to change? ");
			System.out.println("Course Name: \n1");
			System.out.println("Course ID \n2");
			System.out.println("Maximum Students \n3");
			System.out.println("Current Students \n4");
			// System.out.println("List of Names \n5");
			System.out.println("Course Instructor \n6");
			System.out.println("Course Section Number \n7");
			System.out.println("Course Location \n8");

			// get choice
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Enter a new course name: ");
				course.Course_Name = sc.nextLine();
				break;

			case 2:
				System.out.println("Enter a new course ID: ");
				course.Course_Id = sc.nextLine();
				break;

			case 3:
				System.out.println("Enter a new maximum number of students: ");
				course.Maximum_Students = sc.nextInt();
				break;

			case 4:
				System.out.println("Enter a new current number of students: ");
				course.Current_Students = sc.nextInt();
				break;

			// case 5:
			// System.out.println("Enter a new name of a student: ");
			// String firstName = sc.nextLine();
			// // course.List_Of_Names.add(firstName);
			// break;

			case 6:
				System.out.println("Enter a new course instructor: ");
				course.Course_Instructor = sc.nextLine();
				break;

			case 7:
				System.out.println("Enter a new course section number: ");
				course.Course_Section_Number = sc.nextInt();
				break;

			case 8:
				System.out.println("Enter a new course location: ");
				course.Course_Location = sc.nextLine();
				break;

			default:
				System.out.println("invalid choice");
			}

		} else {
			System.out.println("Course not found.\n");
		}
	}

	public int findCourse() {
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

	public void displayCourse() {
		/**
		 * if the course ID user input matches an existing ID, display the
		 * course information
		 */

		int index = findCourse();
		if (index > -1) {
			courses.get(index).printInfo();
		} else {
			System.out.println("Course not found.");
		}

	}

	public void registerStudent() {
		/**
		 * Create a student object and add it to student list.
		 */

		// ask for username, password, and first & last name
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter first name:\n");
		String firstName = sc.nextLine();

		System.out.println("Enter last name:\n");
		String lastName = sc.nextLine();

		System.out.println("Enter a password:\n");
		String password = sc.nextLine();

		// create a student object
		Student stu = new Student(password, firstName, lastName);
		stu.setCourses(new ArrayList<Course>());

		// put student in list of students
		students.add(stu);

	}

	// view all courses method
	public void viewCourses() {
		for (int i = 0; i < courses.size(); i++) {
			System.out.println("The course name is: " + courses.get(i).Course_Name);
			System.out.println("The course ID is: " + courses.get(i).Course_Id);
			System.out.println("The number of students in the course is:  " + courses.get(i).Current_Students);
			System.out.println("The maximum number of students that can be enrolled in this class is: "
					+ courses.get(i).Maximum_Students + "\n");

		}
	}

	public ArrayList<Course> getFullCourses() {
		/**
		 * returns list of full courses
		 */

		ArrayList<Course> full = new ArrayList<Course>();

		// looping through the array list
		for (Course course : courses) {
			// if the number of existing students matches max students, the
			// course is full
			if (course.Current_Students == course.Maximum_Students) {
				full.add(course);
			}
		}
		return full;
	}

	public void viewFullCourses() {
		/**
		 * view all courses that are full method
		 * 
		 */
		for (Course course : getFullCourses()) {
			System.out.println("The course " + course.Course_Name + " is full.");
		}

	}

	public void writeFullCourses() {
		/**
		 * write list of full courses
		 */
		BufferedWriter file;
		try {

			// FileWriter("/Users/LuisaHernandez/Documents/FullMyUniversityCourses/full_courses.ser"));
			file = new BufferedWriter(new FileWriter("/Users/Zorro/arena/full_courses.txt"));
			// looping through the array list
			for (Course course : getFullCourses()) {
				file.write(course.Course_Name + " " + course.Course_Id + "\n");
			}
			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void registeredStudents() {
		/**
		 * print registered students' names
		 */
		int index = findCourse();
		Course course = courses.get(index);

		for (Student stu : course.students) {
			System.out.println(stu.getFirstName() + " " + stu.getLastName());
		}
		System.out.println("");
	}

	// public void studentCourses() {
	// Scanner sc= new Scanner(System.in);
	// //ask the user to enter a student's first name
	// System.out.println("Enter student's first name: ");
	// String firstName = sc.nextLine();
	//
	// Scanner s_c= new Scanner(System.in);
	// //ask the user to enter a student's last name
	// System.out.println("Enter student's last name: ");
	// String lastName = s_c.nextLine();
	//
	// //looping through the array list
	// System.out.println("The following are courses that a student is in: ");
	// for(int i=0; i<courses.size(); i++){
	// for(int j=0; i<courses.get(i).List_Of_Names.size(); j++){
	// //if the first name and last name match up, display the course
	// information
	// if (firstName == courses.get(i).firstName && lastName
	// ==courses.get(i).lastName){
	// System.out.println(courses.get(i).Course_Name);
	// }
	// }
	// }
	// }

	// public void sortCourses(ArrayList<Course> courseList){
	// Collections.sort(courseList);
	// }

	public void reports() throws Exception {
		char choice = 'a';
		while (choice != 'q') {
			System.out.println("View all courses:\tv ");
			System.out.println("View all FULL courses:\tf ");
			System.out.println("Write to a file of full courses:\tw ");
			System.out.println("View students in course:\ts ");
			System.out.println("View student courses:\tc ");
			System.out.println("Sort courses:\ta ");
			System.out.println("Quit:\t\tq");
			Scanner sc = new Scanner(System.in);
			choice = sc.next().charAt(0);
			switch (choice) {
			case 'a':
				sortCourses();
				break;
			case 'c':
				viewStudentCourses();
				break;
			case 'f':
				viewFullCourses();
				break;
			case 's':
				registeredStudents();
				break;
			case 'v':
				viewCourses();
				break;
			case 'w':
				writeFullCourses();
				break;
			case 'q':
				return;
			default:
				System.out.println("invalid choice");
			}
		}
	}

	private void sortCourses() {
		Collections.sort(courses);
	}

	private void viewStudentCourses() {
		/**
		 * view a students courses
		 */
		Student stu = getStudent();
		if (stu != null) {
			stu.printCourses();
		}
	}

	private Student getStudent() {
		Scanner sc = new Scanner(System.in);
		// first name
		System.out.println("First name:");
		String firstName = sc.nextLine();
		// last name
		System.out.println("Last name:");
		String lastName = sc.nextLine();

		for (Student stu : students) {
			if (firstName.equals(stu.getFirstName()) && lastName.equals(stu.getLastName())) {
				return stu;
			}
		}
		return null;
	}

	public void manageCourses() throws Exception {
		char choice = 'a';
		while (choice != 'q') {
			System.out.println("Add course:\t\ta");
			System.out.println("Delete course:\t\td");
			System.out.println("Edit course:\t\te");
			System.out.println("Display course:\t\tc");
			System.out.println("Register student:\tr");
			System.out.println("Quit:\t\tq");
			Scanner sc = new Scanner(System.in);
			choice = sc.next().charAt(0);
			// choices will go here
			switch (choice) {
			case 'a':
				addCourse();
				break;
			case 'd':
				deleteCourse();
				break;
			case 'e':
				editCourse();
				break;
			case 'c':
				displayCourse();
				break;
			case 'r':
				registerStudent();
				break;
			case 't':
				reports();
				break;
			case 'q':
				return;
			default:
				System.out.println("invalid choice");
				break;
			}

		}
	}

}
