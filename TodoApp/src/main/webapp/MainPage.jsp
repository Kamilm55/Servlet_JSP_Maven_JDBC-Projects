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

<jsp:include page="./Header.jsp"></jsp:include>
<center>
<h2>Main page!</h2>
<h5>Full Name:${user.getFull_name()}</h5>
<h5> Email: ${user.getEmail()}</h5>
<h5> UserName: ${user.getUsername()}</h5>
<form action="./LogOut" >
<input type="submit" value="Log out" />
</form>
</center>
<jsp:include page="./Footer.jsp"></jsp:include>
</body>
</html>