package com.smartsecurity.controller;

import java.sql.Connection;
import java.sql.ResultSet;

import com.smartsecurity.model.Employee;

public class EmployeeController {
	
	public static boolean addNewEmployee(Employee A) {
		try {
			Connection cn = DBHelper.getConnection();
			String query = "insert into employee(ename,edob,egender,ecoraddress,ecorstate,ecorcity,eperaddress,"
					+ "eperstate,epercity,edepartment,equalification,edesignation,emobile,eemail,ephoto) values('"
					+ A.getEmployeeName() + "','" + A.getEmployeeDOB() + "','" + A.getEmployeeGender() + "','"
					+ A.getEmployeeCorAddress() + "','" + A.getEmployeeCorState() + "','" + A.getEmployeeCorCity()
					+ "','" + A.getEmployeePerAddress() + "','" + A.getEmployeePerState() + "','"
					+ A.getEmployeePerCity() + "','" + A.getEmployeeDepartment() + "','" + A.getEmployeeQualification()
					+ "','" + A.getEmployeeDesignation() + "','" + A.getEmployeeMobile() + "','" + A.getEmployeeEmail()
					+ "','" + A.getEmployeePhoto() + "')";
			System.out.println(query);
			boolean st = DBHelper.executeUpdate(cn, query);
			return (st);

		} catch (Exception e) {
			System.out.println("addNewEmployee " + e);
			return false;
		}
	}

	public static ResultSet getAllEmployees() {
		try {
			Connection cn = DBHelper.getConnection();
			String query = "select * from employee";
			System.out.println(query);
			ResultSet rs = DBHelper.executeQuery(cn, query);
			return (rs);

		} catch (Exception e) {
			System.out.println("AddNewRecord " + e);
			return null;
		}
	}

	public static Employee getEmployeeById(int eid) {
		try {
			Connection cn = DBHelper.getConnection();
			String query = "select * from employee where eid=" + eid;
			System.out.println(query);
			ResultSet rs = DBHelper.executeQuery(cn, query);
			if (rs.next()) {
				Employee A = new Employee();
				A.setEmployeeId(rs.getString(1));
				A.setEmployeeName(rs.getString(2));
				A.setEmployeeDOB(rs.getString(3));
				A.setEmployeeGender(rs.getString(4));
				A.setEmployeeCorAddress(rs.getString(5));
				A.setEmployeeCorState(rs.getString(6));
				A.setEmployeeCorCity(rs.getString(7));
				A.setEmployeePerAddress(rs.getString(8));
				A.setEmployeePerState(rs.getString(9));
				A.setEmployeePerCity(rs.getString(10));
				A.setEmployeeDepartment(rs.getString(11));
				A.setEmployeeQualification(rs.getString(12));
				A.setEmployeeDesignation(rs.getString(13));
				A.setEmployeeMobile(rs.getString(14));
				A.setEmployeeEmail(rs.getString(15));
				A.setEmployeePhoto(rs.getString(16));
				return (A);
			}
			return null;
		} catch (Exception e) {
			System.out.println("AddNewRecord " + e);
			return null;
		}
	}

	public static boolean editEmployee(Employee A) {
		try {
			Connection cn = DBHelper.getConnection();
			String query = "update employee set eid='" + A.getEmployeeId() + "',ename='" + A.getEmployeeName()
					+ "',edob='" + A.getEmployeeDOB() + "',egender='" + A.getEmployeeGender() + "',ecoraddress='"
					+ A.getEmployeeCorAddress() + "',ecorstate='" + A.getEmployeeCorCity() + "',eperaddress='"
					+ A.getEmployeePerAddress() + "',eperstate='" + A.getEmployeePerState() + "',epercity='"
					+ A.getEmployeePerCity() + "',edepartment='" + A.getEmployeeDepartment() + "',equalification='"
					+ A.getEmployeeQualification() + "',edesignation='" + A.getEmployeeDesignation() + "',emobile='"
					+ A.getEmployeeMobile() + "',eemail='" + A.getEmployeeEmail() + "' where eid=" + A.getEmployeeId();
			System.out.println(query);
			boolean st = DBHelper.executeUpdate(cn, query);
			return (st);

		} catch (Exception e) {
			System.out.println("AddNewRecord " + e);
			return false;
		}
	}

	public static boolean deleteEmployee(String eId) {
		try {
			Connection cn = DBHelper.getConnection();
			String query = "delete from employee where eid='"+ eId+ "'";
			System.out.println(query);
			boolean st = DBHelper.executeUpdate(cn, query);
			return (st);

		} catch (Exception e) {
			System.out.println("AddNewRecord " + e);
			return false;
		}
	}

	public static boolean editEmployeePicture(Employee E) {
		try {
			Connection cn = DBHelper.getConnection();
			String query = "update employee set ephoto='" + E.getEmployeePhoto() + "' where eid=" + E.getEmployeeId();
			System.out.println(query);
			boolean st = DBHelper.executeUpdate(cn, query);
			return (st);

		} catch (Exception e) {
			System.out.println("EditRegistration " + e);
			return false;
		}
	}
}
