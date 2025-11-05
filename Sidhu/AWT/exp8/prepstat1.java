import java.sql.*;
import java.io.*;
import java.util.*;

public class prepstat1
{
	public static void main(String args[]) throws ClassNotFoundException
	{
		try
		{
		String url="jdbc:mysql://localhost:3306/mysql";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "root", "");
		String query="select * from cse32";
		PreparedStatement pst=con.prepareStatement(query);
		ResultSet res=pst.executeQuery(query);
			while(res.next())
			{
				System.out.println(res.getInt(1));
				System.out.println(res.getString(2));
			}
		System.out.println("fetched");
		}
		catch (SQLException e) {
			System.out.println(e);
		}
	}
}
