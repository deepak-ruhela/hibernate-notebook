<%@page import="java.util.Set"%>
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
		<h1>Label View</h1>
		<br>

		<%
		int id = Integer.parseInt(request.getParameter("id").trim());
		Session s = FactoryProvider.getFactory().openSession();
		Label label = (Label) s.get(Label.class, id);
		Set<Note> notes = label.getNotes();
		%>


		<div class="row">

			<div class="col-12">

				<%
				for (Note note : notes) {
				%>

				<div class="card mt-3">
					<img class="card-img-top m-4 mx-auto" style="max-width: 100px;"
						src="img/notepad.png" alt="Card image cap">
					<div class="card-body px-5">
						<h5 class="card-title"><%=note.getTitle()%></h5>
						<p class="card-text">
							<%=note.getContent()%>
						</p>
						<p>
							<b class="text-primary"><%=note.getAddedDate()%></b>
						</p>
						<div class="container text-center mt-2">
							<a href=NoteDeleteServlet?note_id=
								<%=note.getId()%>" class="btn btn-danger">Delete</a> <a
								href="note-edit.jsp?note_id=<%=note.getId()%>"
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