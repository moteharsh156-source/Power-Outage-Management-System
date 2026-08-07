package com.project.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.DataOutput;
import java.io.IOException;
import java.util.List;

import com.project.dao.ComplaintDAO;
import com.project.model.Complaints;
import com.project.model.User;

@WebServlet("/ComplaintServlet")
public class ComplaintServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//here we are taking logged data of user that means we are keeping in mind there is same user
		HttpSession session = req.getSession();
		
		User us = (User) session.getAttribute("us");
		
		if (us == null) {
			//if there is no data of user in us then it redirects to login page
			resp.sendRedirect("login.jsp");
			//stop thr execution of code 
			return;
		}
		//here we got users user_id and saved it into user_id it takes value from pojo class where it is stored 
		int user_id = us.getUser_id();
		//here the parameter are get from form and stored in 
//		String zone_type = req.getParameter("zone_type");
//		String sub_type = req.getParameter("sub_type");
//		String location = req.getParameter("location");
//		String exact_address = req.getParameter("exact_address");
//		String description = req.getParameter("description");
//		//here we put all those parameter does we got earlier and save them in 
//		Complaints cmp = new Complaints();
//		
//		cmp.setUser_id(user_id);
//		cmp.setZone_type(zone_type);
//		cmp.setSub_type(sub_type);
//		cmp.setSub_type(sub_type);
//		cmp.setExact_address(exact_address);
//		cmp.setDescription(description);
		
		//here we 
		ComplaintDAO dao = new ComplaintDAO();
		
		try {
			List<Complaints> list = dao.mycomplaints(user_id);
			
			req.setAttribute("complaints", list);
			
			req.getRequestDispatcher("complaints.jsp").forward(req, resp);
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			resp.sendRedirect("citizendashboard.jsp?page=home");
		}
		
		
	}
}
