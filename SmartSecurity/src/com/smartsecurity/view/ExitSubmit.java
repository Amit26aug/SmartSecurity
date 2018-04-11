package com.smartsecurity.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smartsecurity.contract.SmartSecurityContract.ExitEntry;
import com.smartsecurity.controller.ExitController;
import com.smartsecurity.model.Exit;

/**
 * Servlet implementation class ExitSubmit
 */
@WebServlet("/ExitSubmit")
public class ExitSubmit extends HttpServlet implements ExitEntry {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExitSubmit() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		String htmlFile= "<html>"
				+ "<body style='font-family: Arial'>"
				+ "<b>";
		
		Exit exit= new Exit();
		exit.setExitRFID(request.getParameter(COLUMN_EXIT_RFID));
		exit.setExitDate(request.getParameter(COLUMN_EXIT_DATE));
		exit.setExitTime(request.getParameter(COLUMN_EXIT_TIME));
		
		boolean result= ExitController.insertExitRecord(exit);
		if(result)
			htmlFile+= "Visitor Exit Successfully Recorded";
		else
			htmlFile+= "Visitor Exit Record Failed to Submit";
		htmlFile+= "<b>"
				+ "</body>"
				+ "</html>";
		
		out.println(htmlFile);
		out.flush();
	}

}
