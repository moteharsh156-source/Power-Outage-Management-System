<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "com.project.model.*"%>
<% 

Complaints cmp = (Complaints) session.getAttribute("cmp");

if(cmp == null){
	response.sendRedirect("citizendashboard.jsp");
	return;
}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Complaints</title>
</head>
<body>

<h1>Welcome to Complaints page</h1>

<p>Here you can see all of your complaints</p>

<div class = "profile">

<strong>Comaplaint ID : </strong>
<%= cmp.getComplaint_id() %>
<br>
<strong>Zone : </strong>
<%= cmp.getZone_type() %>
<br>
<strong>Problem :</strong>
<%= cmp.getSub_type()%>
<br>
<strong>Location :</strong>
<%= cmp.getLoaction()%>
<br>
<strong>Address :</strong>
<%= cmp.getExact_address()%>
<br>
<strong>Description :</strong>
<%= cmp.getDescription()%>
<br>
<strong>Time :</strong>
<%= cmp.getCreated_at()%>
<br>
<strong>Status :</strong>
<%= cmp.getStatus()%>
</div>
</body>
</html> 