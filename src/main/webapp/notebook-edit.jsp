<%@page import="java.util.List"%>
<%@page import="com.dao.CoverDao"%>
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
		int id = Integer.parseInt(request.getParameter("id"));
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

			<div class="form-group">
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target=".bd-example-modal-sm">Edit Cover</button>
			</div>
			<div class="container text-center">

				<button type="submit" class="btn btn-success">Save your
					note</button>
				<a class="btn btn-secondary " href="notebook-all.jsp">Cancel</a>
			</div>

		</form>


	</div>

	<div class="modal fade bd-example-modal-sm" tabindex="-1" role="dialog"
		aria-labelledby="mySmallModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">Available
						Covers</h5>
				</div>
				<div class="modal-body py-3 px-3">
					<%
					CoverDao coverDao = new CoverDao();
					List<Cover> cList = coverDao.getAllCovers();
					for (Cover cover : cList) {
					%>
					<p>
						<a
							href="NotebookToCoverServlet?notebookId=<%=notebook.getId()%>&coverId=<%=cover.getId()%>"
							class="btn btn-primary"><%=cover.getName()%></a>

					</p>
					<%
					}
					%>
				</div>
			</div>
		</div>
	</div>
</body>
</html>