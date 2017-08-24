package com.example.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.domin.Video;
import com.example.service.imp.VideoImp;

/**
 * Servlet implementation class LastServlet
 */
@WebServlet("/LastServlet")
public class LastServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VideoImp service=new VideoImp();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LastServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Video> videos=service.getLast();
		String format=request.getParameter("format");
		if ("json".equals(format)) {
			StringBuilder builder=new StringBuilder();
			builder.append("[");
			for (Video video : videos) {
				builder.append("{");
				builder.append("id:").append(video.getId()).append(",");
				builder.append("title:\"").append(video.getTitle()).append("\",");
				builder.append("time:").append(video.getTime());
				builder.append("},");
			}
			builder.deleteCharAt(builder.length()-1);
			builder.append("]");
			request.setAttribute("json", builder.toString());
			request.getRequestDispatcher("/WEB-INF/page/jsonvideo.jsp").forward(request, response);
		}else {
			request.setAttribute("videos", videos);
			request.getRequestDispatcher("/WEB-INF/page/video.jsp").forward(request, response);
		}
		
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
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
