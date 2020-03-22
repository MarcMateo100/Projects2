package com.springboot.YoutubeWeb;

import java.io.IOException;
import java.sql.*;

public class JDBCExample {
	
	public static void main(String[] args)  {
	
		System.out.println("——– PostgreSQL " + "JDBC Connection Testing ————");
		try {
		Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
		System.out.println("Where is your PostgreSQL JDBC Driver? " + "Include in your library path!");
		e.printStackTrace();
		return;
		}
		System.out.println("PostgreSQL JDBC Driver Registered!");
		Connection connection = null;
		try {			
				String[] parts=null;	
				GetPropertyValues properties = new GetPropertyValues();
				try{
				String url = properties.getPropValues();
				url = url.replaceAll(" ","");
				parts = url.split(",");
			}catch(IOException io) {
				System.out.println("Get Properties Failed!");
			}
		connection = DriverManager.getConnection(parts[0], parts[1],parts[2]);
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}
		//Statement sql = connection.createStatement();
		if (connection != null) {
			//sqlStatement("INSERT INTO TESTTABLE (product_id,product_name,) VALUES(1,  ‘product1’)");
			System.out.println("Successfully added");
		} else {
		}
	}
}

