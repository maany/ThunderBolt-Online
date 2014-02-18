<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900" rel="stylesheet" />
<link href="default.css" rel="stylesheet" type="text/css" media="all" />
<link href="fonts.css" rel="stylesheet" type="text/css" media="all" />
<title>ThunderBolt : Logged in as <%=session.getAttribute("firstName") %></title>
<script type="text/javascript">
function select(id)
{
	var element = document.getElementById(id);
	element.className = "current_page_item" ;
}
</script>
</head>
<%
// creating and initializing page variables
String firstName = session.getAttribute("firstName").toString();
int roll = new Integer(session.getAttribute("roll").toString());
%>

<body>
<div id = "page" class = "container">
	<div id = "header">
    	<div id="logo">
		<h1>NIT Delhi Library</h1>
		</div>

	<div id="menu">
	<ul>
	<li id="m1"><a href="redirect?navPage=150" onClick="select('m1')"><%=firstName %></a>			</li>
	<li id="m2"><a href="redirect?navPage=2" onClick="select('m2')">Dashboard</a></li>
	<li id = "m3"><a href="redirect?navPage=3" onClick="select('m3')">Catalog</a></li>
	<li id="m4"><a href="redirect?navPage=5" onClick="select('m4')">Settings</a></li>
	<li id="m5"><a href="logout" onClick="select('m5')">Logout</a></li>
	</ul>
	</div>
	</div>
    
<div id="main">
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
</body>
</html>