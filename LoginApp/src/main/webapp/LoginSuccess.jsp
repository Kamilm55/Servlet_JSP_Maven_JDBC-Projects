<%@page import="com.Kamil.Bean.Student"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Student student = (Student) request.getAttribute("student");
%>

<h2>Logged in succesfully!</h2>

	<h2>${student}</h2>
</body>
</html>