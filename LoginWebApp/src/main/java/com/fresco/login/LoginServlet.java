package com.fresco.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// your code here
		
		String email = request.getParameter("email").toString();
		String password = request.getParameter("password").toString();
	
		System.out.println("email : "+email+" , password : "+password);
		
		Validate validate = new Validate();
		boolean verifyUser = validate.checkUser(email, password);
		
		System.out.println("validaiton --> "+verifyUser);
		if(verifyUser){
			request.setAttribute("validation", verifyUser);			
		}else{
			response.getWriter().write("Username or Password incorrect");
		}
	}

}
