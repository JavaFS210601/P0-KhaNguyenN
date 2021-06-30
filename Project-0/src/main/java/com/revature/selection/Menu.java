package com.revature.selection;


import java.awt.print.Printable;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.revature.ratings.StudentDao;
import com.revature.ratings.TeacherDao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Menu {
	
	
	TeacherDao teacherDao = new TeacherDao();
	StudentDao studentDao = new StudentDao();
	public void display() {
		
		final Logger log = LogManager.getLogger(Menu.class);
		
		
		
		boolean displayMenu = true;
		
		
		Scanner input = new Scanner(System.in);
		
		
		//P0 is called TEACHER RATER//
		System.out.println("==================================================="
				+ "\n          Welcome to Teacher Rater\n"
				+ "===================================================");
		
		
		while (displayMenu) {
			

			System.out.println("---------------------------------------------------");
			System.out.println("            ||Choose an Option||                   ");
			System.out.println("---------------------------------------------------");
			
			
			
			//Options to choose
			System.out.println("||Teachers -> To show all teachers               ||");
			System.out.println("||Students -> To show all Students and Review    ||");
			System.out.println("||Add review -> Add a review for a teacher       ||");
			System.out.println("||Remove review -> Remove a review for a teacher ||");
			System.out.println("||Change review -> Change a previous review      ||");
			System.out.println("||Exit -> exit the applications                  ||");
			System.out.println("\n\n");
			
			String userInput = input.nextLine().toLowerCase();
			
			switch (userInput) {
			case "teachers":{
				//This will be our logging
				log.info("User select all teachers");
				System.out.println("Gathering all teachers...\n");
				
				List<Teacher> teacherRatings = teacherDao.getTeachersRatings();
				 
				for (Teacher teachers : teacherRatings) {
					System.out.println(teachers);
				}
				System.out.println("Did you want it sorted?");
				System.out.println("Options: Highest Rated or Lowest Rated or Other");
				String sortedString = input.nextLine().toLowerCase();
				
				if (sortedString.equals("highest rated")) {
					log.info("User accessed highest rated");
					System.out.println("\n***************************************************\n");
					System.out.println("\n***************************************************\n");
					List<Teacher> teacherHiger = teacherDao.getTeacherHigher();
					for (Teacher teachers : teacherHiger) {
						System.out.println(teachers);
					}
					
				}
				else if (sortedString.equals("lowest rated")) {
					log.info("User accessed lowest rated");
					System.out.println("\n***************************************************\n");
					System.out.println("\n***************************************************\n");
					List<Teacher> teacherLower = teacherDao.getTeacherLower();
					for (Teacher teachers : teacherLower) {
						System.out.println(teachers);
					}
					
				}
					
				else {
					System.out.println("Other chosed");
					log.info("User used other options");
					break;
				}
				
				break;
			}
			case "students":{
				log.info("User selected all students");
				System.out.println("Gathering all students...\n");
				
				List<Student> studentList = studentDao.getStudentRatings();
				
				for (Student students : studentList) {
					System.out.println(students);
				}
				break;
			}
				case "exit": {
				log.info("User exit the program");
				System.out.println("Exiting program...");
				displayMenu = false;
				break;
			}
				case "add review": {
					log.info("User added a review");
					Scanner forAddScanner = new Scanner(System.in);
					System.out.println("List of teachers");
					List<Teacher> teacherRatings = teacherDao.getTeachersRatings();
					for (Teacher teachers : teacherRatings) {
						System.out.println(teachers);
					}
					boolean studentReview = true;
					System.out.println("Enter your six  digit student ID number");
					int student_id = forAddScanner.nextInt();
					int lenght_student_id = String.valueOf(student_id).length();
					
					if (lenght_student_id == 6) {
						System.out.println("Which teacher do you want to review? "
								+ "Use their ID for review");
						 int teacher_id_fk = forAddScanner.nextInt();
						 forAddScanner.nextLine();
						 
					     
					      System.out.println("Enter your first name" );
					      String student_firstname = forAddScanner.nextLine();
					   
					      
					     
					      System.out.println("Enter your last name");
					      String student_lastname = forAddScanner.nextLine();
					    
					      
					      System.out.println("Enter any comments you might have");
					      String student_comment = forAddScanner.nextLine();
					      
					      
					      System.out.println("Enter teacher rating from 1-5, 1 being lowest and 5 being the highest");
					      int student_rating = forAddScanner.nextInt();
					      
						Student newStudent = new Student(student_id, student_firstname, student_lastname, teacher_id_fk, student_comment, student_rating);
						
						studentDao.addReview(newStudent);
						break;
						
					}
					else {
						System.out.println("Make sure your ID is your six digit ID");
					    log.warn("Have to be a six digit ID");
						break;
					}
					
				}
				case"remove review":{
					log.info("User removed a review");
					System.out.println("Which one is your review?");
					List<Student> studentList = studentDao.getStudentRatings();
					
					for (Student students : studentList) {
						System.out.println(students);
					}
					try {
						System.out.println("Enter your student ID");
						int student_idnumber = input.nextInt();
						input.nextLine();
						System.out.println("Enter your first name");
						String firstname = input.nextLine();
						System.out.println("Enter your last name");
						String lastname = input.nextLine();
						studentDao.removeReview(student_idnumber, firstname,lastname);
					} catch (Exception e) {
					System.out.println(e);
					log.error("Something went wrong with remove review");
					}
					break;
				}
				case"change review":{
					log.info("User changed a review");
					System.out.println("Which one of the reviews you would like to change?");
					List<Student> studentList = studentDao.getStudentRatings();
					for (Student students : studentList) {
						System.out.println(students);
					}
					try {
					System.out.println("Enter your student ID");
					int student_idnumber = input.nextInt();
					input.nextLine();
					
					System.out.println("Enter your first name");
					String firstname = input.nextLine();
					
					System.out.println("Enter your last name");
					String lastname = input.nextLine();
						
					System.out.println("Enter your new rating");
					int student_ratingnumber = input.nextInt();
					input.nextLine();
					
					System.out.println("Enter your new comments");
					String comment =  input.nextLine();
					
					
					
					studentDao.changeReview(firstname, lastname, comment, student_ratingnumber, student_idnumber);
				} catch (Exception e) {
					System.out.println(e);
					log.error("something went wrong with change review");
				}
				}
			default:
				break;
			}
		}
	}

}
