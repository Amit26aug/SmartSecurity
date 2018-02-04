package com.smartsecurity.contract;

public class SmartSecurityContract {

	public SmartSecurityContract(){}
	
	public interface StatesEntry{
		public static final String STATES_TABLE_NAME= "states";
		public static final String COLUMN_STATE_ID= "sid";
		public static final String COLUMN_STATE_NAME= "sname";
	}
	
	public interface CitiesEntry{
		public static final String CITIES_TABLE_NAME= "cities";
		public static final String COLUMN_CITY_ID= "cid";
		public static final String COLUMN_CITY_NAME= "cname";
		public static final String COLUMN_CITY_SATATE_ID= "sid";
	}
	
	public interface DepartmentEntry{
		public static final String DEP_TABLE_NAME= "department";
		public static final String COLUMN_DEP_ID= "did";
		public static final String COLUMN_DEP_NAME= "dname";
		public static final String COLUMN_DEP_LOGO= "dicon";
	}
	
	public interface EmployeeEntry{
		
	}
	
	public interface VisitorEntry{
		public static final String VISITOR_TABLE_NAME= "visitor";
		public static final String COLUMN_VISITOR_EMPLOYEE_ID= "veid";
		public static final String COLUMN_VISITOR_ID= "vid";
		public static final String COLUMN_VISITOR_NAME= "vname";
		public static final String COLUMN_VISITOR_ADDRESS= "vaddress";
		public static final String COLUMN_VISITOR_CITY= "vcity";
		public static final String COLUMN_VISITOR_STATE= "vstate";
		public static final String COLUMN_VISITOR_MOBILE= "vmobile";
		public static final String COLUMN_VISITOR_EMAIL_ID= "vemailid";
		public static final String COLUMN_VISITOR_IDENTIFICATION_NO= "videntificationno";
		public static final String COLUMN_VISITOR_IDENTIFICATION_TYPE= "videntificationtype";
		public static final String COLUMN_VISITOR_PICTURE= "vpicture";
		
		public static final String VISITOR_PICTURE_PATH= "E:\\Netbeans\\Eclipse\\SmartSecurity\\WebContent\\picture\\visitor";
	}
	
	public interface VisitEntry{
		
	}
	
}
