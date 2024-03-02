<%@page import="java.util.Set"%>
<%@page import="com.dao.LabelDao"%>
<%@page import="com.dao.NoteDao"%>
<%@page import="java.util.List"%>
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
		<h1 class="text-uppercase">All Notes:</h1>
		<a class="btn btn-primary " href="note-add.jsp">Add New Note</a>

		<div class="row">

			<div class="col-12">

				<%
				//	Session s = FactoryProvider.getFactory().openSession();
				//	Query q = s.createQuery("from Note");
				//	List<Note> list = q.list();
				NoteDao noteDao = new NoteDao();
				LabelDao labelDao = new LabelDao();
				List<Note> list = noteDao.getAllNotes();
				for (Note note : list) {
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
						</div><span>Labels:</span> 

						<%
						Set<Label> labels = note.getLabels();
						for (Label label : labels) {
							
						%>
						<%=label.getName() %>
						
						<%
						}
						%>
					</div>

				</div>

				<%
				}

				//s.close();
				%>


			</div>

		</div>


	</div>
</body>
</html>