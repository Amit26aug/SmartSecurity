package com.smartsecurity.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.smartsecurity.contract.SmartSecurityContract.VisitorEntry;
import com.smartsecurity.contract.SmartSecurityContract.StatesEntry;
import com.smartsecurity.contract.SmartSecurityContract.CitiesEntry;
import com.smartsecurity.model.Visitor;

public class VisitorController implements VisitorEntry, StatesEntry, CitiesEntry {

	public static boolean addNewVisitor(Visitor v){
		try {
			Connection cn= DBHelper.getConnection();
			String nonQuery= "INSERT INTO "+ VISITOR_TABLE_NAME+ "("+ COLUMN_VISITOR_EMPLOYEE_ID
					+ ", "+ COLUMN_VISITOR_NAME+ ", "+ COLUMN_VISITOR_ADDRESS+ ", "+ COLUMN_VISITOR_CITY
					+ ", "+ COLUMN_VISITOR_STATE+ ", "+ COLUMN_VISITOR_MOBILE+ ", "+ COLUMN_VISITOR_EMAIL_ID
					+ ", "+ COLUMN_VISITOR_IDENTIFICATION_NO+ ", "+ COLUMN_VISITOR_IDENTIFICATION_TYPE
					+ ", "+ COLUMN_VISITOR_PICTURE
					+ ") VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement preSmt= cn.prepareStatement(nonQuery);
			preSmt.setString(1, v.getVisitorEmployeeId());
			preSmt.setString(2, v.getVisitorName());
			preSmt.setString(3, v.getVisitorAddress());
			preSmt.setString(4, v.getVisitorCity());
			preSmt.setString(5, v.getVisitorState());
			preSmt.setString(6, v.getVisitorMobile());
			preSmt.setString(7, v.getVisitorEmailId());
			preSmt.setString(8, v.getVisitorIdentificationNo());
			preSmt.setString(9, v.getVisitorIdentificationType());
			preSmt.setString(10, v.getVisitorPicture());
			
			System.out.println(preSmt);
			
			boolean result= DBHelper.executeUpdateWithPreparedStatement(cn, preSmt);
			return result;
			
		} catch (Exception e) {
			System.out.println("Exception in VisitorController.addNewVisitor(): "+ e);
		}
		return false;
	}
	
	public static ResultSet getAllVisitors(){
		try {
			Connection cn= DBHelper.getConnection();
			String stateQuery= "SELECT S."+ COLUMN_STATE_NAME+ " FROM "+ STATES_TABLE_NAME+ " S WHERE A."
					+ COLUMN_VISITOR_STATE+ "=S."+ COLUMN_STATE_ID;
			String cityQuery= "SELECT C."+ COLUMN_CITY_NAME+ " FROM "+ CITIES_TABLE_NAME+ " C WHERE A."
					+ COLUMN_VISITOR_CITY+ "=C."+ COLUMN_CITY_ID;
			String query= "SELECT A."+ COLUMN_VISITOR_EMPLOYEE_ID+ ", A."+ COLUMN_VISITOR_ID+ ", A."+ COLUMN_VISITOR_NAME
					+ ", A."+ COLUMN_VISITOR_ADDRESS+ ", ("+ cityQuery+ "), ("+ stateQuery+ "), A."+ COLUMN_VISITOR_MOBILE
					+ ", A."+ COLUMN_VISITOR_EMAIL_ID+ ", A."+ COLUMN_VISITOR_IDENTIFICATION_NO
					+ ", A."+ COLUMN_VISITOR_IDENTIFICATION_TYPE+ ", A."+ COLUMN_VISITOR_PICTURE
					+ " FROM "+ VISITOR_TABLE_NAME+ " A";
			System.out.println(query);
			
			ResultSet rs= DBHelper.executeQuery(cn, query);
			return rs;
		} catch (Exception e) {
			System.out.println("Exception in VisitorController.getAllVisitors(): "+ e);
		}
		return null;
	}
	
