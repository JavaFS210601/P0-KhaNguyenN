package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	
	
	public static Connection getConnection() throws SQLException {
		
		
		//Use progresql to interact with our user interface 
		try {
			Class.forName("org.postgresql.Driver"); // try to find and return the postgresql driver class
		} catch (ClassNotFoundException e) {
			System.out.println("Class was not found :(");
			e.printStackTrace(); //prints the exception message to the console
		}
		
		//We need to prvide our database credentials
		//hardcode them for now, but we'll see how to hide this username/password in enviorment variables
		//You can find the template for the url by right clicking on postgres connections, edit connections, edit driver settings
//		String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=krusty_krab";
//		String username = "postgres";
//		String password = "password";
//		
		//I've successfully hidden my db credentials in my enviroment variables
		String url = System.getenv("url");
		String password = System.getenv("password");
		String username = System.getenv("username");
		return DriverManager.getConnection(url, username, password);
		
	}

}
