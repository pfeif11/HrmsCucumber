package com.hrms.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class JDBCDemo {
	
	String dbUsername= "syntax_hrm";
	String dbPassword = "syntaxhrm123";
	//jdbc:driver type://hostname:port/db name
	String dbUrl = "jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";
	
	@Test
	public void abc() throws SQLException {
		
		Connection conn=DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		System.out.println("DB connection is successful");
		Statement st = conn.createStatement();
		ResultSet rs=st.executeQuery("select * from hs_hr_employees");
		rs.next();
		String firstname=rs.getString("emp_firstname");
		System.out.println(firstname);
		rs.next();
		String firstname2=rs.getObject("emp_firstname").toString();
		System.out.println(firstname2);
		// to print out whole row, use while loop, we don't know how many times
		while(rs.next()) {
			String allData=rs.getObject("emp_firstname").toString();
			System.out.println(allData);
		}
		
	//closing the connection, we are going backwards
		
		
		rs.close();
		st.close();
		conn.close();
		// retrieve all the job titles and store them in array list
		//and show it in console from arraylist
		
	}

}
