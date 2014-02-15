<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import= "java.sql.*;" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id='search_results'>
<%
ResultSet catalog = (ResultSet)session.getAttribute("catalogTable");
int count = (Integer)session.getAttribute("resultCount");
%>
<center><%=count %> Results Found</center>
<table border="1">
<tr>
<th>Accession No</th>
<th>Book Title</th>
<th>Author</th>
<th>Publisher</th>
<th>Subject</th>
<th>Status</th>
</tr>
<%
catalog.beforeFirst();
while(catalog.next())
{
%>
<tr>
<%for(int i=1;i<=5;i++){ %>
<td><%=catalog.getString(i) %></td>
<%} // for ended %>
<%if(catalog.getInt("status")!=0) {%>
<td>Available</td>
<%} else {%>
<td>Not Available</td>
<% } } //while and topmost if ended %>
</tr>
</table>
</div>
</body>
</html>