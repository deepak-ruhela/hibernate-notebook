package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Cover;
import com.helper.FactoryProvider;
import com.helper.Util;

/**
 * Servlet implementation class CoverAddServlet
 */
public class CoverAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CoverAddServlet() {
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
		doGet(request, response);
		try {
			// title,content fetch
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			System.out.println(name + " =========================== " + description);
			Cover cover = new Cover();
			cover.setId(Util.getCoverMaxId());
			cover.setName(name);
			cover.setDescription(description);

			System.out.println(cover.getId() + " : " + cover.getName());
			// hibernate:save()
			Session s = FactoryProvider.getFactory().openSession();
			Transaction tx = s.beginTransaction();
			s.save(cover);
			tx.commit();
			s.close();
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<h1 style='text-align:center;'>Cover is added successfully</h1>");
			out.println("<h1 style='text-align:center;'><a href='cover-all.jsp'>View all covers</a></h1>");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
