// Java program to insert records to a table using JDBC

import java.io.*;
import java.sql.*;

public class jdbc2
{

	// url that points to mysql database, 'db' is database
	// name
	static final String url
		= "jdbc:mysql://localhost:3306/mysql";

	public static void main(String[] args)
		throws ClassNotFoundException
	{
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");

			
			Connection conn = DriverManager.getConnection(
				url, "root","");

			
			Statement stmt = conn.createStatement();

			
			int result = stmt.executeUpdate(
				"insert into cse32 values(20,'hare krishna')");
				

			
			if (result > 0)
				System.out.println("successfully inserted");

			else
				System.out.println(
					"unsuccessful insertion ");

			// closing connection
			conn.close();
		}

		catch (Exception e) {
			System.out.println(e);
		}
	}
}
