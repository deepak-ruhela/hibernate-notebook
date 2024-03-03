<%@page import="com.dao.CoverDao"%>
<%@page import="org.hibernate.id.IntegralDataTypeHolder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.helper.*,org.hibernate.*,com.entities.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="all_js_css.jsp"%>
</head>
<body>
	<div class="container">
		<%@include file="navbar.jsp"%>
		<h1>Edit your note</h1>
		<br>

		<%
		int id = Integer.parseInt(request.getParameter("id").trim());
		CoverDao coverDao = new CoverDao();
		Cover cover = coverDao.getCoverById(id);
		%>


		<form action="CoverEditServlet" method="post">

			<input value="<%=cover.getId()%>" name="id" type="hidden" />

			<div class="form-group">
				<label for="name">name</label> <input name="name" required
					type="text" class="form-control" id="name"
					aria-describedby="emailHelp" placeholder="Enter here"
					value="<%=cover.getName()%>" />

			</div>

			<div class="form-group">
				<label for="description">description</label> <input
					name="description" required type="text" class="form-control"
					id="description" placeholder="Enter here"
					value="<%=cover.getDescription()%>" />

			</div>

			<div class="container text-center">

				<button type="submit" class="btn btn-primary">Add</button>
				<a class="btn btn-secondary " href="cover-all.jsp">Cancel</a>
			</div>

		</form>


	</div>
</body>
</html>