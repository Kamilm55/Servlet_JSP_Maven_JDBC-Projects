<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" isELIgnored = "false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="com.Kamil.Model.User" %>
<html>
<head>
<title>Todo Application</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>

<%
  response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
%>

<%
    User user=(User)session.getAttribute("user");

	if(user == null)response.sendRedirect("./");
%>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="./MainPage.jsp" class="navbar-brand"> Todo
					App</a>
			</div>


<jsp:include page="./Footer.jsp"></jsp:include>

			<ul class="navbar-nav">
				<li><a  href="./TodoForm.jsp"
					class="nav-link">Todos</a></li>
			</ul>

            <ul class="navbar-nav navbar-collapse justify-content-end">
                            <center>
                                        <h5 class="text-light">Full Name:${user.getFull_name()}</h5>
                                        <h5 class="text-light"> Email: ${user.getEmail()}</h5>
                                        <h5 class="text-light"> UserName: ${user.getUsername()}</h5>

                           </center>
            </ul>

			<ul class="navbar-nav navbar-collapse justify-content-end">
				<li><a href="./LogOut"
					class="nav-link">Logout</a></li>
			</ul>

		</nav>
	</header>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Todos</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new"
					class="btn btn-success">Add Todo</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Title</th>
						<th>Target Date</th>
						<th>Todo Status</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="todo" items="${listTodo}">

						<tr>
							<td><c:out value="${todo.title}" /></td>
							<td><c:out value="${todo.targetDate}" /></td>
							<td><c:out value="${todo.status}" /></td>

							<td><a href="edit?id=<c:out value='${todo.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${todo.id}' />">Delete</a></td>

							<!--  <td><button (click)="updateTodo(todo.id)" class="btn btn-success">Update</button>
          							<button (click)="deleteTodo(todo.id)" class="btn btn-warning">Delete</button></td> -->
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>


	<jsp:include page="./Footer.jsp"></jsp:include>
</body>
</html>