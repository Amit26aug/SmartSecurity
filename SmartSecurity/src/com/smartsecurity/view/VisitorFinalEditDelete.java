package com.smartsecurity.view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.softech.FileUpload;

import com.smartsecurity.contract.SmartSecurityContract.VisitorEntry;
import com.smartsecurity.controller.VisitorController;
import com.smartsecurity.model.Visitor;


/**
 * Servlet implementation class VisitorFinalEditDelete
 */
@WebServlet("/VisitorFinalEditDelete")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 20)
public class VisitorFinalEditDelete extends HttpServlet implements VisitorEntry {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VisitorFinalEditDelete() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String button= request.getParameter("butt");
		
		if(button.equalsIgnoreCase("Update")){
			
			System.out.println("Update clicked!");
			
			Visitor v= new Visitor();
			v.setVisitorEmployeeId(request.getParameter(COLUMN_VISITOR_EMPLOYEE_ID));
			v.setVisitorId(request.getParameter(COLUMN_VISITOR_ID));
			v.setVisitorName(request.getParameter(COLUMN_VISITOR_NAME));
			v.setVisitorAddress(request.getParameter(COLUMN_VISITOR_ADDRESS));
			v.setVisitorCity(request.getParameter(COLUMN_VISITOR_CITY));
			v.setVisitorState(request.getParameter(COLUMN_VISITOR_STATE));
			v.setVisitorMobile(request.getParameter(COLUMN_VISITOR_MOBILE));
			v.setVisitorEmailId(request.getParameter(COLUMN_VISITOR_EMAIL_ID));
			v.setVisitorIdentificationNo(request.getParameter(COLUMN_VISITOR_IDENTIFICATION_NO));
			v.setVisitorIdentificationType(request.getParameter(COLUMN_VISITOR_IDENTIFICATION_TYPE));
			
			boolean result= VisitorController.upadteVisitor(v);
			if(!result)
				System.out.println("Record Not Updated");
		}
		
		else if(button.equalsIgnoreCase("Update Photograph")){
			Visitor v= new Visitor();
			v.setVisitorId(request.getParameter(COLUMN_VISITOR_ID));
			
			Part part = request.getPart(COLUMN_VISITOR_PICTURE);
			FileUpload file = new FileUpload(part, VISITOR_PICTURE_PATH);
			v.setVisitorPicture(file.filename);
						
			boolean result= VisitorController.updateVisitorPicture(v);
			if(!result)
				System.out.println("Record Not Updated");
		}
		
		else if(button.equalsIgnoreCase("Delete Visitor")){
			boolean result= VisitorController.deleteVisitor(request.getParameter(COLUMN_VISITOR_ID));
			if(!result)
				System.out.println("Record Not Deleted");
		}
		
		response.sendRedirect("VisitorDisplayAll");
	}
}