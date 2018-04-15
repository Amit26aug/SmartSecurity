package com.smartsecurity.controller;

import java.sql.Connection;
import java.sql.ResultSet;

import com.smartsecurity.contract.SmartSecurityContract.LocationsEntry;

public class RfidController implements LocationsEntry {
	public static boolean insertRfid(String rfid, int location){
		boolean b= false;
		try {
			Connection cn= DBHelper.getConnection();
			String query= "SELECT * FROM rfid WHERE location="+ location;
			System.out.println(query);
			ResultSet rs= DBHelper.executeQuery(cn, query);
			
			if(rs.next()){
				String nonQuery1= "UPDATE rfid SET id='"+rfid+ "' WHERE location="+ location;
				System.out.println(nonQuery1);
				b= DBHelper.executeUpdate(cn, nonQuery1);
			} else {
				String nonQuery2= "INSERT INTO rfid VALUES('"+rfid+ "', "+ location+")";
				System.out.println(nonQuery2);
				b= DBHelper.executeUpdate(cn, nonQuery2);
			}
			
			
			
		} catch (Exception e) {
			System.out.println("Exception in RfidController.insertRfid(): "+ e);
		}
		return b;
	}
	
	public static String getRfid(int location){
		try {
			Connection cn= DBHelper.getConnection();
			String query= "SELECT * FROM rfid WHERE location= "+ location;
			System.out.println(query);
			
			ResultSet rs= DBHelper.executeQuery(cn, query);
			if(rs.next())
				return rs.getString(1);
		} catch (Exception e) {
			System.out.println("Exception:"+ e);
		}
		return null;
	}
	
	public static boolean deleteRfid(int location){
		try {
			Connection cn= DBHelper.getConnection();
			String nonQuery= "DELETE FROM rfid WHERE location= "+ location;
			System.out.println(nonQuery);
			boolean result= DBHelper.executeUpdate(cn, nonQuery);
			return result;
		} catch (Exception e) {
			System.out.println("Exception:"+ e);
		}
		return false;
	}
}
