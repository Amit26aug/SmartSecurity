package com.smartsecurity.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.smartsecurity.contract.SmartSecurityContract.TrackEntry;
import com.smartsecurity.model.Track;

public class TrackController implements TrackEntry {
	
	public static boolean insertTrackDetails(Track track){
		try {
			Connection cn= DBHelper.getConnection();
			String nonQuery= "INSERT INTO "+ TRACK_TABLE_NAME+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preSmt= cn.prepareStatement(nonQuery);
			preSmt.setString(1, track.getTrackId());
			preSmt.setString(2, track.getTrackVisitorId());
			preSmt.setString(3, track.getTrackRfid());
			preSmt.setString(4, track.getTrackLocation());
			preSmt.setString(5, track.getTrackTime());
			preSmt.setString(6, track.getTrackDate());
			preSmt.setString(7, track.getTrackVisitId());
			preSmt.setString(8, track.getTrackLocationStatus());
			
			System.out.println(preSmt);
			
			boolean result= DBHelper.executeUpdateWithPreparedStatement(cn, preSmt);
			if(result)
				return true;
			
		} catch (Exception e) {
			System.out.println("Exception in TrackController.insertTrackDetails(): "+ e);
		}
		return false;
	}
	
	public static String getLocationStatus(String visitId, int location){
		try {
			Connection cn= DBHelper.getConnection();
			String query= "SELECT "+ COLUMN_TRCAK_LOCATION_STATUS+ " FROM "+ TRACK_TABLE_NAME+ " WHERE "
					+ COLUMN_TRACK_VISIT_ID+ "= "+ visitId+ " AND "+ COLUMN_TRACK_LOCATION+ "='"+ location+ "'"
							+ " ORDER BY "+ COLUMN_TRACK_TRACK_ID+ " DESC LIMIT 1";
			System.out.println(query);
			
			ResultSet rs= DBHelper.executeQuery(cn, query);
			if(rs.next()){
				return rs.getString(1);
			}
			
		} catch (Exception e) {
			System.out.println("Exception in TrackController.checkLocationStatus(): "+ e);
		}
		return null;
	}
	
	public static ResultSet getVisitorTrackingDetails(String visitorId){
		try {
			Connection cn= DBHelper.getConnection();
			String query= "SELECT * FROM "+ TRACK_TABLE_NAME+ " WHERE "+ COLUMN_TRACK_VISITOR_ID+ "= "+ visitorId
					+ " ORDER BY "+ COLUMN_TRACK_VISIT_ID+ " DESC LIMIT 50";
			System.out.println(query);
			
			ResultSet rs= DBHelper.executeQuery(cn, query);
			return rs;
		} catch (Exception e) {
			System.out.println("Exception in TrackController.getTrackingDetails(): "+ e);
		}
		return null;
	}
	
	public static ResultSet getCurrentTrackingDetails(){
		try {
			Connection cn= DBHelper.getConnection();
			String query= "SELECT * FROM "+ TRACK_TABLE_NAME+ " ORDER BY "+ COLUMN_TRACK_VISIT_ID+ " DESC LIMIT 100";
			System.out.println(query);
			
			ResultSet rs= DBHelper.executeQuery(cn, query);
			return rs;
		} catch (Exception e) {
			System.out.println("Exception in TrackController.getTrackingDetails(): "+ e);
		}
		return null;
	}
	
	public static ResultSet getTrackingDetailsBetweenDates(String from, String to){
		try {
			Connection cn= DBHelper.getConnection();
			String query= "SELECT * FROM "+ TRACK_TABLE_NAME+ " WHERE "+ COLUMN_TRACK_DATE+ " BETWEEN "+ from+ " AND "+ to;
			System.out.println(query);
			
			ResultSet rs= DBHelper.executeQuery(cn, query);
			return rs;
		} catch (Exception e) {
			System.out.println("Exception in TrackController.getTrackingDetails(): "+ e);
		}
		return null;
	}
}
