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

		<h1>Please fill your Label detail</h1>
		<br>

		<!-- this is add form  -->

		<form action="LabelAddServlet" method="post">

			<div class="form-group">
				<label for="name">Label Name</label> <input name="name" required
					type="text" class="form-control" id="title"
					aria-describedby="emailHelp" placeholder="Enter here" />

			</div>



			<div class="container text-center">

				<button type="submit" class="btn btn-primary">Add</button>
				<a class="btn btn-secondary " href="label-all.jsp">Cancel</a>
			</div>

		</form>

	</div>


</body>
</html>