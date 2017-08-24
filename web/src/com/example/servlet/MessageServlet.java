package com.example.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/MessageServlet")
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = request.getParameter("title");
		String time = request.getParameter("time");
		System.out.println("视频名称:" + title);
		System.out.println("时长:" + time);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean mutil = ServletFileUpload.isMultipartContent(request);
		if (mutil) {
			try {
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				@SuppressWarnings("unchecked")
				List<FileItem> items = upload.parseRequest(request);
				String dir = request.getSession().getServletContext().getRealPath("/files");
				File file=new File(dir);
				if (!file.exists()) file.mkdirs();
				for (FileItem fileItem : items) {
					if (fileItem.isFormField()) {
						String name = fileItem.getFieldName();
						String value = fileItem.getString("UTF-8");
						System.out.println(name + "=" + value);
					} else {
						
						System.out.println(dir);
						File newfile = new File(file, fileItem.getName());
						fileItem.write(newfile);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			doGet(request, response);
		}

	}

}
