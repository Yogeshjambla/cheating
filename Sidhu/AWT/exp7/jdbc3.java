// Java program to insert records to a table using JDBC

import java.io.*;
import java.sql.*;

public class jdbc3
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

			
			ResultSet res=stmt.executeQuery(" select * from cse32");
			while(res.next())
			{
				System.out.println(res.getInt(1));
				System.out.println(res.getString(2));
			}

			// closing connection
			conn.close();
		}

		catch (Exception e) {
			System.out.println(e);
		}
	}
}
