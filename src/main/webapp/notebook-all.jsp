
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
<%@page import="com.helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.entities.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All notes: Note Taker</title>
<%@include file="all_js_css.jsp"%>
</head>
<body>

	<div class="container">
		<%@include file="navbar.jsp"%>
		<br>
		<h1 class="text-uppercase">All Notebooks:</h1>
		<a class="btn btn-primary " href="notebook-add.jsp">Add Notebook</a>

		<div class="row">

			<div class="col-12">

				<%
				Session s = FactoryProvider.getFactory().openSession();
				Query q = s.createQuery("from Notebook");
				List<Notebook> list = q.list();
				for (Notebook notebook : list) {
				%>

				<div class="card mt-3">
					<img class="card-img-top m-4 mx-auto" style="max-width: 100px;"
						src="img/notepad.png" alt="Card image cap">
					<div class="card-body px-5">
						<h5 class="card-title"><%=notebook.getName()%></h5>

						<div class="container text-center mt-2">
							<a href="notebook-view.jsp?id=<%=notebook.getId()%>"
								class="btn btn-secondary">View</a> <a
								href="NotebookDeleteServlet?id=<%=notebook.getId()%>"
								class="btn btn-danger">Delete</a> <a
								href="notebook-edit.jsp?id=<%=notebook.getId()%>"
								class="btn btn-primary">Edit</a>
						</div>
					</div>
				</div>


				<%
				}

				s.close();
				%>


			</div>

		</div>


	</div>
</body>
</html>