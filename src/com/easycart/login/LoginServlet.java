package com.easycart.login;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.easycart.reg.RegisterUser;

public class LoginServlet extends HttpServlet {

protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
	
	
	String user=req.getParameter("uname");
	String pw=req.getParameter("pass");
	//String submitType=req.getParameter("submit");
	
	PrintWriter out=resp.getWriter();

    if( Validate.checkUser(user,pw))
    {
    	RequestDispatcher rs=req.getRequestDispatcher("Welcome");
    	rs.forward(req, resp);
    }
    
    else
    {
    	out.println("Username or password is incorrect plz register");
    	RequestDispatcher rs=req.getRequestDispatcher("login.html");
    	rs.include(req, resp);	
    	
    }
  
	
	
}
}
