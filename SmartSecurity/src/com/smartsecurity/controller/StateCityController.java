package com.smartsecurity.controller;

import java.sql.Connection;
import java.sql.ResultSet;

import com.smartsecurity.contract.SmartSecurityContract.CitiesEntry;
import com.smartsecurity.contract.SmartSecurityContract.StatesEntry;



public class StateCityController implements StatesEntry, CitiesEntry{
	public  static ResultSet getAllStates(){
		try {
			Connection cn= DBHelper.getConnection();
			String query= "SELECT * FROM "+ STATES_TABLE_NAME;
			System.out.println(query);

			ResultSet rs= DBHelper.executeQuery(cn, query);
			return rs;
		} catch (Exception e) {
			System.out.println("Exception in StateCityController.getAllStates(): "+ e);
		}
		return null;
	}
	
	public static ResultSet getAllCitiesByStateId(String stateId){
		try {
			Connection cn= DBHelper.getConnection();
			String query= "SELECT * FROM "+ CITIES_TABLE_NAME+ " WHERE "+ COLUMN_STATE_ID+ "= "+ stateId;
			System.out.println(query);

			ResultSet rs= DBHelper.executeQuery(cn, query);
			return rs;
		} catch (Exception e) {
			System.out.println("Exception in StateCityController.getAllCitiesByStateId(): "+ e);
		}
		return null;
	}

	public static ResultSet getAllCities() {
		try {
			Connection cn= DBHelper.getConnection();
			String query= "SELECT * FROM "+ CITIES_TABLE_NAME;
			System.out.println(query);
			
			ResultSet rs= DBHelper.executeQuery(cn, query);
			return rs;
		} catch (Exception e) {
			System.out.println("Exception in StateCityController.getAllCities(): "+ e);
		}
		return null;
	}
}
