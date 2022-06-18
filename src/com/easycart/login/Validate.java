package com.easycart.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Validate {
public static boolean checkUser(String uname,String pass)
{
	boolean st=false;
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// Creating connection
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
		PreparedStatement ps=con.prepareStatement("select * from customerlogin where username=? and password=?");
		ps.setString(1, uname);
		ps.setString(2, pass);
		ResultSet rs=ps.executeQuery();
		st=rs.next();
		
		
	}
	catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return st;
}

}
