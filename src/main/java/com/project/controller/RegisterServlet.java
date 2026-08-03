package com.project.controller;

import com.project.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

import com.project.dao.UserDAO;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		
		String full_name = req.getParameter("full_name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String phone = req.getParameter("phone");
		String role = req.getParameter("role");
		
		User us = new User();
		
		us.setFull_name(full_name);
		us.setEmail(email);
		us.setPassword(password);
		us.setPhone(phone);
		us.setRole(role);
		
		UserDAO dao = new UserDAO();
		
		boolean status ;
		
		try {
			if(!dao.isEmailExits(email)) {
				
				status = dao.reqisterUser(us);
				
				if(status) {
					resp.sendRedirect("login.jsp");
				}
				else {
					req.setAttribute("msg", "Something went wrong :( ");
					resp.sendRedirect("register.jsp");
				}
				
			}
			else {
				
				req.setAttribute("msg", "Email already exits.");
				req.getRequestDispatcher("register.jsp").forward(req, resp);
			}
			
	
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
