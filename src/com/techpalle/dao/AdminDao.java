package com.techpalle.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.techpalle.model.Admin;

public class AdminDao 
{
	private static final String dbUrl="jdbc:mysql://localhost:3306/customer_management";
	private static final String dbUsername="root";
	private static final String dbPassword="Rajesh@123";
	
	private static Connection con=null;
	private static PreparedStatement ps=null;
	private static Statement stm=null;
	private static ResultSet rs=null;
	
	private static final String validateQuery="select * from admin where username=? and password=?";
	
	public static boolean validateAdmin(String user,String pass)
	{
		boolean b = false;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
			
			ps=con.prepareStatement(validateQuery);
			ps.setString(1,user);
			ps.setString(2,pass);
			
			rs=ps.executeQuery();
			
			b=rs.next();
			
			
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		return b;
	}
}
