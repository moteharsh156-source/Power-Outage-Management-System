package com.project.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.project.dao.UserDAO;
import com.project.model.Complaints;
import com.project.model.User;

@WebServlet("/UpdateProfileServlet")
public class UpdateProfileServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//With the help of this are allow to use 
		resp.setContentType("text/html");
		
		//Get current user
		
		HttpSession se = req.getSession();
		
		User us = (User) se.getAttribute("us");
		
		
		String full_name = req.getParameter("full_name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String phone = req.getParameter("phone");
		String newpassword = req.getParameter("newpassword");
		//
		//User us = new User();
		
		us.setFull_name(full_name);
		us.setEmail(email);
		us.setPassword(password);
		us.setPhone(phone);
		
		UserDAO dao = new UserDAO();
		
		boolean status;
		
		if(!password.equals(newpassword)) {
			
		req.setAttribute("msg", "Password don't match");
		
		return;
		}
			
			try {
				status = dao.updateprofile(us);
				
				if(status) {
					resp.sendRedirect("citizendashboard.jsp");
				}
				else {
					 req.setAttribute("msg", "Something went wrong :(");
					// req.getRequestDispatcher("");
					 req.getRequestDispatcher("updateprofile.jsp")
	                   .forward(req, resp);
				}
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
	}
}