	public static Visitor getVisitorById(String vId){
		try {
			Connection cn= DBHelper.getConnection();
			String stateQuery= "SELECT S."+ COLUMN_STATE_NAME+ " FROM "+ STATES_TABLE_NAME+ " S WHERE A."
					+ COLUMN_VISITOR_STATE+ "=S."+ COLUMN_STATE_ID;
			String cityQuery= "SELECT C."+ COLUMN_CITY_NAME+ " FROM "+ CITIES_TABLE_NAME+ " C WHERE A."
					+ COLUMN_VISITOR_CITY+ "=C."+ COLUMN_CITY_ID;
			String query= "SELECT A."+ COLUMN_VISITOR_EMPLOYEE_ID+ ", A."+ COLUMN_VISITOR_ID+ ", A."+ COLUMN_VISITOR_NAME
					+ ", A."+ COLUMN_VISITOR_ADDRESS+ ", A."+ COLUMN_VISITOR_CITY+", ("+ cityQuery+ ")"
					+ ", A."+ COLUMN_VISITOR_STATE+ ", ("+ stateQuery+ "), A."+ COLUMN_VISITOR_MOBILE
					+ ", A."+ COLUMN_VISITOR_EMAIL_ID+ ", A."+ COLUMN_VISITOR_IDENTIFICATION_NO
					+ ", A."+ COLUMN_VISITOR_IDENTIFICATION_TYPE+ ", A."+ COLUMN_VISITOR_PICTURE
					+ " FROM "+ VISITOR_TABLE_NAME+ " A WHERE A."+ COLUMN_VISITOR_ID+ "= "+ vId;
			System.out.println(query);
			
			ResultSet rs= DBHelper.executeQuery(cn, query);
			if(rs.next()){
				Visitor v= new Visitor();
				v.setVisitorEmployeeId(rs.getString(1));
				v.setVisitorId(rs.getString(2));
				v.setVisitorName(rs.getString(3));
				v.setVisitorAddress(rs.getString(4));
				v.setVisitorCity(rs.getString(5)+ ","+ rs.getString(6));
				v.setVisitorState(rs.getString(7)+ ","+ rs.getString(8));
				v.setVisitorMobile(rs.getString(9));
				v.setVisitorEmailId(rs.getString(10));
				v.setVisitorIdentificationNo(rs.getString(11));
				v.setVisitorIdentificationType(rs.getString(12));
				v.setVisitorPicture(rs.getString(13));
				
				return v;
			}
		} catch (Exception e) {
			System.out.println("Exception in VisitorController.getVisitorById(): "+ e);
		}
		return null;
	}
	
	public static boolean upadteVisitor(Visitor v){
		try {
			Connection cn= DBHelper.getConnection();
			String nonQuery= "UPDATE "+ VISITOR_TABLE_NAME+ " SET "+ COLUMN_VISITOR_EMPLOYEE_ID
					+ "= ?, "+ COLUMN_VISITOR_NAME+ "= ?, "+ COLUMN_VISITOR_ADDRESS+ "= ?, "+ COLUMN_VISITOR_CITY
					+ "= ?, "+ COLUMN_VISITOR_STATE+ "= ?, "+ COLUMN_VISITOR_MOBILE+ "= ?, "+ COLUMN_VISITOR_EMAIL_ID
					+ "= ?, "+ COLUMN_VISITOR_IDENTIFICATION_NO+ "= ?, "+ COLUMN_VISITOR_IDENTIFICATION_TYPE
					+ "= ? WHERE "+ COLUMN_VISITOR_ID+ "= ?";
			
			PreparedStatement preSmt= cn.prepareStatement(nonQuery);
			preSmt.setString(1, v.getVisitorEmployeeId());
			preSmt.setString(2, v.getVisitorName());
			preSmt.setString(3, v.getVisitorAddress());
			preSmt.setString(4, v.getVisitorCity());
			preSmt.setString(5, v.getVisitorState());
			preSmt.setString(6, v.getVisitorMobile());
			preSmt.setString(7, v.getVisitorEmailId());
			preSmt.setString(8, v.getVisitorIdentificationNo());
			preSmt.setString(9, v.getVisitorIdentificationType());
			preSmt.setString(10, v.getVisitorId());
			
			System.out.println(preSmt);
			
			boolean result= DBHelper.executeUpdateWithPreparedStatement(cn, preSmt);
			return result;
			
		} catch (Exception e) {
			System.out.println("Exception in VisitorController.updateVisitor(): "+ e);
		}
		return false;
	}
	
	public static boolean updateVisitorPicture(Visitor v){
		try {
			Connection cn= DBHelper.getConnection();
			String nonQuery= "UPDATE "+ VISITOR_TABLE_NAME+ " SET "+ COLUMN_VISITOR_PICTURE+ "= ?"
					+" WHERE "+ COLUMN_VISITOR_ID+ "= ?";
			
			PreparedStatement preSmt= cn.prepareStatement(nonQuery);
			preSmt.setString(1, v.getVisitorPicture());
			preSmt.setString(2, v.getVisitorId());
			
			System.out.println(preSmt);
			
			boolean result= DBHelper.executeUpdateWithPreparedStatement(cn, preSmt);
			return result;
			
		} catch (Exception e) {
			System.out.println("Exception in VisitorController.updateVisitorPicture(): "+ e);
		}
		return false;
	}
	
	public static boolean deleteVisitor(String vId){
		try {
			Connection cn= DBHelper.getConnection();
			String nonQuery= "DELETE FROM "+ VISITOR_TABLE_NAME+ " WHERE "+ COLUMN_VISITOR_ID+ "= "+ vId;
			
			System.out.println(nonQuery);
			
			boolean result= DBHelper.executeUpdate(cn, nonQuery);
			return result;
			
		} catch (Exception e) {
			System.out.println("Exception in VisitorController.deleteVisitor(): "+ e);
		}
		return false;
	}
	
}
