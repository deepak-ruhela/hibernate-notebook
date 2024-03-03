<%@page import="com.entities.Cover"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.dao.CoverDao"%>
<%@page import="java.util.List"%>
<%@page import="com.helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>

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
		<h1 class="text-uppercase">All covers for your notebooks:</h1>
		<a class="btn btn-primary " href="cover-add.jsp">Add Cover</a>

		<div class="row">

			<div class="col-12">

				<%
				Session s = FactoryProvider.getFactory().openSession();
				CoverDao coverDao = new CoverDao();

				List<Cover> list = coverDao.getAllCovers();
				for (Cover cover : list) {
				%>

				<div class="card mt-3">
					<img class="card-img-top m-4 mx-auto" style="max-width: 100px;"
						src="img/notepad.png" alt="Card image cap">
					<div class="card-body px-5">
						<h5 class="card-title"><%=cover.getName()%></h5>
						<p class="card-text"><%=cover.getDescription()%></p>

						<div class="container text-center mt-2">
							<a href="CoverDeleteServlet?id=<%=cover.getId()%>"
								class="btn btn-danger">Delete</a> <a
								href="cover-edit.jsp?id=<%=cover.getId()%>"
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