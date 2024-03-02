
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
<title>All labels</title>
<%@include file="all_js_css.jsp"%>
</head>
<body>

	<div class="container">
		<%@include file="navbar.jsp"%>
		<br>
		<h1 class="text-uppercase">All Labels:</h1>
		<a class="btn btn-primary " href="label-add.jsp">Add Label</a>

		<div class="row">

			<div class="col-12">

				<%
				Session s = FactoryProvider.getFactory().openSession();
				Query q = s.createQuery("from Label");
				List<Label> list = q.list();
				for (Label label : list) {
				%>

				<div class="card mt-3">
					<img class="card-img-top m-4 mx-auto" style="max-width: 100px;"
						src="img/notepad.png" alt="Card image cap">
					<div class="card-body px-5">
						<h5 class="card-title"><%=label.getName()%></h5>

						<div class="container text-center mt-2">
						<a href="label-view.jsp?id=<%=label.getId()%>"
								class="btn btn-secondary">View</a>
							<a href="LabelDeleteServlet?id=<%=label.getId()%>"
								class="btn btn-danger">Delete</a> <a
								href="label-edit.jsp?id=<%=label.getId()%>"
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