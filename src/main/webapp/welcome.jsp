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
<div id = 'container' style="width:1500px;background-color:black">
<div id='container' style="width:1000px" align='center'>
<div id = 'header' style="height:100px" align='center'>
<h1>NIT Delhi Library</h1>
</div>

<div class="menu" style = "width:100px;float:left;background-color:grey">
<a href="redirect?navPage=150"><%=firstName %></a><br>
<a href="redirect?navPage=2">Dashboard</a><br>
<a href="redirect?navPage=3">Catalog</a><br>
<a href="redirect?navPage=5">Settings</a><br>
<a href="logout">Logout</a><br>
</div>
<div class="content" style = "float:left;width:900">
<% // in session add a var page, page name will decide what to jsp:include 
int navPage = (Integer)session.getAttribute("navPage");
if(navPage==3)
{
%>
<jsp:include page="catalog.jsp"></jsp:include>
<%} else if (navPage==4) {
System.out.println("Welcome.jsp: navPage= 4; if this is displayed.. means no major error in catalog");
%>
<jsp:include page="catalog_display.jsp"></jsp:include>
<%} else if(navPage==2) {%>
<jsp:include page="dashboard.jsp"></jsp:include>
<%} else if(navPage==100) {%>
<jsp:include page="book.jsp"></jsp:include>
<%} else if(navPage==102) {%>
<jsp:include page="review.jsp"></jsp:include>
<%} else if(navPage==150) {%>
<jsp:include page="account.jsp"></jsp:include>
<%} else if(navPage==5) {%>
<jsp:include page="settings.jsp"></jsp:include>
<%} %>
</div>
</div>
</div>
</body>
</html>