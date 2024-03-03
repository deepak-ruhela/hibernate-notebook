package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.entities.Notebook;
import com.helper.FactoryProvider;
import com.helper.Util;

/**
 * Servlet implementation class NoteToNotebookServlet
 */
public class NoteToNotebookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NoteToNotebookServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		System.out.println("============================================= NoteToNotebookServlet called");
		try {
			// title,content fetch
			int notebookId = Util.convertStringToInt(request.getParameter("notebook-id"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");

//			Note note = new Note(title, content, new Date());
			Note note = new Note();
			note.setId(Util.getNoteMaxId());
			note.setTitle(title);
			note.setContent(content);
			note.setAddedDate(new Date());

//			System.out.println(note.getId() + " : " + note.getTitle());
			// hibernate:save()
			Session s = FactoryProvider.getFactory().openSession();
			Notebook notebook = (Notebook) s.get(Notebook.class, notebookId);
			notebook.addNoteToNotebook(note);
			Transaction tx = s.beginTransaction();
			s.save(note);
			tx.commit();
			s.close();
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<h1 style='text-align:center;'>Note is added to notebook</h1>");
			out.println("<h1 style='text-align:center;'><a href='notebook-view.jsp?id="+notebookId+"'>View all notes in the notebook</a></h1>");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
