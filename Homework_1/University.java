package Homework_1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class University {

	/*
	 * Instance Variables
	 */
	ArrayList<Course> courseList;
	Admin admin;
	ArrayList<Student> studentList;

	public University() {
		admin = new Admin("Admin", "Admin001");

		// TODO -- read course information from serialized file **if it exists**
		courseList = new ArrayList<Course>();
		loadCourseList();

		// if it doesn't, call createCourseList

		// TODO -- create studentList from serialized file
	}

	private void loadCourseList() {
		/*
		 * filePath -- path to serialized course information
		 * "MyUniversityCourses.ser"
		 */

		// ("/Users/LuisaHernandez/Documents/courses.ser");
		File myFile = new File("/Users/Zorro/arena/courses.ser");

		// try to load serialized courses
		try {
			FileInputStream fileIn = new FileInputStream(myFile);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			courseList = (ArrayList<Course>) in.readObject();
			in.close();
			fileIn.close();
		} catch (Exception e) {
			// read from csv file (first run)
			createCoursesFromFile();
		}

	}

	private void createCoursesFromFile() {
		/**
		 * read courses csv file, create courses from it
		 */
		// path to find excel document
		// File myFile = new File
		// ("/Users/LuisaHernandez/Documents/MyUniversityCourses.csv");
		File myFile = new File("/Users/Zorro/arena/MyUniversityCourses.csv");

		// creating scanner
		Scanner input;
		// ArrayList<Course> courseList = null;
		try {
			input = new Scanner(myFile);
			// creating new array
			// courseList = new ArrayList<Course>();
			// this should skip first horizontal line of document
			input.nextLine();
			// reading lines
			while (input.hasNextLine()) {
				String lineData = input.nextLine();
				// splitting by commas (excel feature)
				String[] data = lineData.split(",");
				Course myCourse = new Course(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]),
						data[5], Integer.parseInt(data[6]), data[7]);
				// adds data to courseList
				courseList.add(myCourse);

				// this is for testing and printing out what is contained in
				// myCourse
				// myCourse.print();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();

	}

	private void saveCourses() {
		/*
		 * write courses out to serialized file
		 * 
		 */

	}

	private void createCourseList() {
		// TODO Auto-generated method stub
		// ("/Users/LuisaHernandez/Documents/MyUniversityCourses.csv");
		File myFile = new File("/Users/Zorro/arena/MyUniversityCourses.csv");

		// creating scanner
		Scanner input;
		try {
			input = new Scanner(myFile);
			// creating new array
			courseList = new ArrayList<Course>();
			// this should skip first horizontal line of document
			input.nextLine();
			// reading lines
			while (input.hasNextLine()) {
				String lineData = input.nextLine();
				// splitting by commas (excel feature)
				String[] data = lineData.split(",");
				Course myCourse = new Course(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]),
						data[5], Integer.parseInt(data[6]), data[7]);
				// adds data to courseList
				courseList.add(myCourse);

				// this is for testing and printing out what is contained in
				// myCourse
				// myCourse.print();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void adminBlock() {
		System.out.println("You are in the admin block");
		// admin stuff goes here

		// sign in
		Scanner type = new Scanner(System.in);
		System.out.println("Username: ");
		String username = type.nextLine();
		System.out.println("Password: ");
		String password = type.nextLine();

		if (admin.login(username, password)) {
			char choice = 'a';
			while (choice != 'q') {
				System.out.println("Add course:\ta");
				System.out.println("Delete course:\td");
				System.out.println("Edit course:\te");
				System.out.println("Display course:\tc");
				System.out.println("Register student:\tr");
				System.out.println("Reports: \tt");
				Scanner sc = new Scanner(System.in);
				choice = sc.next().charAt(0);
				// choices will go here

			}
		} else {
			System.out.println("Incorrect login.  Notifying the authorities.");
		}
	}

	private void studentBlock() {
		// student stuff goes here
		System.out.println("You are in the student block");

		// sign in
		// require student to type in a username and password
		Scanner type = new Scanner(System.in);
		System.out.println("Username: ");
		String username = type.nextLine();
		System.out.println("Password: ");
		String password = type.nextLine();
		// if the username and password are correct, follow through with
		// TODO --revisit
		// see if user is a valid user:

		// Student stud = getStudent(username);
		// if (!(stud != null && stud.login(username, password))){
		// System.out.println("Not a valid student!");
		// return;
		// }
		// these options
		if (false) {
			char choice = 'a';
			// create Student object
			// Student student = new Student();
			while (choice != 'q') {
				System.out.println("View all courses available:\tv ");
				System.out.println("View all courses that are not full:\tf ");
				System.out.println("Register in a course:\tr");
				System.out.println("Withdraw from a course:\tw");
				System.out.println("View all courses you are enrolled in:\te");
				// create a new scanner
				Scanner sc = new Scanner(System.in);
				choice = sc.next().charAt(0);
				// choices will go here
			}
		}
	}

	public void save() {
		/**
		 * serialize the course list and the student list
		 */

		// File myFile = ("/Users/LuisaHernandez/Documents/courses.ser");
		File myFile = new File("/Users/Zorro/arena/courses.ser");

		// serialize course list
		try {
			FileOutputStream fileOut = new FileOutputStream(myFile);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(courseList);
			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}

		// serialize student list
		// TODO

	}

	public static void main(String[] args) {
		// do all our stuff here
		University ub = new University();

		// create course list
		ub.createCourseList();

		// student or admin?
		Scanner in = new Scanner(System.in);
		System.out.println("Speak ye, student or admin?");
		String status = in.nextLine();

		if (status.compareTo("admin") == 0) {
			// go to admin block
			ub.adminBlock();
		} else if (status.compareTo("student") == 0) {
			// go to student block
			ub.studentBlock();
		} else {
			System.out.println("You must enter admin or student.");
		}
		ub.save();

	}

}
