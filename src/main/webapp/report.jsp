<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Report Page</title>
</head>
<body>
<h1>REPORT POWER OUTAGE</h1>

Report an electricty problem in your area.

<br><br>
<form action = "ReportServlet" method = "post">
<strong>Zone type : </strong> 
<select name = "zone_type">

<option value = " ">--Select Zone--</option>
<option value = "Residential">Residental</option>
<option value = "Commerical" >Commerical</option>
<option value = "Industrial">Industrial</optiom>
<option value = "public">Public</option>
</select>

<br><br>

<strong>Complaints Type :</strong>

<select name = "sub_type">

<option value = "">--select complaint type </option>
 <option value="Power Outage">Power Outage</option>
    <option value="Voltage Fluctuation">Voltage Fluctuation</option>
    <option value="Low Voltage">Low Voltage</option>
    <option value="High Voltage">High Voltage</option>
    <option value="Transformer Issue">Transformer Issue</option>
    <option value="Transformer Failure">Transformer Failure</option>
    <option value="Electrical Fault">Electrical Fault</option>
    <option value="Sparking Wires">Sparking Wires</option>
    <option value="Broken Power Line">Broken Power Line</option>
    <option value="Damaged Electric Pole">Damaged Electric Pole</option>
    <option value="Fallen Electric Pole">Fallen Electric Pole</option>
    <option value="Street Light Not Working">Street Light Not Working</option>
    <option value="Frequent Power Cuts">Frequent Power Cuts</option>
    <option value="Unexpected Power Cut">Unexpected Power Cut</option>
    <option value="Meter Problem">Meter Problem</option>
    <option value="Other">Other</option>
    
</select>

<br><br>


<strong>Location :  </strong>
<input type = "text" name = "location">
<br><br>
<strong>Exact Address: </strong> 
<br><br>  
<textarea name="exact_address" rows="6" cols="50"></textarea>

<br><br>

<strong>Description</strong>
<br><br>
<textarea name="description" rows="6" cols="50"></textarea>

<br><br>
<input type = "submit" value = "Submit">

</form>
</body>
</html>