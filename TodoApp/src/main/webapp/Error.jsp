<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" isELIgnored = "false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
<%
	String error = (String) request.getAttribute("error");
%>

<center>
<h2>Error page</h2>
<h4>${error}</h4>
</center>
</body>
</html>