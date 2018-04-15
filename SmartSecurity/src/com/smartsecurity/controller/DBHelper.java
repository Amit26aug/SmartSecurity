package com.smartsecurity.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.json.JSONObject;

public class DBHelper {
	
	private static final String DRIVER_PATH= "com.mysql.jdbc.Driver";
	private static final String SERVER= "jdbc:mysql://localhost:3306/smartsecurity";
	private static final String USER_ID= "root";
	private static final String PASSWORD= "123";
	
	public static String getSQLFormatDate(){
		Date date= new Date();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
		String sqlFormatDate= dateFormatter.format(date);
		return sqlFormatDate;
	}
	
	public static String getSQLFormatTime(){
		Date date= new Date();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("HH:mm:ss");
		String sqlFormatTime= dateFormatter.format(date);
		return sqlFormatTime;
	}
	
	public static Connection getConnection(){
		try {
			Class.forName(DRIVER_PATH).newInstance();
			Connection cn= DriverManager.getConnection(SERVER, USER_ID, PASSWORD);
			return cn;
		} catch (Exception e) {
			System.out.println("Exception in DBHelper.getConnection(): "+ e);
		}
		return null;
	}
	
	public static ResultSet executeQuery(Connection cn, String query){
		try {
			Statement smt= cn.createStatement();
			ResultSet rs= smt.executeQuery(query);
			return rs;
		} catch (Exception e) {
			System.out.println("Exception in DBHelper.executeQuery(): "+ e);
		}
		return null;
	}
	
	public static boolean executeUpdate(Connection cn, String nonQuery){
		try {
			Statement smt= cn.createStatement();
			int rowsAffected= smt.executeUpdate(nonQuery);
			if(rowsAffected>0)
				return true;
		} catch (Exception e) {
			System.out.println("Exception in DBHelper.executeUpdate(): "+ e);
		}
		return false;
	}
	
	public static boolean executeUpdateWithPreparedStatement(Connection cn, PreparedStatement preSmt){
		try {	
			int rowsAffected= preSmt.executeUpdate();
			if(rowsAffected>0)
				return true;
		} catch (Exception e) {
			System.out.println("Exception in DBHelper.executeUpdateWithPreparedStatement(): "+ e);
		}
		return false;
	}
	
	public static ResultSet executeQueryWithPreparedStatement(Connection cn, PreparedStatement preSmt){
		try {
			ResultSet rs= preSmt.executeQuery();
			return rs;
		} catch (Exception e) {
			System.out.println("Exception in DBHelper.executeQueryWithPreparedStatement(): "+ e);
		}
		return null;
	}
	
	public static ArrayList<JSONObject> jsonEngine(ResultSet rs){
		ArrayList<JSONObject> jsonList= new ArrayList<>();
		try {
			ResultSetMetaData rsMetaData= rs.getMetaData();
			int colCount= rsMetaData.getColumnCount();
			ArrayList<String> colNamesList= new ArrayList<>();
			for(int i=1; i<=colCount; i++){
				colNamesList.add(rsMetaData.getColumnName(i).toUpperCase());
			}
			while(rs.next()){
				JSONObject jsonObj= new JSONObject();
				for(int i=1; i<=colCount; i++){
					String key= colNamesList.get(i-1);
					String value= rs.getString(i);
					jsonObj.put(key, value);
				}
				jsonList.add(jsonObj);
			}
		} catch (Exception e) {
			System.out.println("Exception in DBHelper.jsonEngine(): "+ e);
		} finally{
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println("Exception in DBHelper.jsonEngine():"+ e);
			}
		}
		return jsonList;
	}
	
}
