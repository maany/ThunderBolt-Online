<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.models.ReviewModel" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
int acc = new Integer(request.getParameter("acc"));
int roll = new Integer(session.getAttribute("roll").toString());
String action = request.getParameter("action"); 
String value = "";
ReviewModel book = new ReviewModel(acc);
if(action.compareTo("add")==0)
{
value = "addButton";
}else if(action.compareTo("edit")==0) {
value = "editButton";
}else if(action.compareTo("new")==0){
value = "addButton";
}
System.out.println("Review : inside jsp : action = " + action + " value = " + value);
%>
<h3>New Review : <%=book.getTitle() %></h3>
<ul>
<li> You can write only 1 review for this book (can be edited later)</li>
<li> Please do not post abusive/irrelevant stuff as it will result in permanent termination of your library membership </li>
</ul>
<form action="review" method="post">
Review : <br><textarea rows="20" cols = "100"  name="review"></textarea>
<br><input type = "submit" value = "Submit">
<input type = "hidden" name="action" value="<%=value %>"/>
<input type = "hidden" name="acc" value = "${param.acc}" />
</form>
</body>
</html>