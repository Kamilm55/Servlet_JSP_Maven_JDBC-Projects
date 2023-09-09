<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" isELIgnored = "false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="com.Kamil.Model.User,com.Kamil.Model.Todo" %>
    <%@ page import="java.util.List" %>
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
    List<Todo> listTodo = (List<Todo> )session.getAttribute("listTodo");

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
					class="nav-link">Todo</a></li>
			</ul>

            <ul class="navbar-nav navbar-collapse justify-content-end">
                            <center>
                            <%-- This is a single-line comment in JSP --%>
                                      <%--  <h5 class="text-light">Full Name:${user.getFull_name()}</h5>--%>
                                      <%--  <h5 class="text-light"> Email: ${user.getEmail()}</h5>--%>
                                      <h5 class="text-light">Username:  ${user.getUsername()}</h5>
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

				<a href="<%=request.getContextPath()%>/todo/AddButton"
					class="btn btn-success">Add Todo</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Title</th>
						<th>Description</th>
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
							<td><c:out value="${todo.getDescription()}" /></td>
							<td><c:out value="${todo.targetDate}" /></td>
							<td>
                                <c:choose>
                                    <c:when test="${todo.status == true}">
                                        Complete
                                    </c:when>
                                    <c:otherwise>
                                        In Progress
                                    </c:otherwise>
                                </c:choose>
                            </td>

							<td><a class="btn btn-success" href="<%=request.getContextPath()%>/todo/setTodoForEditOption?id=<c:out value='${todo.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a class="btn btn-danger"
								href="<%=request.getContextPath()%>/todo/delete?id=<c:out value='${todo.id}' />">Delete</a></td>

						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>

    <div class="container ">

        <!-- Button to trigger the modal -->
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#userInfoModal">
            Show User Info
        </button>

        <!-- Modal -->
        <div class="modal fade" id="userInfoModal" tabindex="-1" role="dialog" aria-labelledby="userInfoModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="userInfoModalLabel">User Information</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <!-- Display user information here -->
                        <p><strong>Email:</strong> <span id="userEmail"></span></p>
                        <p><strong>Full Name:</strong> <span id="userFullName"></span></p>
                        <p><strong>Username:</strong> <span id="userUsername"></span></p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
    </div>

	<jsp:include page="./Footer.jsp"></jsp:include>

	<!-- Include Bootstrap JS and jQuery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

   <script>
       // Function to set user information and display the modal
       function showUserInfo() {
           var userEmail = "<c:out value='${user.email}' />";
           var userFullName = "<c:out value='${user.full_name}' />";
           var userUsername = "<c:out value='${user.username}' />";

           // Set user information in the modal
           document.getElementById("userEmail").textContent = userEmail;
           document.getElementById("userFullName").textContent = userFullName;
           document.getElementById("userUsername").textContent = userUsername;

           // Show the modal
           $('#userInfoModal').modal('show');
       }

       // Attach the function to the button click event
       $(document).ready(function() {
           $(".btn-primary").click(function() {
               showUserInfo();
           });
       });
   </script>


</body>
</html>