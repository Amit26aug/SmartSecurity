package com.smartsecurity.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.smartsecurity.contract.SmartSecurityContract.HostEntry;
import com.smartsecurity.model.Host;

public class HostController implements HostEntry {
	
	public static boolean addNewHost(Host host){
		try {
			Connection cn= DBHelper.getConnection();
			String nonQuery= "INSERT INTO "+ HOST_TABLE_NAME+ " VALUES(?, ?)";
			PreparedStatement preSmt= cn.prepareStatement(nonQuery);
			preSmt.setString(1, host.getHostId());
			preSmt.setString(2, host.getHostPassword());
			System.out.println(preSmt);
			
			boolean b= DBHelper.executeUpdateWithPreparedStatement(cn, preSmt);
			return b;
		} catch (Exception e) {
			System.out.println("Exception in addNewHost(): "+ e);
		}
		return false;
	}
	
	public static boolean deleteHost(String hostId){
		try {
			Connection cn= DBHelper.getConnection();
			String nonQuery= "DELETE FROM "+ HOST_TABLE_NAME+ " WHERE "+ COLUMN_HOST_HOST_ID+ "= "+ Integer.parseInt(hostId);
			System.out.println(nonQuery);
			boolean b= DBHelper.executeUpdate(cn, nonQuery);
			return b;
		} catch (Exception e) {
			System.out.println("Exception in addNewHost(): "+ e);
		}
		return false;
	}

	public static Host authenticateHost(String hostId, String hostPassword) {
		try {
			Connection cn= DBHelper.getConnection();
			String query= "SELECT * FROM "+ HOST_TABLE_NAME+ " WHERE "+ COLUMN_HOST_HOST_ID+ "= "+ Integer.parseInt(hostId)
							+ " AND "+ COLUMN_HOST_HOST_PASSWORD+ "= '"+ hostPassword+ "'";
			System.out.println(query);
			ResultSet rs= DBHelper.executeQuery(cn, query);
			if(rs.next()){
				Host host= new Host();
				host.setHostId(rs.getString(1));
				host.setHostPassword(rs.getString(2));
				return host;
			}
		} catch (Exception e) {
			System.out.println("Exception in addNewHost(): "+ e);
		}
		return null;
	}
	
}
