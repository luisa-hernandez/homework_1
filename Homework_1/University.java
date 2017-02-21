package Homework_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class University {

	/*
	 * Instance Variables
	 */
	ArrayList<Course> courseList;

	public University() {

	}

	private void createCourseList() {
		// TODO Auto-generated method stub
		// ("/Users/LuisaHernandez/Documents/MyUniversityCourses.csv");
		File myFile = new File("/Users/Zorro/Documents/MyUniversityCourses.csv");

		// creating scanner
		Scanner input;
		try {
			input = new Scanner(myFile);
			// creating new array
			ArrayList<Course> courseList = new ArrayList<Course>();
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
		if (username == "Admin" && password == "Admin001") {
			char choice = 'a';
			// create Admin object
			Admin admin = new Admin();
			while (choice != 'q') {
				System.out.println("Add course:\ta");
				System.out.println("Delete course:\td");
				System.out.println("Edit course:\te");
				System.out.println("Display course:\tc");
				System.out.println("Register student:\tr");
				System.out.println("Reports: \tt");
				Scanner sc = new Scanner(System.in);
				choice = sc.next().charAt(0);
				//choices will go here
			}
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
		// these options
		if (username == "Admin" && password == "Admin001") {
			char choice = 'a';
			// create Student object
			Student student = new Student();
			while (choice != 'q') {
				System.out.println("View all courses available:\tv ");
				System.out.println("View all courses that are not full:\tf ");
				System.out.println("Register in a course:\tr");
				System.out.println("Withdraw from a course:\tw");
				System.out.println("View all courses you are enrolled in:\te");
				// create a new scanner
				Scanner sc = new Scanner(System.in);
				choice = sc.next().charAt(0);
				//choices will go here
			}
		}
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

	}

}
