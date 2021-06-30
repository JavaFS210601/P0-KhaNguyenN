package com.revature.ratings;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.revature.connections.ConnectionUtil;

import com.revature.selection.Student;
import com.revature.selection.Teacher;

import jdk.internal.org.jline.utils.Log;

public class StudentDao implements StudentDaoInterface {

	
	@Override
	public List<Student> getStudentRatings() {
		
		
		try(Connection connection = ConnectionUtil.getConnection()) {
			
			ResultSet resultSet = null; // intialize an empty resultset that will store the results of our query.
			
			String sql = "select * from student_things;";
			
			java.sql.Statement statement = connection.createStatement();
			
			resultSet = statement.executeQuery(sql);
			
			
			List<Student> studentList = new ArrayList<>();
			
			
			while(resultSet.next()) {
				Student students = new Student(
						resultSet.getInt("student_id"),
						resultSet.getString("student_firstname"),
						resultSet.getString("student_lastname"),
						resultSet.getInt("student_rating"),
						resultSet.getString("student_comments"),
						resultSet.getInt("teacher_id_fk")
						);
				
				//add the newly created employee object into the arraylist of employees
				studentList.add(students);
			}
			
			return studentList; //finally, if sucessful return employee list
			
		} catch (SQLException e) {
			System.out.println("Something went wrwong when trying to access your DB");
			e.printStackTrace();
			Log.error("Didn't access databse");
		}
		
		return null; // java will yell if we dont have this 
	}
	

	@Override
	public void addReview(Student student) { //This is INSERT functionality (with complicated date functionality if you dare...)
		
		try(Connection connection = ConnectionUtil.getConnection()) {
			
			//we're going to create a SQL statement using parameters to insert a new Employee
			String sql = "INSERT INTO student_things (student_id, student_firstname, student_lastname, teacher_id_fk, student_comments, student_rating) " //creating a line break for readability
					+ "VALUES (?, ?, ?, ?, ?, ?);"; //these are parameters!!! We have to now specify the value of each "?"
			
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql); //we use PreparedStatements for SQL commands with parameters
			
			//use the PreparedStatement object's methods to insert values into the SQL query's ?s
			//the values will come from the Employee object we sent in
			//this requires two arguments, the number of the "?", and the value to give it
			preparedStatement.setInt(1, student.getStudent_id());
			preparedStatement.setString(2, student.getStudent_firstname());
			preparedStatement.setString(3, student.getStudent_lastname());
			preparedStatement.setInt(4, student.getTeacher_id_fk());
			preparedStatement.setString(5, student.getStudent_comments());
			preparedStatement.setInt(6, student.getStudent_rating());
			
			//this method actually sends and executes the SQL command that we built
			preparedStatement.executeUpdate(); //we use executeUpdate for inserts, updates, and deletes. 
			
			//send confirmation to the console if successful
			System.out.println("Thanks for the review " + student.getStudent_firstname() + " " + student.getStudent_lastname());
			
		} catch(SQLException e) {
			System.out.println("Adding review failed");
			e.printStackTrace();
			Log.error("Didn't access adding review");
		}
		
	}
	
	
	@Override

	public void removeReview(int student_idnumber, String firstname, String lastname) {
		
		try(Connection connection = ConnectionUtil.getConnection()){
		
			//Make a new object and while loop up at the top to print out the whole row thing
//			String sql1 = "select * from student_things where student_id =?; + values (?,student_firstname,student_lastname,?);";
//			PreparedStatement preparedStudent  = connection.prepareStatement(sql1);
//			
//			
//			java.sql.Statement statement = connection.createStatement();
//			

			String sql = "DELETE FROM student_things WHERE student_id= ?;";
			
		
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			
			preparedStatement.setInt(1, student_idnumber);
//		    preparedStatement.setString(2, firstname);
//		    preparedStatement.setString(3, lastname);
			if(preparedStatement.executeUpdate() != 0) {
				System.out.println("\n");
				
			}
			
			System.out.println("Review deleted " + student_idnumber 
					+" "+ firstname +" "+ lastname);
			
		} catch (SQLException e) {
			System.out.println("Remove review failed!");
			e.printStackTrace();
			Log.error("Didn't access remove");
		}

}


	public void changeReview( String firstname, String lastname, String comment,int student_ratingnumber, int student_idnumber) {
		try(Connection connection = ConnectionUtil.getConnection()){
		String sqlString = "UPDATE student_things SET student_comments = ? , student_rating = ? where student_id = ?;";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
//		preparedStatement.setString(1, firstname);
//	    preparedStatement.setString(2, lastname);
//	    preparedStatement.setString(3, comment);
//	    preparedStatement.setInt(5, student_ratingnumber);
//	    preparedStatement.setInt(6, student_idnumber);
//	    
//	    preparedStatement.setString(5, lastname);
//		preparedStatement.setString(4, firstname);
		
		preparedStatement.setInt(3, student_idnumber);
		preparedStatement.setInt(2, student_ratingnumber);
		preparedStatement.setString(1, comment);
	    preparedStatement.executeUpdate();
	    System.out.println("********************");
	    System.out.println("Review was updated " + firstname +" " + lastname + " with student ID =" + student_idnumber);
	    System.out.println("********************");
	}
		catch (SQLException e) {
			System.out.println("Change review failed");
			Log.error("Didn't access change review");
		}


}



}

