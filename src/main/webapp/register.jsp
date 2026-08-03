<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register </title>
</head>
<body>

<h1>Register Page</h1>

<hr>
<br>
<form action = "RegisterServlet" method = "post"> 

<strong>Full Name :</strong>
<input type = text name = "full_name" required>
<br><br>

<strong>Email :</strong>
<input type = "email" name = "email" required>
<br><br>

<Strong>Password :</Strong>
<input type = "password" name = "password" required minlength = "8" maxlength = "12" class = "textbox">
<br><br>

<strong>Phone :</strong>
<input type = "tel" name = "phone"  required placeholder = "+91 xxxx xxx xxx" pattern = "{0-9}{4}{0-9}{3}{0-9}{3}">
<br><br>

<strong>Role :</strong>
<input type = "radio" name = "role" value = "Citizen">Citizen
<input type = "radio" name = "role" value = "Technician">Technician
<br><br>

<hr>

<input type = "submit" value = "register">
<input type = "reset" value =  "Reset">

<br><br>
<strong>Already have an account ?</strong>
<a href = "login.jsp">Login here</a>

</form>

</body>
</html>