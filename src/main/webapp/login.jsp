<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login page</title>
</head>
<body>

<h1>Login Page</h1>
<hr>
<br>
<form action = "LoginServlet" method = "post">

<strong>Email : </strong>
<input type = "email" name = "email" required>
<br><br>
<strong>Password :</strong>
<input type = "password" name = "password" required>
<br><br>
<hr>
<input type = "submit" values = "Submit">


</form>


</body>
</html>