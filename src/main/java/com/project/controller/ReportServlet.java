package com.project.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Set;

import com.project.dao.ComplaintDAO;
import com.project.model.Complaints;
import com.project.model.User;


@WebServlet("/ReportServlet")
public class ReportServlet extends HttpServlet {
	
	
		//it allow user to use html tag in java  

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			//it allow user to use html tag in java  
			resp.setContentType("text/html");
			
			String zone_type = req.getParameter("zone_type");
			String sub_type = req.getParameter("sub_type");
			String location = req.getParameter("location");
			String exact_address = req.getParameter("exact_address");
			String  description = req.getParameter("description");
			
			HttpSession session = req.getSession();
			
			User us = (User) session.getAttribute("us");
			
			if(us == null) {
				resp.sendRedirect("login.jsp");
				return;
			}
			
			//getting only user_id 
			int user_id = us.getUser_id();
			
			
			Complaints cmp = new Complaints();
			
			cmp.setUser_id(user_id);
			cmp.setZone_type(zone_type);
			cmp.setSub_type(sub_type);
		    cmp.setLoaction(location);
		    cmp.setExact_address(exact_address);
		    cmp.setDescription(description);
			
		    ComplaintDAO dao = new ComplaintDAO();
		    
		    boolean status ;
		    
		    try {
				status = dao.report(cmp);
				
				HttpSession se = req.getSession();
		        session.setAttribute("cmp", cmp);
				if(status) {
			        resp.sendRedirect("citizendashboard.jsp?page=complaints");
			        
				}
			    else {
			        resp.sendRedirect("citizendashboard.jsp?page=report");
			    }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
			
			
			
		}
		
	

}
