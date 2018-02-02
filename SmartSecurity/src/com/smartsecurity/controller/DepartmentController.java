package com.smartsecurity.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.smartsecurity.contract.SmartSecurityContract.DepartmentEntry;
import com.smartsecurity.model.Department;

public class DepartmentController implements DepartmentEntry{
	
	public static boolean addNewDepartment(Department d){
		try {
			Connection cn= DBHelper.getConnection();
			String nonQuery= "INSERT INTO "+ DEP_TABLE_NAME+ "("+ COLUMN_DEP_NAME+ ", "+ COLUMN_DEP_LOGO
					+ ") VALUES(?, ?)";
			
			PreparedStatement preSmt= cn.prepareStatement(nonQuery);
			preSmt.setString(1, d.getDepartmentName());
			preSmt.setString(2, d.getDepartmentLogo());
			System.out.println(preSmt);
			
			boolean result= DBHelper.executeUpdateWithPreparedStatement(cn, preSmt);
			return result;
			
		} catch (Exception e) {
			System.out.println("Exception in DepartmentController.addNewDepartment(): "+ e);
		}
		return false;	
	}

	public static ResultSet getAllDepartments() {
		try {
			Connection cn= DBHelper.getConnection();
			String query= "SELECT * FROM "+ DEP_TABLE_NAME;
			System.out.println(query);
			
			ResultSet rs= DBHelper.executeQuery(cn, query);
			return rs;
		} catch (Exception e) {
			System.out.println("Exception in DepartmentController.getAllDepartments(): "+ e);
		}
		return null;
	}
	
	public static Department getDepartmentById(String depId){
		try {
			Connection cn= DBHelper.getConnection();
			String query= "SELECT * FROM "+ DEP_TABLE_NAME+ " WHERE "+ COLUMN_DEP_ID+ "= '"+ depId+ "'";
			System.out.println(query);
			
			ResultSet rs= DBHelper.executeQuery(cn, query);
			if(rs.next()){
				Department d= new Department();
				d.setDepartmentId(rs.getString(1));
				d.setDepartmentName(rs.getString(2));
				d.setDepartmentLogo(rs.getString(3));
				
				return d;
			}
		} catch (Exception e) {
			System.out.println("Exception in DepartmentController.getDepartmentById(): "+ e);
		}
		return null;
	}
	
	public static boolean updateDepartmentInfo(Department d){
		try {
			Connection cn= DBHelper.getConnection();
			String nonQuery= "UPDATE "+ DEP_TABLE_NAME+ " SET "+ COLUMN_DEP_NAME+ "= '"+ d.getDepartmentName()+"'"
					+ " WHERE "+ COLUMN_DEP_ID+ "= '"+ d.getDepartmentId()+ "'" ;
			System.out.println(nonQuery);
			
			boolean result= DBHelper.executeUpdate(cn, nonQuery);
			return result;
		} catch (Exception e) {
			System.out.println("Exception in DepartmentController.updateDepartmentInfo(): "+ e);
		}
		return false;
	}
	
	public static boolean updateDepartmentLogo(Department d){
		try {
			Connection cn= DBHelper.getConnection();
			String nonQuery= "UPDATE "+ DEP_TABLE_NAME+ " SET "+ COLUMN_DEP_LOGO+ "= '"+ d.getDepartmentLogo()+"'"
					+ " WHERE "+ COLUMN_DEP_ID+ "= '"+ d.getDepartmentId()+ "'" ;
			System.out.println(nonQuery);
			
			boolean result= DBHelper.executeUpdate(cn, nonQuery);
			return result;
		} catch (Exception e) {
			System.out.println("Exception in DepartmentController.updateDepartmentInfo(): "+ e);
		}
		return false;
	}
	
}
