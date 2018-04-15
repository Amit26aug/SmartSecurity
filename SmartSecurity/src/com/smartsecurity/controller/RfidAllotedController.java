package com.smartsecurity.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.smartsecurity.contract.SmartSecurityContract.RfidAllotedEntry;
import com.smartsecurity.model.RfidAlloted;

public class RfidAllotedController implements RfidAllotedEntry {

	public static boolean allotRfid(RfidAlloted r){
		try {
			Connection cn= DBHelper.getConnection();
			String nonQuery= "INSERT INTO "+ RFID_ALLOTED_TABLE_NAME+ " VALUES(?, ?, ?)";
			PreparedStatement preSmt= cn.prepareStatement(nonQuery);
			preSmt.setString(1, r.getRfidAllotedRfid());
			preSmt.setString(2, r.getRfidAllotedVisitorId());
			preSmt.setString(3, r.getRfidAllotedVisitId());
			
			System.out.println(nonQuery);
			
			boolean result= DBHelper.executeUpdateWithPreparedStatement(cn, preSmt);
			return result;
		} catch (Exception e) {
			System.out.println("Exception in allotRfid(): "+ e);
		}
		return false;
	}
	
	public static RfidAlloted getAllotedRfidDetails(String rfid){
		try {
			Connection cn= DBHelper.getConnection();
			String query= "SELECT * FROM "+ RFID_ALLOTED_TABLE_NAME+ " WHERE "+ COLUMN_RFID_ALLOTED_RFID+ "= '"+ rfid+ "'";
			System.out.println(query);
			
			ResultSet rs= DBHelper.executeQuery(cn, query);
			if(rs.next()){
				RfidAlloted ra= new RfidAlloted();
				ra.setRfidAllotedRfid(rs.getString(1));
				ra.setRfidAllotedVisitorId(rs.getString(2));
				ra.setRfidAllotedVisitId(rs.getString(3));
				
				return ra;
			}
		} catch (Exception e) {
			System.out.println("Exception in getAllotedRfidDetails(): "+ e);
		}
		return null;
	}
	
	public static boolean deleteAllotedRfid(String rfid){
		try {
			Connection cn= DBHelper.getConnection();
			String nonQuery= "DELETE FROM "+ RFID_ALLOTED_TABLE_NAME+ " WHERE "
					+ COLUMN_RFID_ALLOTED_RFID+ "='"+ rfid+ "'";
			System.out.println(nonQuery);
			
			boolean result= DBHelper.executeUpdate(cn, nonQuery);
			return result;
		} catch (Exception e) {
			System.out.println("Exception in deleteAllotedRfid(): "+ e);
		}
		return false;		
	}
	
}
