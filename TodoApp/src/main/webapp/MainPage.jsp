<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" isELIgnored = "false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="com.Kamil.Model.User" %>
<!DOCTYPE html>
<html>
<body>
<%
  response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
%>

<%
    User user=(User)session.getAttribute("user");

	if(user == null)response.sendRedirect("./");
%>


<center>
<h2>Main page!</h2>
<h3>User Name:${user.getUsername()}</h3>
<h3> User Email: ${user.getEmail()}</h3>
<form action="./LogOut" >
<input type="submit" value="Log out" />
</form>
</center>
</body>
</html>