<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<body>

<h2>Sign up:</h2>
<form action="./Register" method="post">
<table>
	<tbody>
		<tr>
		<td>First Name:</td>
		<td><input type="text" name="firstName"/> </td>
		</tr>
		<tr>
		<td>Last Name:</td>
		<td><input type="text" name="lastName"/> </td>
        </tr>
        <tr>
        <td>Username:</td>
        <td> <input type="text" name="firstName"/> </td>
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


</body>
</html>