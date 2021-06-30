package com.revature.ratings;

import java.lang.System.Logger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.connections.ConnectionUtil;
import com.revature.selection.Teacher;

import jdk.internal.org.jline.utils.Log;

public class TeacherDao implements TeacherDaoInterface{

	
	
	@Override
	public List<Teacher> getTeachersRatings() {
		
		
		try(Connection connection = ConnectionUtil.getConnection()) {
			
			ResultSet resultSet = null; // intialize an empty resultset that will store the results of our query.
			
			String sql = "select * from teacher_things;";
			
			java.sql.Statement statement = connection.createStatement();
			
			resultSet = statement.executeQuery(sql);
			
			
			List<Teacher> teachersList = new ArrayList<>();
			
			
			while(resultSet.next()) {
				Teacher teachers = new Teacher(
						resultSet.getInt("teacher_id"),
						resultSet.getString("teacher_firstname"),
						resultSet.getString("teacher_lastname"),
						resultSet.getString("teacher_subject"),
						resultSet.getInt("teacher_rating")
						);
				
				//add the newly created employee object into the arraylist of employees
				teachersList.add(teachers);
			}
			
			return teachersList; //finally, if sucessful return employee list
			
		} catch (SQLException e) {
			System.out.println("Something went wrwong when trying to access your DB");
			e.printStackTrace();
			Log.error("Didn't access databse");
		}
		
		return null; // java will yell if we dont have this 
	}
@Override
	public List<Teacher> getTeacherHigher() {
try(Connection connection = ConnectionUtil.getConnection()) {
			
			ResultSet resultSet = null; // intialize an empty resultset that will store the results of our query.
			
			String sql = "select * from teacher_things order by teacher_rating desc;";
			
			java.sql.Statement statement = connection.createStatement();
			
			resultSet = statement.executeQuery(sql);
			
			
			List<Teacher> teachersList = new ArrayList<>();
			
			
			while(resultSet.next()) {
				Teacher teachers = new Teacher(
						resultSet.getInt("teacher_id"),
						resultSet.getString("teacher_firstname"),
						resultSet.getString("teacher_lastname"),
						resultSet.getString("teacher_subject"),
						resultSet.getInt("teacher_rating")
						);
				
				//add the newly created employee object into the arraylist of employees
				teachersList.add(teachers);
			}
			
			return teachersList; //finally, if sucessful return employee list
			
		} catch (SQLException e) {
			System.out.println("Something went wrwong when trying to access your DB");
			e.printStackTrace();
			Log.error("Didn't access databse");
		}
		
		return null; // java will yell if we dont have this 
	}
@Override
	public List<Teacher> getTeacherLower() {
try(Connection connection = ConnectionUtil.getConnection()) {
			
			ResultSet resultSet = null; // intialize an empty resultset that will store the results of our query.
			
			String sql = "select * from teacher_things order by teacher_rating asc;";
			
			java.sql.Statement statement = connection.createStatement();
			
			resultSet = statement.executeQuery(sql);
			
			
			List<Teacher> teachersList = new ArrayList<>();
			
			
			while(resultSet.next()) {
				Teacher teachers = new Teacher(
						resultSet.getInt("teacher_id"),
						resultSet.getString("teacher_firstname"),
						resultSet.getString("teacher_lastname"),
						resultSet.getString("teacher_subject"),
						resultSet.getInt("teacher_rating")
						);
				
				//add the newly created employee object into the arraylist of employees
				teachersList.add(teachers);
			}
			
			return teachersList; //finally, if sucessful return employee list
			
		} catch (SQLException e) {
			System.out.println("Something went wrwong when trying to access your DB");
			e.printStackTrace();
			Log.error("Didn't access databse");
		}
		
		return null; // java will yell if we dont have this 
	}



	}
	




