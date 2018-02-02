package com.smartsecurity.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.softech.FileUpload;

import com.smartsecurity.contract.SmartSecurityContract.DepartmentEntry;
import com.smartsecurity.controller.DepartmentController;
import com.smartsecurity.model.Department;

/**
 * Servlet implementation class DepartmentSubmit
 */
@WebServlet("/DepartmentSubmit")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 20)
public class DepartmentSubmit extends HttpServlet implements DepartmentEntry {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DepartmentSubmit() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String htmlFile =
				"<html>" 
			  + "<body style='font-family: Arial'>"
			  + "<b>";

		Department d = new Department();
		d.setDepartmentName(request.getParameter(COLUMN_DEP_NAME));

		String path = "E:\\Netbeans\\Eclipse\\SmartSecurity\\WebContent\\picture";

		Part part = request.getPart(COLUMN_DEP_LOGO);
		FileUpload file = new FileUpload(part, path);
		d.setDepartmentLogo(file.filename);
		
		boolean result= DepartmentController.addNewDepartment(d);
		if(result)
			htmlFile+= "Department Added!";
		else
			htmlFile+= "Problem Adding Department";
		
		htmlFile+= "<b>"
				 + "</body></html>";
		
		out.println(htmlFile);
	}

}
