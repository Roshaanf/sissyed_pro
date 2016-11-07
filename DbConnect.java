package Server;


import java.sql.*;

import javax.swing.JOptionPane;

public class DbConnect {
    
	Connection con=null;
	public static Connection connectDb() 
	{
		try
		{
			String connectionUrl = "jdbc:mysql://localhost:3306/Library";
			Connection con=DriverManager.getConnection(connectionUrl,"hamza","");

			return con;
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,e);
			System.out.print(e);
			return null;
		}
		
	
	}
	
	
}
