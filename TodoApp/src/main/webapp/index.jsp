<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" isELIgnored = "false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<body>

<center>
<h2>Sign in:</h2>
<form action="./Login" method="post">
<table>
	<tbody>
        <tr>
        <td>Email:</td>
        <td><input type="email" name="email"/></td>
		</tr>
        <tr>
        <td>Password:</td>
        <td> <input type="password" name="password"/> </td>
		</tr>
	</tbody>
</table>
    <br/>
	<input type="submit" />
</form>
 <br/>
<a href="./Register.jsp">Register page</a>
</center>

</body>
</html>