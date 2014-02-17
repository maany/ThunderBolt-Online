<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.models.BookModel,java.sql.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
BookModel book = (BookModel)session.getAttribute("book");
ResultSet rs = book.getDetails();
rs.first();
%>
<div id='book_details'>
<h3>Book Details</h3>
<table border="1">
<tr>
<th>Book Title</th>
<td><%=rs.getString("title") %></td>
</tr>
<tr>
<th>Accession Number</th>
<td><%=rs.getString("acc_no") %></td>
</tr>
<tr>
<th>Author 1</th>
<td><%=rs.getString("author") %></td>
</tr>
<tr>
<th>Author 2</th>
<td><%=rs.getString("author2") %></td>
</tr>
<tr>
<th>Author 3</th>
<td><%=rs.getString("author3") %></td>
</tr>
<tr>
<th>Subject</th>
<td><%=rs.getString("subject") %></td>
</tr>
<tr>
<th>Status</th>
<%
String yesno;
int status = new Integer(rs.getInt("status"));
if(status!=0)
	yesno ="Available";
else
	yesno = "Not Available";
%>
<td><%=yesno%></td>
</tr>
<tr>
<th>Edition</th>
<td><%=rs.getString("edition") %></td>
</tr>
<tr>
<th>Publisher</th>
<td><%=rs.getString("publisher") %></td>
</tr>
<tr>
<th>No of Pages</th>
<td><%=rs.getString("pagination") %></td>
</tr>
<tr>
<th>ISBN</th>
<td><%=rs.getString("ISBN") %></td>
</tr>
</table>
</div>

<div id = "watch" >
<h3>Watch Status</h3>
<ul type="disc">
<% 
int acc = new Integer(rs.getString("acc_no"));
String watching;
int roll = new Integer(session.getAttribute("roll").toString());
boolean isWatching = book.isWatching(roll); 
if (isWatching) {
%>
<li>You are watching this book. <a href = "redirect?navPage=101&acc=<%=acc%>&action=remove ">Stop Watching?</a></li>
<%
} else {
%>
<li>You are not watching this book. <a href = "redirect?acc=<%= acc%>&action=add&navPage=101">Start Watching?</a></li>
<%} %>
<li> Total people watching this book : <%=book.getWatchCount() %></li>
</ul>
</div>

<div id="reviews">
<h3>Reviews</h3>
<ul>
<li>Total Number of reviews for this book :<%=book.getReviewCount() %></li>
<%
// if book is not reviewed, then show option write review
if (!book.isReviewed(roll)) 
{
%>
<li><a href="redirect?acc=<%=acc%>&navPage=102&action=new"> Write a review for this book </a></li>
<%}%>
</ul>
<table>
<tr>
<th>Name</th>
<th>Roll No</th>
<th>Review</th>
<%
int showExtraColumn=0;
if (book.isReviewed(roll)) {
%>
<th>Options</th>
<%
showExtraColumn = 1;
} %>
</tr>
<%
HashMap<String[],Integer> map = book.getReviews();
String name,review;
Integer rollNo;
Iterator<String[]> keySetIterator = map.keySet().iterator();

while(keySetIterator.hasNext()){
  String[] key = keySetIterator.next();
  review = key[0];
  name = key[1];
  rollNo = map.get(key);
%>
<tr>
<td><%=name %></td>
<td><%=rollNo %></td>
<td><%=review %></td>
<%if (showExtraColumn==1 ) {%>
<%
if (roll==rollNo)
{
%>
<td><a href="redirect?action=edit&navPage=102&acc=<%=acc%>">Edit</a><a href="redirect?action=delete&navPage=102&acc=<%=acc%>">Delete</a></td>
<%} else { %>
<td>Report as Abusive/Irrelevant</td>
</tr>
<%} } } //end while %>

</table>
</div>
</body>
</html>