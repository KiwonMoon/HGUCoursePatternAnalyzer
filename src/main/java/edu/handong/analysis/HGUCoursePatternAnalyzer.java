package edu.handong.analysis;

import edu.handong.analysis.datamodel.Course;
import edu.handong.analysis.datamodel.Student;

public class HGUCoursePatternAnalyzer {
	
	private String[] lines = {	"1999-1, JC Nam, Java Programming",
						"1999-2, JC Nam, Programming Language Theory",
						"1999-1, JC Nam, Data Structures",
						"2001-1, JC Nam, Database Systems",
						"2018-1, SB Lim, Java Programming",
						"2018-2, SB Lim, Programming Language Theory",
						"2019-1, SB Lim, Data Structures",
						"2019-1, SB Lim, Algorithm Analysis",
						"2018-1, SJ Kim, Java Programming",
						"2018-2, SJ Kim, Programming Language Theory",
						"2019-1, SJ Kim, Logic Design",
						"2019-1, SJ Kim, Algorithm Analysis",
						};

	private int numOfStudents;
	private int numOfCourses;
	private Student[] students;
	private Course[] courses;
	
	/**
	 * This method runs our analysis logic to get the list of student and course names from lines.
	 * @param args
	 */
	public void run(String[] args) {
		
		numOfStudents = Integer.parseInt(args[0]);
		numOfCourses = Integer.parseInt(args[1]);
	
		students = initiateStudentArrayFromLines(lines);
		System.out.println("Number of All Students: " + numOfStudents);
		for(Student student: students) {
			System.out.println(student.getName());
		}
		
		courses = initiateCourseArrayFromLines(lines);
		System.out.println("Number of All Courses: " + numOfCourses);
		for(Course course: courses) {
			System.out.println(course.getCourseName());
		}
		
	}

	/**
	 * This method returns a Student array to initiate the field, students, from lines.
	 * @param lines
	 * @return
	 */
	private Student[] initiateStudentArrayFromLines(String[] lines) {
		
		String[] studentList = new String[lines.length];
		students = new Student[lines.length];
		//students = new Student[3];
		Student student;
		int len = 0;
	
		//To separate student names from array lines and put the names to studentList array
		for(int i=0; i<lines.length; i++) { 
			studentList[i] = lines[i].split(",")[1].trim();
		}
		
		for(int i=0; i<lines.length; i++) {
			student = new Student(studentList[i]);
			if(studentExist(students, student) == false) { //studentExist가 false이면 students에 Student인스턴스추
				students[len] = new Student(student.getName());
				len ++;
			}
		}
		
		return students;
	}

	/**
	 * This method check if there is the same name of the second argument in the array, students
	 * @param students
	 * @param student
	 * @return boolean
	 */
	private boolean studentExist(Student[] students, Student student) {
		
		/*boolean result = false;
		for(Student name: students) {
			if(name == student || (student != null && student.equals(name))) {
				result = true;
				break;
			}
		}
		return result;*/
		
		for(int i=0; i<students.length; i++) {
			if(students[i] != null) {
				if(students[i].getName() == student.getName()) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * This method returns a Course array to initiate the field, courses, from lines.
	 * @param lines
	 * @return
	 */
	private Course[] initiateCourseArrayFromLines(String[] lines) {
		
		String[] courseList;
		courseList = new String[12];
		courses = new Course[lines.length];
		Course course;
		int len = 0;
		
		//To separate course names from array lines and put the names to coursesList array
		for(int i=0; i<lines.length; i++) { 
			courseList[i] = lines[i].split(",")[2].trim();
		}
		
		for(int i=0; i<lines.length; i++) {
			course = new Course(courseList[i]);
			if(courseExist(courses, course) == false) { 
				courses[len] = new Course(course.getCourseName());
				len ++;
			}
		}
		
		return courses;
	}

	/**
	 * This method check if there is the same name of the second argument in the array, courses.
	 * @param courses
	 * @param course
	 * @return boolean
	 */
	private boolean courseExist(Course[] courses, Course course) {
		
		for(int i=0; i<courses.length; i++) {
			if(courses[i] != null) {
				if(courses[i].getCourseName() == course.getCourseName()) {
					return true;
				}
			}
		}
		return false;
	}
}
