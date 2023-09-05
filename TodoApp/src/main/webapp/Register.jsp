<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" isELIgnored = "false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<body>

<center>
<h2>Sign up:</h2>
<form action="./Register" method="post">
<table>
	<tbody>
		<tr>
		<td>Full Name:</td>
		<td><input type="text" name="fullName"/> </td>
		</tr>
        <tr>
        <td>Username:</td>
        <td> <input type="text" name="userName"/> </td>
        </tr>
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
<a href="./">Login page</a>
</center>

</body>
</html>