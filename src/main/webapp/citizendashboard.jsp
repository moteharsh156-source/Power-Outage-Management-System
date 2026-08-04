<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "com.project.model.*" %>
<% 
User us = (User) session.getAttribute("us");

if(us == null){
	response.sendRedirect("login.jsp");
	return;
}

//get parameter of page 

String pagename = request.getParameter("page");
//takes all the parameters from page and stores in pagename
if(pagename == null){
	pagename = "home";
}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Citizen Dashboard</title>
</head>
<body>


<div class = "dashboard">
<br>
<div class = "sidebar">

<a href = "citizendashboard.jsp?page=profile"><button>
My Profile
</button></a>
<br><br>
<a href = "citizendashboard.jsp?page=report"><button>
Report Complaint
</button></a>
<br><br>
<a href = "citizendashboard.jsp?page=complaints"><button>
My complaints
</button></a>
<br><br>
<a href = "citizendashboard.jsp?page=update"><button>
Update Profile
</button></a>
<br><br>
<a href = "LogoutServlet"><button>
Logout
</button></a>

</div>
</div>

<div class = "content">

<%
if(pagename.equals("home")){
%>

    <h1>Power-Outage-Management-System</h1>
    <hr>

    <h2>Welcome <%= us.getFull_name() %></h2>

    <p>Welcome to your Citizen Dashboard</p>

<%
}
else if(pagename.equals("profile")){
%>

    <jsp:include page="profile.jsp"/>

<%
}
else if(pagename.equals("report")){
%>

    <jsp:include page = "report.jsp"/>

<%
}
else if(pagename.equals("complaints")){
%>

    <jsp:include page="complaints.jsp"/>

<%
}
else if(pagename.equals("update")){
%>

    <jsp:include page = "update.jsp"/>

<%
}
%>


</div>



</body>
</html>