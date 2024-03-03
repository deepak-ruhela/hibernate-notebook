package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Cover;
import com.entities.Notebook;
import com.helper.FactoryProvider;
import com.helper.Util;

/**
 * Servlet implementation class NotebookToCoverServlet
 */
public class NotebookToCoverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NotebookToCoverServlet() {
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
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("============================================= NoteToLabelServlet called");
		Session session = FactoryProvider.getFactory().openSession();
		try {
			int notebookId = Util.convertStringToInt(request.getParameter("notebookId"));
			int coverId = Util.convertStringToInt(request.getParameter("coverId"));
			System.out.println("============================================= notebookId= " + notebookId + ", coverId= "
					+ coverId);
			Notebook notebook = (Notebook) session.get(Notebook.class, notebookId);
			Cover cover = (Cover) session.get(Cover.class, coverId);
//			cover.setNotebook(notebook);
//			cover.getNotebook().addCoverToNotebook(cover);
			notebook.setCover(cover);
			notebook.getCover().setNotebook(notebook);
			Transaction tx = session.beginTransaction();

			// Save or update the note (which will cascade to labels)
			session.saveOrUpdate(notebook);

			tx.commit();
			session.close();
			response.sendRedirect("notebook-view.jsp?id=" + notebookId);

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
