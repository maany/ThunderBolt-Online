<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import = "java.sql.*,com.models.DashboardModel" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
</head>
<body>
<% 
ResultSet issued = (ResultSet)session.getAttribute("dashCurrentlyIssued"); 
ResultSet previouslyIssued = (ResultSet)session.getAttribute("dashPreviouslyIssued");
ResultSet watched = (ResultSet)session.getAttribute("dashWatched"); 
ResultSet reviewed= (ResultSet)session.getAttribute("dashReviewed"); 

issued.beforeFirst();
previouslyIssued.beforeFirst();
watched.beforeFirst();
reviewed.beforeFirst();

DashboardModel student = new DashboardModel();
int countCurrentlyIssued= student.getCount(issued);
int countPreviouslyIssued= student.getCount(previouslyIssued);
int countWatched = student.getCount(watched);
int countReviewed = student.getCount(reviewed);
%>

<center><h2><font size="+2">DASHBOARD</font></h2></center>
<br>

<div id="content">
<center>
<table cellspacing= 0 border =.5>
<caption>Books Currently Issued : <%=countCurrentlyIssued %></caption>
<tr>
<th>Accession Number</th>
<th>Book Title</th>
<th>Author</th>
<th>Publisher</th>
<th>Issued On</th>
<th>Due Date</th>
</tr>

<%
issued.beforeFirst();
while(issued.next())
{
%>
<tr>
<td><%=issued.getInt("acc_no") %></td>
<td><a href="redirect?navPage=100&acc=<%=issued.getInt("acc_no")%>"><%=issued.getString("title") %></a></td>
<td><%=issued.getString("author") %></td>
<td><%=issued.getString("publisher") %></td>
<td><%=issued.getString("issue_date") %></td>
<td><%=issued.getString("due_date") %></td>
</tr>
<%	
//System.out.println("printing : " + issued.getString("title"));
}
%>
</table>
</center>
<br>



<center>
<table cellspacing= 0 border =.5>
<caption>Books I am Watching : <%=countWatched %></caption>
<tr>
<th>Accession Number</th>
<th>Book Title</th>
<th>Author</th>
<th>Publisher</th>
<th>Status</th>
</tr>
<%
watched.beforeFirst();
while(watched.next())
{
%>
<tr>
<td><%=watched.getInt("acc_no") %></td>
<td><a href="redirect?navPage=100&acc=<%=watched.getInt("acc_no")%>"><%=watched.getString("title") %></a></td>
<td><%=watched.getString("author") %></td>
<td><%=watched.getString("publisher") %></td>
<%if(watched.getInt("status")!=0) {%>
<td>Available</td>
<%} else {%>
<td>Not Available</td></tr>
<%	
} }
%>
</table>
</center>
<br>




<center>
<table cellspacing= 0 border =.5>
<caption>Books I have Reviewed : <%=countReviewed %></caption>
<tr>
<th>Accession Number</th>
<th>Book Title</th>
<th>Author</th>
<th>Publisher</th>
</tr>
<%
reviewed.beforeFirst();
while(reviewed.next())
{
%>
<tr>
<td><%=reviewed.getInt("acc_no") %></td>
<td><a href="redirect?navPage=100&acc=<%=reviewed.getInt("acc_no")%>"><%=reviewed.getString("title") %></a></td>
<td><%=reviewed.getString("author") %></td>
<td><%=reviewed.getString("publisher") %></td>
<%	
}
%>
</table>
</center>
<br>



<center>
<table cellspacing= 0 border =.5>
<caption>Books Previously Issued : <%=countPreviouslyIssued %></caption>
<tr>
<th>Accession Number</th>
<th>Book Title</th>
<th>Author</th>
<th>Publisher</th>
<th>Issued On</th>
<th>Due Date</th>
<th>Return Date</th>
</tr>
<%
previouslyIssued.beforeFirst();
while(previouslyIssued.next())
{
%>
<tr>
<td><%=previouslyIssued.getInt("acc_no") %></td>
<td><a href="redirect?navPage=100&acc=<%=previouslyIssued.getInt("acc_no")%>"><%=previouslyIssued.getString("title") %></a></td>
<td><%=previouslyIssued.getString("author") %></td>
<td><%=previouslyIssued.getString("publisher") %></td>
<td><%=previouslyIssued.getString("issue_date") %></td>
<td><%=previouslyIssued.getString("due_date") %></td>
<td><%=previouslyIssued.getString("return_date") %></td>
</tr>
<%}%>
</table>
</center>
</div>
</body>
</html>