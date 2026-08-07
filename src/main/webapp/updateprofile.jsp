<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Profile</title>
</head>
<body>

<h1>Update Profile</h1>

<form action = "UpdateProfileServlet" method = "post">

<strong>Name : </strong>
<input type = "text" name = "full_name">
<br><br>

<strong>Email : </strong>
<input type = "email" name = "email" required>
<br><br>

<strong>Password :</strong>
<input type = "password" name = "password" required required minlength = "8" maxlength = "12">
<br><br>

<strong>New password :</strong>
<input type = "password" name = "newpassword" required required minlength = "8" maxlength = "12">
<br><br>

<strong>Phone :</strong>
<input type = "tel" name = "phone" placeholder = "+91 xxxx xxx xxx" pattern = "{0-9}{4}{0-9}{3}{0-9}{3}">
<br><br>

<input type = "submit" value = "Submit">





</form>

</body>
</html>