<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Notebook process</title>
<%@include file="all_js_css.jsp"%>
</head>
<body>

	<div class="container">
		<%@include file="navbar.jsp"%>
		<br>

		<h1>Please fill your cover detail</h1>
		<br>

		<!-- this is add form  -->

		<form action="CoverAddServlet" method="post">

			<div class="form-group">
				<label for="name">name</label> <input name="name" required
					type="text" class="form-control" id="name" placeholder="Enter here" />

			</div>

			<div class="form-group">
				<label for="description">description</label> <input
					name="description" required type="text" class="form-control"
					id="description" placeholder="Enter here" />

			</div>

			<div class="container text-center">

				<button type="submit" class="btn btn-primary">Add</button>
				<a class="btn btn-secondary " href="cover-all.jsp">Cancel</a>
			</div>

		</form>

	</div>


</body>
</html>