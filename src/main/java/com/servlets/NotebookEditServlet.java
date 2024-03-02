package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.entities.Notebook;
import com.helper.FactoryProvider;
import com.helper.Util;

/**
 * Servlet implementation class NotebookUpdateServlet
 */
@WebServlet("/NotebookEditServlet")
public class NotebookEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NotebookEditServlet() {
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
		try {
			int id = Util.convertStringToInt(request.getParameter("id"));

			String name = request.getParameter("name");

			Session s = FactoryProvider.getFactory().openSession();
			Transaction tx = s.beginTransaction();

			Notebook notebook = s.get(Notebook.class, id);

			notebook.setName(name);

			tx.commit();
			s.close();

			response.sendRedirect("notebook-all.jsp");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
