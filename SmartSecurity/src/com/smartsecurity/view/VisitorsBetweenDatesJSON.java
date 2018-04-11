package com.smartsecurity.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.smartsecurity.controller.DBHelper;
import com.smartsecurity.controller.VisitorController;

/**
 * Servlet implementation class VisitorBetweenDateJSON
 */
@WebServlet("/VisitorsBetweenDatesJSON")
public class VisitorsBetweenDatesJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VisitorsBetweenDatesJSON() {
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
		PrintWriter out= response.getWriter();
		ArrayList<JSONObject> jsonArray= new ArrayList<>();
		ResultSet rs= VisitorController.getVisitorsBetweenDates(request.getParameter("fdate"),
				request.getParameter("tdate"),
				request.getParameter("status"),
				request.getParameter("search"),
				request.getParameter("searchtext"));
		
		jsonArray= DBHelper.jsonEngine(rs);
		out.println(jsonArray);
	}

}
