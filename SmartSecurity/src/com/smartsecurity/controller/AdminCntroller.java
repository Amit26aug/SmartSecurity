package com.smartsecurity.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.smartsecurity.contract.SmartSecurityContract.AdminEntry;
import com.smartsecurity.model.Admin;

public class AdminCntroller implements AdminEntry{
	
	public static Admin authenticateAdmin(String adminId, String adminPassword){
		try {
			Connection cn= DBHelper.getConnection();
			String query= "SELECT * FROM "+ ADMIN_TABLE_NAME+ " WHERE "
					+ COLUMN_ADMIN_ID+ "= ? AND "+ COLUMN_ADMIN_PASSWORD+ "= ?";
			
			PreparedStatement preSmt= cn.prepareStatement(query);
			preSmt.setString(1, adminId);
			preSmt.setString(2, adminPassword);
			System.out.println(preSmt);
			
			ResultSet rs= DBHelper.executeQueryWithPreparedStatement(cn, preSmt);
			if(rs.next()){
				Admin a= new Admin();
				a.setAdminId(rs.getString(1));
				a.setAdminName(rs.getString(2));
				a.setAdminPicture(rs.getString(3));
				a.setAdminPassword(rs.getString(4));
				
				return a;
			}
		} catch (Exception e) {
			System.out.println("Problem Authenticating Admin, Exception: "+ e);
		}
		return null;
	}
	
}
