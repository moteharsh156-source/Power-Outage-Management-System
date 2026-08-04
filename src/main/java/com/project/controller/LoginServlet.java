package com.project.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.project.dao.UserDAO;
import com.project.model.User;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		UserDAO dao = new UserDAO();
		
		User us = null;
		
		try {
			us = dao.Login(email, password);
			
			
			if(us != null) {
				HttpSession session = req.getSession();
				session.setAttribute("us", us);
				
				if(us.getRole().equals("Citizen")){
				    resp.sendRedirect("citizendashboard.jsp");
				}
				else if(us.getRole().equals("Technician")){
					resp.sendRedirect("techdashboard.jsp");
				}
				
			}
			else {
				req.setAttribute("msg", "Something went wrong :( ");
				resp.sendRedirect("login.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
