<%@page import="java.util.List"%>
<%@page import="com.dao.LabelDao"%>
<%@page import="com.dao.NoteDao"%>
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
		int noteId = Integer.parseInt(request.getParameter("note_id").trim());
		NoteDao noteDao = new NoteDao();
		Note note = noteDao.getNoteById(noteId);
		%>


		<form action="NoteEditServlet" method="post">

			<input value="<%=note.getId()%>" name="noteId" type="hidden" />

			<div class="form-group">
				<label for="title">Note title</label> <input name="title" required
					type="text" class="form-control" id="title"
					aria-describedby="emailHelp" placeholder="Enter here"
					value="<%=note.getTitle()%>" />

			</div>


			<div class="form-group">
				<label for="content">Note Content</label>
				<textarea name="content" required id="content"
					placeholder="Enter your content here" class="form-control"
					style="height: 300px;"><%=note.getContent()%>
					</textarea>


			</div>
			<div class="form-group">
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target=".bd-example-modal-sm">Edit Label</button>
			</div>
			<div class="container text-center">

				<button type="submit" class="btn btn-success">Save your
					note</button>
				<a class="btn btn-secondary " href="note-all.jsp">Cancel</a>
			</div>

		</form>


	</div>


	<div class="modal fade bd-example-modal-sm" tabindex="-1" role="dialog"
		aria-labelledby="mySmallModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">Available
						Labels</h5>
				</div>
				<div class="modal-body py-3 px-3">
					<%
					LabelDao labelDao = new LabelDao();
					List<Label> listLabel = labelDao.getAllLabels();
					for (Label label : listLabel) {
					%>
					<p>
						<a
							href="NoteToLabelServlet?noteId=<%=note.getId()%>&labelId=<%=label.getId()%>"
							class="btn btn-primary"><%=label.getName()%></a>

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