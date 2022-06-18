package com.easycart.reg;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterDao extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname=req.getParameter("uname");
		String pass=req.getParameter("pass");
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
					
					// Creating connection
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
					PreparedStatement ps=con.prepareStatement("insert into customerlogin values(?,?)");
					ps.setString(1, uname);
					ps.setString(2, pass);
					
					ps.executeUpdate();
					
					
					con.close();
					
				}
				catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
	}

}
