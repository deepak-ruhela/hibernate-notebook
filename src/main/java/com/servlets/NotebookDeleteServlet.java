package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.entities.Notebook;
import com.helper.FactoryProvider;
import com.helper.Util;

/**
 * Servlet implementation class NotebookDeleteServlet
 */
@WebServlet("/NotebookDeleteServlet")
public class NotebookDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NotebookDeleteServlet() {
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
		try {
			int id = Util.convertStringToInt(request.getParameter("id").trim());

			Session s = FactoryProvider.getFactory().openSession();
			Transaction tx = s.beginTransaction();
			Notebook notebook = (Notebook) s.get(Notebook.class, id);
			s.delete(notebook);
			tx.commit();
			s.close();
			response.sendRedirect("notebook-all.jsp");

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
