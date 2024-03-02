<%@page import="com.dao.NotebookDao"%>
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
		NotebookDao notebookDao = new NotebookDao();
		Notebook notebook = notebookDao.getNotebookById(id);
		%>


		<form action="NotebookEditServlet" method="post">

			<input value="<%=notebook.getId()%>" name="id" type="hidden" />

			<div class="form-group">
				<label for="name">Note title</label> <input name="name" required
					type="text" class="form-control" id="title"
					aria-describedby="emailHelp" placeholder="Enter here"
					value="<%=notebook.getName()%>" />

			</div>


			<div class="container text-center">

				<button type="submit" class="btn btn-success">Save your
					note</button>
				<a class="btn btn-secondary " href="notebook-all.jsp">Cancel</a>
			</div>

		</form>


	</div>
</body>
</html>