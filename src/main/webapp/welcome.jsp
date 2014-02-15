<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ThunderBolt : Logged in as <%=session.getAttribute("firstName") %></title>
</head>
<%
// creating and initializing page variables
String firstName = session.getAttribute("firstName").toString();
int roll = new Integer(session.getAttribute("roll").toString());
%>

<body>
<div id = 'container' style="width:1500px">

<div id = 'header' style="height:100" >
<h1>NIT Delhi Library</h1>
</div>

<div class="menu" style = "width:100;float:left;background-color:grey">
<a href="account"><%=firstName %></a><br>
<a href="dashboard">Dashboard</a><br>
<a href="catalog">Catalog</a><br>
<a href="settings">Settings</a><br>
<a href="logout">Logout</a><br>
</div>
<div class="content" style = "float:left">
<% // in session add a var page, page name will decide what to jsp:include %>
</div>
</div>

</body>
</html>