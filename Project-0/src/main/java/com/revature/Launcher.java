package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.connections.ConnectionUtil;
import com.revature.selection.Menu;

public class Launcher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try(Connection connection = ConnectionUtil.getConnection()) {
			System.out.println("Connection successful...");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		
		System.out.println("\n");
		//instantiate a menu object so we can use the display()
		Menu menu = new Menu();
		//run the display method, delivering the user's prompt
		menu.display();
	}

}
