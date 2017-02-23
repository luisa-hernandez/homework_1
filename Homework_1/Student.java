package Homework_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Student extends User implements Serializable {

	private String firstName;
	private String lastName;
	private ArrayList<Course> allCourses;
	private ArrayList<Course> myCourses;

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

	public void mainMenu() throws Exception {
		/**
		 * administer a student
		 */

		// choices
		char choice = 'a';
		while (choice != 'q') {
			while (choice != 'q') {
				System.out.println("View all courses available:\tv ");
				System.out.println("View all courses that are not full:\tf ");
				System.out.println("Register in a course:\tr");
				System.out.println("Withdraw from a course:\tw");
				System.out.println("View all courses you are enrolled in:\te");
				System.out.println("Quite:\tq");

				// get choice
				Scanner sc = new Scanner(System.in);
				choice = sc.next().charAt(0);

				switch (choice) {
				case 'v':
					throw new Exception("Not Implemented");
					// break
				case 'f':
					throw new Exception("Not Implemented");
					// break
				case 'r':
					throw new Exception("Not Implemented");
					// break
				case 'w':
					withdraw();
					break;
				case 'e':
					throw new Exception("Not Implemented");
					// break
				default:
					System.out.println("Invalid Choice");
					break;
				}
			}
			// TODO -- save!
		}
	}

	public Student(String password, String firstName, String lastName, ArrayList<Course> courses) {
		super(new String(firstName + lastName), password, courses);
		this.firstName = firstName;
		this.lastName = lastName;
		myCourses = new ArrayList<Course>();
	}

	public boolean add(Course e) {
		return myCourses.add(e);
	}

	public Course remove(int index) {
		return myCourses.remove(index);
	}

	public void printCourses() {
		for (Course course : allCourses) {
			System.out.println(course.Course_Name + " " + course.Course_Section_Number);
		}

	}

	public void setCourses(ArrayList<Course> courses) {
		this.allCourses = courses;
	}

	public void addCourse(Course course) {
		allCourses.add(course);
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
		for (int x = 0; x < allCourses.size(); x++) {
			// find index of matching course, if it exists
			Course course = allCourses.get(x);
			if (section == course.getSection() && id.compareTo(course.getId()) == 0) {
				index = x;
			}
		}

		return index;
	}

	public void viewCourses(){
		for(Course course: myCourses){
			System.out.println("Name:\t" + course.Course_Name);
			System.out.println("ID:\t" + course.Course_Id);
			System.out.println("Section:\t" + course.Course_Section_Number);
			System.out.println("");
		}
	}
	
//	private void withdraw() {
//		
//		removeCourse(null);
//	}

	public void removeCourse(Course course) {
		/**
		 * remove a course
		 */
		for (int i = 0; i < myCourses.size(); i++) {
			if (course.equals(myCourses.get(i))) {
				myCourses.remove(i);
				break;
			}
		}
	}

}