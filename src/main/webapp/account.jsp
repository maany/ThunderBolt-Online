<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*,com.models.AccountModel" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="tablepage.css">
<style>
th{
background-color:#999;
}
caption{animation:ease;
color:#666
text-emphasis:#333

}
</style>
<title>Insert title here</title>
</head>
<body>
<% 
AccountModel model = (AccountModel)session.getAttribute("student");
ResultSet student = model.getDetails();
student.first();
%>

<center><h3>Student Details : <%=student.getString("First Name") %></h3></center>
<br>
<center>
<div id="content">
  <table border="1" cellspacing=0>
<caption>Basic Information</caption>
<tr>
<th>First Name</th>
<td><%=student.getString("First Name") %></td>
</tr>
<tr>
<th>Middle Name</th>
<td><%=student.getString("Middle Name") %></td>
</tr>
<tr>
<th>Last Name</th>
<td><%=student.getString("Last Name") %></td>
</tr>
<tr>
<th>Father's Name</th>
<td><%=student.getString("Fathers Name") %></td>
</tr>
<tr>
<th>Date Of Birth(yyy-MM-dd)</th>
<td><%=student.getString("Date Of Birth") %></td>
</tr>
<tr>
<tr>
<th>Gender</th>
<td><%=student.getString("Gender") %></td>
</tr>
<tr>
<th>Category</th>
<td><%=student.getString("Category") %></td>
</tr>
</table>
</div>
<br>
<div id="content">
<table cellspacing=0 border=".5">
<caption>Academic Information</caption>
<tr>
<th>Programme</th>
<td><%=student.getString("Programme") %></td>
</tr>
<tr>
<th>Branch</th>
<td><%=student.getString("Branch") %></td>
</tr>
<tr>
<th>Year</th>
<td><%=student.getString("Year") %></td>
</tr>
<tr>
<th>Semester</th>
<td><%=student.getString("Semester") %></td>
</tr>
</table>
</div>
<br>
<div id="content">
<table cellspacing=0 border=".5">
<caption>Contact Information</caption>
<tr>
<th>Primary Address</th>
<td><%=student.getString("Primary Address") %></td>
</tr>
<tr>
<th>Mailing Address</th>
<td><%=student.getString("Mailing Address") %></td>
</tr>
<tr>
<th>Contact Number</th>
<td><%=student.getString("Contact Number") %></td>
</tr>
<tr>
<th>E-Mail</th>
<td><%=student.getString("E-Mail") %></td>
</tr>
</table>
</div>
<br>
<h5>NOTE - if the information displayed is not accourate, contact the library.</h5>
</center>
</body>
</html>