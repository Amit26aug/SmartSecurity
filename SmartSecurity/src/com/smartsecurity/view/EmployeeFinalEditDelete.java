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

import com.smartsecurity.contract.SmartSecurityContract.EmployeeEntry;
import com.smartsecurity.controller.EmployeeController;
import com.smartsecurity.model.Employee;

/**
 * Servlet implementation class EmployeeFinalEditDelete
 */
@WebServlet("/EmployeeFinalEditDelete")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 20)
public class EmployeeFinalEditDelete extends HttpServlet implements EmployeeEntry {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeFinalEditDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String btn=request.getParameter("btn");
		
		if (btn.equals("Update")) {
			Employee E = new Employee();
			E.setEmployeeId(request.getParameter("eid"));
			E.setEmployeeName(request.getParameter("ename"));
			E.setEmployeeDOB(request.getParameter("edob"));
			E.setEmployeeGender(request.getParameter("egender"));
			E.setEmployeeCorAddress(request.getParameter("ecoraddress"));
			E.setEmployeeCorState(request.getParameter("ecorstate"));
			E.setEmployeeCorCity(request.getParameter("ecorcity"));
			E.setEmployeePerAddress(request.getParameter("eperaddress"));
			E.setEmployeePerState(request.getParameter("eperstate"));
			E.setEmployeePerCity(request.getParameter("epercity"));
			E.setEmployeeDepartment(request.getParameter("edepartment"));
			E.setEmployeeQualification(request.getParameter("equalification"));
			E.setEmployeeDesignation(request.getParameter("edesignation"));
			E.setEmployeeMobile(request.getParameter("emobile"));
			E.setEmployeeEmail(request.getParameter("eemail"));
			boolean st=EmployeeController.editEmployee(E);
		} 
		else if(btn.equals("Delete")){
			boolean st=EmployeeController.deleteEmployee(request.getParameter("eid").trim());
		}
		else if(btn.equals("Update Picture")){
			String path = EMPLOYEE_PICTURE_PATH;
			Part part = request.getPart("ephoto");
			FileUpload F = new FileUpload(part, path);
			Employee E = new Employee();
			E.setEmployeeId(request.getParameter("eid"));
			E.setEmployeePhoto(F.filename);
			boolean st=EmployeeController.editEmployeePicture(E);
			
		}
		response.sendRedirect("EmployeeDisplayAll");
	}

}
