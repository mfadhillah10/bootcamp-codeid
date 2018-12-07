package com.bankApp.bootcamp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class inputData {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/banking";
    static final String USER = "root";
    static final String PASS = "";
    static Connection conn;

	String name, accNum, addrs;
	Scanner i = new Scanner(System.in);
	bankInputMenu sm = new bankInputMenu();
	
	
	static ArrayList<getData> arr = new ArrayList<getData>();
	
	public void arrShow(String name,String accNum,String addrs) {
		arr.add(new getData(name,accNum,addrs));
	}
	
	public void create() {
		System.out.print("Enter your name: ");
		name = i.nextLine();
		System.out.println("Enter your account number: ");
		accNum = i.nextLine();
		System.out.print("Enter your address: ");
		addrs = i.nextLine();
		arrShow(name,accNum,addrs);
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected");
			String sql = "insert into cust_data values('"+name+"', '"+accNum+"', '"+addrs+"')";
			PreparedStatement prp = conn.prepareStatement(sql);
			prp.executeUpdate();
    	} catch(Exception e) {
    		
    	}
		
		sm.subMenu();
	}
	public void show() {
		try {
			ArrayList<String> arr2 = new ArrayList<String>();
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			String sql = "select * from cust_data";
			PreparedStatement prp = conn.prepareStatement(sql);
			ResultSet result = prp.executeQuery();
			
			while (result.next()) {
				System.out.println("Name: "+result.getString("name"));
				System.out.println("\n");
				System.out.println("Account Number: "+result.getInt("acc_number"));
				System.out.println("\n");
				System.out.println("Address: "+result.getString("address"));
				System.out.println("\n");
			}
			System.out.println("All records have been selected");
			result.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		sm.subMenu();
	}
	
	public void inq() {
		
		System.out.print("Enter keyword: ");
		String a = null;
		String search = i.next();
		
		String cek = null;
		for (getData e : arr) {
			if (search.equals(e.getAccNum())) {
				cek = "Found";
				a = e.getAccNum();
			}
		}
		if (cek=="Found") {
			System.out.println("No rekening: "+a);
		}
		else {
			System.out.println("Data is not available");

		}
		sm.subMenu();
	}
}
