<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import = "java.sql.*;" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Catalog</title>
</head>
<body>
<div id='filters' align='left' style="background-color:grey">
<center>Search Filters</center><br>
<form action="catalog" method="post">
Keyword : <input type="text" name="keyword"/><br><br>
In : <select name="in">
<option value="title" selected>Book Title</option>
<option value="acc_no">Accession Number</option>
<option value="author">Author</option>
<option value="publisher">Publisher</option>
<option value="subject">Subject</option>
</select><br><br>
Type : <input type="radio" name="type" value="like" checked>Like  <input type="radio" name="type" value="exact">Exact<br><br>
Order By : <select name="orderBy">
<option value="author" selected>Author</option>
<option value="acc_no">Accession Number</option>
<option value="title">Book Title</option>
<option value="subject">Subject</option>
<option value="publisher">Publisher</option>
</select><br><br>
Sort By : <input type="radio" name="sortBy" value="ASC" checked> Ascending <input type="radio" name="sortBy" value="DESC">Descending <br><br>
<center><input type="submit" value="Search"></center><br>
</form>
</div>

</body>
</html>