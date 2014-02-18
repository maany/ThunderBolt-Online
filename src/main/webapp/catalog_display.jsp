<%@page import="com.models.WatchModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import= "java.sql.*;" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="tablepage.css">
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js"></script>
<script type="text/javascript">
 $(function() {
		/* For zebra striping */
        $("table tr:nth-child(odd)").addClass("odd-row");
		/* For cell text alignment */
		$("table td:first-child, table th:first-child").addClass("first");
		/* For removing the last border */
		$("table td:last-child, table th:last-child").addClass("last");
});
</script>
<style>
th{
background-color:#999;
}
</style>
<title>Insert title here</title>
</head>
<body>

<%
ResultSet catalog = (ResultSet)session.getAttribute("catalogTable");
int count = (Integer)session.getAttribute("resultCount");
%>
<center><%=count %> Results Found</center>
<div id="content">
<table cellspacing=0 border="1">
<tr>
<th>Book Title</th>
<th>Accession Number</th>
<th>Author</th>
<th>Publisher</th>
<th>Subject</th>
<th>Status</th>
<th colspan="2">Watch</th>
</tr>
<%
catalog.beforeFirst();
int acc,roll;
roll = new Integer(session.getAttribute("roll").toString());
while(catalog.next())
{
acc = new Integer(catalog.getString(1).toString());
%>
<tr>
<td><a href="redirect?navPage=100&acc=<%=acc%>"><%=catalog.getString(2) %></a></td>
<%
for(int i=1;i<=5;i++){ 
if(i==2)
	continue;
%>
<td><%=catalog.getString(i) %></td>
<%} // for ended %>
<%if(catalog.getInt("status")!=0) {%>
<td>Available</td>
<%} else {%>
<td>Not Available</td>
<% } %>
<% // watch status
WatchModel student = new WatchModel(roll);
if(student.getWatchStatus(acc)) {
%>
<td>Watching <a href ="redirect?navPage=41&acc=<%=acc%>&action=remove">unwatch</a></td>
<%} else { %>
<td><a href="redirect?acc=<%= acc%>&action=add&navPage=41">Watch</a></td>
<%} } //while ended %>
</tr>
</table>
</div>
</body>
</html>