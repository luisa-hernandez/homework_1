package Homework_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class UniversityB {
	public static void main(String[] args) {
		// path to find excel document
		// File myFile = new File
		// ("/Users/LuisaHernandez/Documents/MyUniversityCourses.csv");
		File myFile = new File("/Users/Zorro/Documents/MyUniversityCourses.csv");

		// creating scanner
		Scanner input;
		ArrayList<Course> courseList = null;
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

		Scanner type = new Scanner(System.in);
		// ask user their type
		System.out.println("Are you a student or an admin? ");
		String answer = type.nextLine();
		if (answer == "admin") {
			System.out.println("Username: ");
			String username = type.nextLine();
			System.out.println("Password: ");
			String password = type.nextLine();
			if (username == "Admin" && password == "Admin001") {
				char choice = 'a';
				// create Admin object
//				Admin admin = new Admin();
				while (choice != 'q') {
					System.out.println("Add course:\ta");
					System.out.println("Delete course:\td");
					System.out.println("Edit course:\te");
					System.out.println("Display course:\tc");
					System.out.println("Register student:\tr");
					System.out.println("Reports: \tt");
					Scanner sc = new Scanner(System.in);
					choice = sc.next().charAt(0);
					switch (choice) {
//					case 'a':
//						admin.addCourse(courseList);
//						break;
//					case 'c':
//						admin.displayCourse(courseList);
//						break;
//					case 'd':
//						admin.deleteCourse(courseList);
//						break;
//					case 'e':
//						admin.editCourse(courseList);
//						break;
//					case 'q':
//						break;
//					case 'r':
//						admin.registerStudent(courseList);
//						break;
//					case 't':
//						admin.reports(courseList);
//						break;
					}
				}
			}
		}
		// these are the student options
		if (answer == "student") {
			// require student to type in a username and password
			System.out.println("Username: ");
			String username = type.nextLine();
			System.out.println("Password: ");
			String password = type.nextLine();
			// if the username and password are correct, follow through with
			// these options
			if (username == "Admin" && password == "Admin001") {
				char choice = 'a';
				// create Student object
//				Student student = new Student();
				while (choice != 'q') {
					System.out.println("View all courses available:\tv ");
					System.out.println("View all courses that are not full:\tf ");
					System.out.println("Register in a course:\tr");
					System.out.println("Withdraw from a course:\tw");
					System.out.println("View all courses you are enrolled in:\te");
					// create a new scanner
					Scanner sc = new Scanner(System.in);
					choice = sc.next().charAt(0);
					switch (choice) {
//					case 'e':
//						student.enrolledCourse(courseList);
//						break;
//					case 'f':
//						student.nonfullCourse(courseList);
//						break;
//					case 'r':
//						student.registerCourse(courseList);
//						break;
//					case 'v':
//						student.viewCourse(courseList);
//						break;
//					case 'w':
//						student.withdrawCourse(courseList);
//						break;
					}
				}
			}
		}

	}

}
