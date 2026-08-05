<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.project.model.*" %>
<% 
User us = (User) session.getAttribute("us");

if(us == null){
	response.sendRedirect("citizendashboard.jsp");
	return;
}

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
</head>
<body>

<h1>Welcome to profile</h1>
<div class = "profile">

<strong>Name : </strong>
<%= us.getFull_name()%>

<strong>Email : </strong> 
<%= us.getEmail() %>

<strong>Phone : </strong>
<%= us.getPhone() %>

<strong>Role :</strong> 
<%= us.getRole()%>
 
</div>


</body>
</html>