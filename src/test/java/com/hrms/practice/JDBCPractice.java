package com.hrms.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class JDBCPractice {
	
	
	String dbUsername="syntax_hrm";
	String dbPassword="syntaxhrm123";
		//jdbc:driver type://hostname:port/db name
	String dbURL="jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";
	
	@Test
	public void abc() throws SQLException {
		
		Connection conn=DriverManager.getConnection(dbURL, dbUsername, dbPassword);
		Statement st=conn.createStatement();
		ResultSet rs = st.executeQuery("select emp_firstname, emp_lastname\r\n" + 
				"from hs_hr_employees\r\n" + 
				"where emp_firstname='John'\r\n" + 
				"order by emp_lastname asc");
		ResultSetMetaData rsMetaData = rs.getMetaData();
		List<Map<String,String>> listOfData = new ArrayList<>();
		Map<String,String> mapData;
		
		while(rs.next()) {
			mapData=new LinkedHashMap<>();
			for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
				mapData.put(rsMetaData.getColumnName(i),rs.getObject(i).toString());
			}
			listOfData.add(mapData);
		}
		System.out.println(listOfData);
		
		rs.close();
		st.close();
		conn.close();
	}
	
	
	
	
	
	

}
