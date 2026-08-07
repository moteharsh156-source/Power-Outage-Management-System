<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "com.project.model.*"%>
<% 

List<Complaints> list = (List<Complaints>) request.getAttribute("complaints");




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

<% if (list != null && !list.isEmpty()) 
{ 
	for (Complaints cmp : list) 
	{ 
	
	%>


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

<% }
	} else 
	{ %> 
	<p>You have not submitted any complaints.</p> 
	
	<% } %>

</body>
</html> 