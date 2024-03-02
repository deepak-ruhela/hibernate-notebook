package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dao.LabelDao;
import com.dao.NoteDao;
import com.entities.Label;
import com.entities.Note;
import com.entities.Notebook;
import com.helper.FactoryProvider;
import com.helper.Util;

/**
 * Servlet implementation class NoteToLabelServlet
 */
public class NoteToLabelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NoteToLabelServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("============================================= NoteToLabelServlet called");
		Session session = FactoryProvider.getFactory().openSession();
		try {
			int noteId = Util.convertStringToInt(request.getParameter("noteId"));
			int labelId = Util.convertStringToInt(request.getParameter("labelId"));
			System.out.println(
					"============================================= noteId: " + noteId + ", labelId= " + labelId);

			NoteDao noteDao = new NoteDao();
			Note note = (Note) session.get(Note.class, noteId);
			// noteDao.getNoteById(noteId);

			LabelDao labelDao = new LabelDao();
			Label label = (Label) session.get(Label.class, labelId);
			// labelDao.getLabelById(labelId);

			// Add label to note
			note.getLabels().add(label);

			Transaction tx = session.beginTransaction();

			// Save or update the note (which will cascade to labels)
			session.saveOrUpdate(note);

			tx.commit();
			session.close();
			response.sendRedirect("note-edit.jsp?note_id=" + noteId);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
