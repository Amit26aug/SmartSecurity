package com.smartsecurity.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.smartsecurity.contract.SmartSecurityContract.ExitEntry;
import com.smartsecurity.model.Exit;

public class ExitController implements ExitEntry {
	
	public static boolean insertExitRecord(Exit exit){
		try {
			Connection cn= DBHelper.getConnection();
			String nonQuery= "INSERT INTO "+ EXIT_TABLE_NAME+ " ("+ COLUMN_EXIT_RFID+ ", "+ COLUMN_EXIT_DATE+ ", "
					+ COLUMN_EXIT_TIME+ ") VALUES(?, ?, ?)";
			
			PreparedStatement preSmt= cn.prepareStatement(nonQuery);
			preSmt.setString(1, exit.getExitRFID());
			preSmt.setString(2, exit.getExitDate());
			preSmt.setString(3, exit.getExitTime());
			System.out.println(preSmt);
			
			boolean visitResult= false;
			boolean result= DBHelper.executeUpdateWithPreparedStatement(cn, preSmt);
			if(result)
				visitResult= VisitController.updateStatusToOut(exit.getExitRFID());
			
			return result && visitResult;
		} catch (Exception e) {
			System.out.println("Exception in ExitController.insetrExitRecord(): "+ e);
		}
		return false;
	}
	
}
