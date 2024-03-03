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
import com.helper.FactoryProvider;
import com.helper.Util;

/**
 * Servlet implementation class CoverEditServlet
 */
public class CoverEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CoverEditServlet() {
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
		try {
			int id = Util.convertStringToInt(request.getParameter("id"));

			String name = request.getParameter("name");
			String description = request.getParameter("description");

			Session s = FactoryProvider.getFactory().openSession();
			Transaction tx = s.beginTransaction();

			Cover cover = s.get(Cover.class, id);

			cover.setName(name);
			cover.setDescription(description);

			s.saveOrUpdate(cover);

			tx.commit();
			s.close();

			response.sendRedirect("cover-all.jsp");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
