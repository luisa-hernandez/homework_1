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
	private static Scanner in;

	public University() {
		// create course and student listes
		courses = new ArrayList<Course>();
		loadCourseList();

		students = new ArrayList<Student>();
		loadStudents();

		admin = new Admin("Admin", "Admin001", students, courses);
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
			courses = new ArrayList<Course>();
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
	}

	private void adminBlock() {
		/**
		 * administer the courses and students
		 */

		// sign in
		Scanner type = new Scanner(System.in);
		System.out.println("Username: ");
		String username = type.nextLine();
		System.out.println("Password: ");
		String password = type.nextLine();

		if (admin.login(username, password)) {
			try {
				char choice = 'a';
				while (choice != 'q') {
					System.out.println("Manage Courses:\tm");
					System.out.println("Reports:\t\tr");
					System.out.println("Quit:\t\tq");

					Scanner sc = new Scanner(System.in);
					choice = sc.next().charAt(0);
					switch (choice) {
					case 'm':
						admin.manageCourses();
						break;
					case 'r':
						admin.reports();
						break;
					case 'q':
						return;
					default:
						System.out.println("invalid choice");
						break;
					}

				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
			out.writeObject(courses);
			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}

		// serialize student list
		// File studFile = ("/Users/LuisaHernandez/Documents/studs.ser");
		File studFile = new File("/Users/Zorro/arena/studs.ser");

		// serialize student list
		try {
			FileOutputStream fileOut = new FileOutputStream(studFile);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(students);
			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}

	}

	public static void main(String[] args) {
		// do all our stuff here
		University ub = new University();

		in = new Scanner(System.in);
		System.out.println("Speak ye, student or admin?");
		String status = in.nextLine();

		if (status.compareTo("admin") == 0) {
			// go to admin block
			// TODO --unshunt
			try {
				ub.adminBlock();
			} catch (Exception e) {
				System.out.println("Not implemented!");
			}

		} else if (status.compareTo("student") == 0) {
			// go to student block
			ub.studentBlock();
		} else {
			System.out.println("You must enter admin or student.");
		}
		ub.save();

	}

}
