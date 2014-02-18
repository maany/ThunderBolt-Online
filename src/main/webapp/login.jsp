<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css">
<title>ThunderBolt : Login</title>
</head>
<body>
<center>
<br><br><br><br><br><br>
<center><h1><font size="+4" color="#999999">NIT Delhi Library</font></h1></center>
<form method= 'POST' action = 'login' class="login">
  <p>
<label for="login">Roll No : </label><input type = "text" name = "roll"/><br>
</p>
<p>
<label for="password">Password :  </label><input type = "password" name="pass"/><br><br>
</p>
<p class="login-submit">
      <button type="submit" class="login-button">Login</button>
    </p>
<p class="forgot-password">
<a href="reset.html">forgot password</a>
</p>
</form>

</center>
</body>
</html>