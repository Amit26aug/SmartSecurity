package com.smartsecurity.controller;

import java.sql.Connection;
import java.sql.ResultSet;

import com.smartsecurity.contract.SmartSecurityContract.VisitEntry;
import com.smartsecurity.model.Visit;

public class VisitController implements VisitEntry {
	public static boolean AddNewRecord(Visit V) {
		try {
			Connection cn = DBHelper.getConnection();
			String query = "insert into visit(vid,vrfid,vdepartmentid,vpurpose,vdate,vcheckin,vcheckout,vstatus,vhost) values('"
					+ V.getVisitVisitorId() + "','" + V.getVisitRFID() + "','" + V.getVisitDepartmentId() + "','"
					+ V.getVisitPurpose() + "','" + V.getVisitDate() + "','" + V.getVisitCheckinTime() + "','"
					+ V.getVisitCheckoutTime() + "','" + V.getVisitStatus() + "','"+ V.getVisitHost()+"')";
			System.out.println(query);
			boolean st = DBHelper.executeUpdate(cn, query);
			return (st);

		} catch (Exception e) {
			System.out.println("AddNewRecord " + e);
			return false;
		}
	}

	public static ResultSet DisplayAll() {
		try {
			Connection cn = DBHelper.getConnection();
			String query = "select * from visit";
			ResultSet rs = DBHelper.executeQuery(cn, query);
			return (rs);

		} catch (Exception e) {
			System.out.println("DisplayAll " + e);
			return null;
		}
	}

	public static Visit DisplayByID(int transactionid) {
		try {
			Connection cn = DBHelper.getConnection();
			String query = "select * from visit where transactionid=" + transactionid;
			ResultSet rs = DBHelper.executeQuery(cn, query);
			if (rs.next()) {
				Visit V = new Visit();
				V.setVisitTransactionId(rs.getString(1));
				V.setVisitVisitorId(rs.getString(2));
				V.setVisitRFID(rs.getString(3));
				V.setVisitDepartmentId(rs.getString(4));
				V.setVisitPurpose(rs.getString(5));
				V.setVisitDate(rs.getString(6));
				V.setVisitCheckinTime(rs.getString(7));
				V.setVisitCheckoutTime(rs.getString(8));
				V.setVisitStatus(rs.getString(9));
				V.setVisitHost(rs.getString(10));
				return (V);
			}
			return (null);
		} catch (Exception e) {
			System.out.println("DisplayByID " + e);
			return null;
		}
	}

	public static boolean EditRecord(Visit V) {
		try {
			Connection cn = DBHelper.getConnection();
			String query = "update visit set vid='" + V.getVisitVisitorId() + "',vrfid='" + V.getVisitRFID()
					+ "',vdepartmentid='" + V.getVisitDepartmentId() + "',vpurpose='" + V.getVisitPurpose()
					+ "',vdate='" + V.getVisitDate() + "',vcheckin='" + V.getVisitCheckinTime() + "',vcheckout='"
					+ V.getVisitCheckoutTime() + "',vstatus='" + V.getVisitStatus() + "' where transactionid="
					+ V.getVisitTransactionId();
			System.out.println(query);
			boolean st = DBHelper.executeUpdate(cn, query);
			return (st);

		} catch (Exception e) {
			System.out.println("EditRecord " + e);
			return false;
		}
	}

	public static boolean DeleteRecord(int transactionid) {
		try {
			Connection cn = DBHelper.getConnection();
			String query = "delete from visit where transactionid=" + transactionid;
			System.out.println(query);
			boolean st = DBHelper.executeUpdate(cn, query);
			return (st);

		} catch (Exception e) {
			System.out.println("DeleteRecord " + e);
			return false;
		}
	}
	
	public static boolean updateStatusToOut(String rfid){
		try {
			Connection cn= DBHelper.getConnection();
			String query= "UPDATE "+VISIT_TABLE_NAME+ " SET "+ COLUMN_VISIT_STATUS+ "= 'out' WHERE "
					+ COLUMN_VISIT_RFID+ "= '"+ rfid+ "'";
			System.out.println(query);
			boolean result= DBHelper.executeUpdate(cn, query);
			return result;
		} catch (Exception e) {
			System.out.println("Exception in VisitController.updateStatusToOut(); "+ e);
		}
		return false;
	}
	
	public static String getLastVisitId(){
		try {
			Connection cn= DBHelper.getConnection();
			String query= "SELECT "+ COLUMN_VISIT_TRANSACTION_ID+ " FROM "+ VISIT_TABLE_NAME
					+ " ORDER BY "+ COLUMN_VISIT_TRANSACTION_ID+ " DESC LIMIT 1";
			System.out.println(query);
			ResultSet rs= DBHelper.executeQuery(cn, query);
			if(rs.next())
				return rs.getString(1).trim();
		} catch (Exception e) {
			System.out.println("Exception in VisitController.getLastVisitId(); "+ e);
		}
		return null;
	}
}