package com.bankApp.bootcamp;

import java.util.Scanner;

public class bankInputMenu {

	int pilih;
	
	
	public void loginMenu() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter username: ");
		String user = input.next();
		System.out.print("Enter password: ");
		String pass = input.next();
		if (user.equals("admin") && pass.equals("admin")) {
			menu();
		}
		else {
			System.out.println("Login failed");
			loginMenu();
		}
	}
	
	public void menu(){
		Scanner input = new Scanner(System.in);
		System.out.println("========================");
		System.out.println("Main Menu");
		System.out.println("1. Account Number");
		System.out.println("2. Exit");
		System.out.println("========================");
		System.out.print("Masukkan pilihan: ");
	
		try {
			pilih = input.nextInt();
		}catch (Exception e) {
			System.out.println("Invalid Input");
			menu();
		}
		
		switch (pilih) {
		case 1:
		
			subMenu();
			break;
		
		case 2:
			
			System.exit(0);
			break;
		
		default:
			System.out.println("Your choice is invalid!");
			menu();
			break;
			
		}
	}
	public void subMenu() {
		Scanner input = new Scanner(System.in);
		System.out.println("========================");
		System.out.println("Sub Menu");
		System.out.println("1. Input Data");
		System.out.println("2. View Data");
		System.out.println("3. Inquiry");
		System.out.println("4. Back to menu");
		System.out.println("========================");
		System.out.print("Masukkan pilihan: ");
		
		try {
			pilih = input.nextInt();
		}catch (Exception e) {
			System.out.println("Invalid input");
			subMenu();
		}
		
		inputData ipt = new inputData();
		
		switch (pilih) {
		case 1:
	
			ipt.create();
			break;
		
		case 2:
			
			ipt.show();
			break;
			
		case 3:
			
			ipt.inq();
			break;
			
		case 4:
			
			menu();
			break;
		
		default:
			System.out.println("Your choice is invalid!");
			subMenu();			
			break;
		}
	}
}