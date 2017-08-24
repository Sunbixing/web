package com.example.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.domin.Person;
import com.example.service.OraclePerson;
import com.example.service.imp.OracleService;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			OraclePerson db = new OracleService();
			List<Person> persons = db.find();
			String format = request.getParameter("format");
			if ("json".equals(format)) {
				StringBuilder builder = new StringBuilder();
				builder.append("[");
				for (Person person : persons) {
					builder.append("{");
					builder.append("id:").append(person.getId()).append(",");
					builder.append("name:\"").append(person.getName()).append("\",");
					builder.append("pwd:").append(person.getPwd());
					builder.append("},");
				}
				builder.deleteCharAt(builder.length() - 1);
				builder.append("]");
				request.setAttribute("jsonperson", builder.toString());
				request.getRequestDispatcher("/WEB-INF/page/jsonperson.jsp").forward(request, response);
			} else {
				// EL表达式和jsp标准标签库
				request.setAttribute("persons", persons);
				// 重定向
				request.getRequestDispatcher("/WEB-INF/page/person.jsp").forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
