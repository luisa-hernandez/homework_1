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
	ArrayList<Course> courses;
	Admin admin;
	ArrayList<Student> students;
	private static Scanner input;

	public University() {
		// create course and student lists
		courses = new ArrayList<Course>();
		loadCourseList();

		students = new ArrayList<Student>();
		loadStudents();

		admin = new Admin("Admin", "Admin001", students, courses);
		input = new Scanner(System.in);
	}

	private void loadStudents() {
		/**
		 * load students from a file
		 */
		// File studFile = ("/Users/LuisaHernandez/Documents/studs.ser");
		File studFile = new File("/Users/Zorro/arena/studs.ser");

		try {
			FileInputStream fileIn = new FileInputStream(studFile);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			students = (ArrayList<Student>) in.readObject();
			in.close();
			fileIn.close();
		} catch (Exception e) {
			// first time running
		}

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
			courses = (ArrayList<Course>) in.readObject();
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

		// ArrayList<Course> courseList = null;
		try {
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
				courses.add(myCourse);

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

	private void adminMainMenu() {
		admin.mainMenu();
	}

	private void studentMainMenu() {
		/**
		 * call main menu of student
		 */

		// get student from admin
		Student stu = admin.getStudent();

		if (stu != null) {
			// sign in

			System.out.println("Username (first+last name, no spaces): ");
			String username = input.nextLine();
			System.out.println("Password: ");
			String password = input.nextLine();

			if (stu.login(username, password)) {
				stu.mainMenu();
			} else {
				System.out.println("invalid login");
			}
		} else {
			System.out.println("invalid student");
		}
	}

	public void save() {
		admin.save();
	}

	public static void main(String[] args) {
		// do all our stuff here
		University ub = new University();

		System.out.println("Choices:");
		System.out.println("admin: manage courses and view reports");
		System.out.println("student: view student info and register for courses");
		System.out.println("q: quit");

		char choice = 'a';
		while (choice != 'q') {
			choice = input.next().charAt(0);
			if (choice == 'a') {
				// go to admin block
				// TODO --unshunt
				try {
					ub.adminMainMenu();
				} catch (Exception e) {
					System.out.println("Not implemented!");
				}

			} else if (choice == 's') {
				// go to student block
				ub.studentMainMenu();
			} else if (choice != 'q') {
				System.out.println("invalid choice");
			}
			ub.save();
		}

	}

}
