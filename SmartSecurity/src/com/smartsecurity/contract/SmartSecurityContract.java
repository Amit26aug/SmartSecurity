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
		public static final String EMPLOYEE_TABLE_NAME= "employee";
		public static final String COLUMN_EMPLOYEE_ID= "eid";
		public static final String COLUMN_EMPLOYEE_NAME= "ename";
		public static final String COLUMN_EMPLOYEE_DOB= "edob";
		public static final String COLUMN_EMPLOYEE_GENDER= "egender";
		public static final String COLUMN_EMPLOYEE_COR_ADDRESS= "ecoraddress";
		public static final String COLUMN_EMPLOYEE_COR_STATE= "ecorstate";
		public static final String COLUMN_EMPLOYEE_COR_CITY= "ecorcity";
		public static final String COLUMN_EMPLOYEE_PER_ADDRESS= "eperaddress";
		public static final String COLUMN_EMPLOYEE_PER_STATE= "eperstate";
		public static final String COLUMN_EMPLOYEE_PER_CITY= "epercity";
		public static final String COLUMN_EMPLOYEE_DEPARTMENT= "edepartment";
		public static final String COLUMN_EMPLOYEE_QUALIFICATION= "equalification";
		public static final String COLUMN_EMPLOYEE_DESIGNATION= "edesignation";
		public static final String COLUMN_EMPLOYEE_MOBILE= "emobile";
		public static final String COLUMN_EMPLOYEE_EMAIL= "eemail";
		public static final String COLUMN_EMPLOYEE_PHOTOGRAPH= "ephotograph";
		
		public static final String EMPLOYEE_PICTURE_PATH= "E:\\Netbeans\\Eclipse\\SmartSecurity\\WebContent\\picture\\employee";
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
		public static final String VISIT_TABLE_NAME= "visit";
		public static final String COLUMN_VISIT_TRANSACTION_ID= "transactionid";
		public static final String COLUMN_VISIT_VISITOR_ID= "vid";
		public static final String COLUMN_VISIT_RFID= "vrfid";
		public static final String COLUMN_VISIT_DEPARTMENT_ID= "vdepartmentid";
		public static final String COLUMN_VISIT_PURPOSE= "vpurpose";
		public static final String COLUMN_VISIT_DATE= "vdate";
		public static final String COLUMN_VISIT_CHECK_IN= "vcheckin";
		public static final String COLUMN_VISIT_CHECK_OUT= "vcheckout";
		public static final String COLUMN_VISIT_STATUS= "vstatus";
	}
	
	public interface AdminEntry{
		public static final String ADMIN_TABLE_NAME= "admin";
		public static final String COLUMN_ADMIN_ID= "adminid";
		public static final String COLUMN_ADMIN_NAME= "adminname";
		public static final String COLUMN_ADMIN_PICTURE= "adminpicture";
		public static final String COLUMN_ADMIN_PASSWORD= "adminpassword";
	}
	
	public interface ExitEntry{
		public static final String EXIT_TABLE_NAME= "visitorexit";
		public static final String COLUMN_EXIT_TRANSACTION_ID= "transactionid";
		public static final String COLUMN_EXIT_RFID= "verfid";
		public static final String COLUMN_EXIT_DATE= "vedate";
		public static final String COLUMN_EXIT_TIME= "vetime";
	}
	
}
