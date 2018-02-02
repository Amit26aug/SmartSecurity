package com.smartsecurity.contract;

public class SmartSecurityContract {

	public SmartSecurityContract(){}
	
	public interface DepartmentEntry{
		public static final String DEP_TABLE_NAME= "department";
		public static final String COLUMN_DEP_ID= "did";
		public static final String COLUMN_DEP_NAME= "dname";
		public static final String COLUMN_DEP_LOGO= "dicon";
	}
	
	public interface EmployeeEntry{
		
	}
}
