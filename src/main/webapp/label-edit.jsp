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
		Session s = FactoryProvider.getFactory().openSession();
		Label label = (Label) s.get(Label.class, id);
		%>


		<form action="LabelEditServlet" method="post">

			<input value="<%=label.getId()%>" name="id" type="hidden" />

			<div class="form-group">
				<label for="name">Note title</label> <input name="name" required
					type="text" class="form-control" id="title"
					aria-describedby="emailHelp" placeholder="Enter here"
					value="<%=label.getName()%>" />

			</div>


			<div class="container text-center">

				<button type="submit" class="btn btn-success">Save your
					note</button>
					<a class="btn btn-secondary " href="label-all.jsp">Cancel</a>
			</div>

		</form>


	</div>
</body>
</html>