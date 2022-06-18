package com.easycart.reg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterUser extends HttpServlet{

protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
	String uname=req.getParameter("uname");
	String Lname=req.getParameter("lname");
	String email=req.getParameter("uemail");
	int phoneno;
	 phoneno=Integer.parseInt(req.getParameter("phno"));
	String pass=req.getParameter("pass");
	String hno=req.getParameter("hno");
	String address=req.getParameter("add");
	String country=req.getParameter("country");
	PrintWriter out=resp.getWriter();
	
	try{
Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// Creating connection
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
		PreparedStatement ps=con.prepareStatement("insert into registeruser values(?,?,?,?,?,?,?,?)");
		
		ps.setString(1, uname);
		ps.setString(2, Lname);
		ps.setString(3, email);
		ps.setInt(4, phoneno);
		ps.setString(5, pass);
		ps.setString(6, hno);
		ps.setString(7, address);
		ps.setString(8, country);
	
		
		ps.executeUpdate();
		PreparedStatement ps1=con.prepareStatement("insert into customerlogin values(?,?)");
		ps1.setString(1, uname);
		ps1.setString(2, pass);
		ps1.executeUpdate();
		con.close();
	out.println("Registration successful");
//	RequestDispatcher rs=req.getRequestDispatcher("RegisterDao");
//	rs.forward(req, resp);
		
		
	}
	catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}

}
