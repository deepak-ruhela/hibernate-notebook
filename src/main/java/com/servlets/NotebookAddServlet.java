package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.entities.Notebook;
import com.helper.FactoryProvider;
import com.helper.Util;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/NotebookAddServlet")
public class NotebookAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NotebookAddServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// title,content fetch
			String name = request.getParameter("name");
			System.out.println("=========================== "+name);
			Notebook notebook = new Notebook();
			notebook.setId(Util.getNotebookMaxId());
			notebook.setName(name);

			System.out.println(notebook.getId() + " : " + notebook.getName());
			// hibernate:save()
			Session s = FactoryProvider.getFactory().openSession();
			Transaction tx = s.beginTransaction();
			s.save(notebook);
			tx.commit();
			s.close();
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<h1 style='text-align:center;'>Notebook is added successfully</h1>");
			out.println("<h1 style='text-align:center;'><a href='notebook-all.jsp'>View all notebooks</a></h1>");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
