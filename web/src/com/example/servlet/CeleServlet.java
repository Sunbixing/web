package com.example.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.domin.Cele;
import com.example.service.OracleResult;
import com.example.service.imp.OracleService;

@WebServlet("/CeleServlet")
public class CeleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			System.out.println("1");
			OracleResult db = new OracleService();
			System.out.println("2");
			List<Cele> results = db.findCele();
			request.setAttribute("celes", results);
			request.getRequestDispatcher("/WEB-INF/page/cele.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
