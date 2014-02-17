<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*,com.models.AccountModel" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
AccountModel model = (AccountModel)session.getAttribute("student");
ResultSet student = model.getDetails();
student.first();
%>
<h3>Student Details : <%=student.getString("First Name") %></h3>
<table>
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
<table>
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
<table>
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
NOTE - if the information displayed is not accourate, contact the library.
</body>
</html>