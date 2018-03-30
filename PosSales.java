package com.bcas.pos;

import java.util.ArrayList;
import java.util.Scanner;

public class PosSales {
	Scanner scan = new Scanner(System.in);
	String [] ProName= new String [50];	
	int noPro = 1;
	int [] price = new int [50];
	int [] quantity = new int [50];
	int [] totUP = new int [50];
	int tot;
	

	String [][] adminAu =  new String [1][2];
	ArrayList<String> Cuser = new ArrayList<String>();
	ArrayList<String> CPass = new ArrayList<String>();
	
	void user () {
		Cuser.add("CS012");
		CPass.add("AB012");
		adminAu [0][0] = "AD001";
		adminAu [0][1] = "QB001";
		
//		casherAu [0][0] = "CS001";
//		casherAu [0][1] = "AB001";
//		casherAu [1][0] = "CS002";
//		casherAu [1][1] = "AB002";
	}
	void login () {
		user();
		
		System.out.println("Casher = 1 /n Admin = 2 /n");
		int u1 =scan.nextInt();
		
		switch (u1) {
		//Casher 
		case 1:
			System.out.println("-----------LogIn------------");
			System.out.println("Username : ");
			String CuName = scan.next();
			System.out.println("Password :");
			String Cpass = scan.next();
			if (CuName.equals(Cuser.get(0))&&Cpass.equals(CPass.get(0))){
				System.out.println("------------Welcome CS001---------------");
				casher();
			}else {
				System.out.println("Your Username or password not match!!!!!!!!");
				login();
			}
			//type 1
//			if (casherAu [0] [0].equals(CuName) && casherAu [0] [1].equals(Cpass)) {
//				System.out.println("------------Welcome CS001---------------");
//				
//				break;
//			}else if (casherAu [1] [0].equals(CuName) && casherAu [1] [1].equals(Cpass)) {
//				System.out.println("------------Welcome CS002---------------");
//				casher();
//				break;
//			}
//			else {
//				System.out.println("Your Username or password not match!!!!!!!!");
//				login();
//			}
			break;
		//Admin	
		case 2:
			System.out.println("-----------Admin LogIn------------");
			System.out.println("Username : ");
			String AuName = scan.next();
			System.out.println("Password :");
			String APass = scan.next();
			if (adminAu [0] [0].equals(AuName) && adminAu [0] [1].equals(APass)) {
				System.out.println("------------Welcome AD001---------------");
				admin();
				break;
			}
			else {
				System.out.println("Your Username or password not match!!!!!!!!");
				login();
			}
			
			break;
		default:
			System.out.println("Wrong");
			login();
			break;
		}
	}
	void casher (){
		System.out.println("______________________________________________");
		add_items();
				
//		System.out.println("Add New Item = 1 Make a Sale = 2 ");
//		int u2 = scan.nextInt();
//	
//
//		switch (u2) {
//		case 1:
//			
//			break;
//		case 2:
//			make_sales();
//			break;
//		default:
//			casher ();
//			break;
//		}
		
		
		
		System.out.println("______________________________________________");
		

	}
	void add_items () {
		for (int i = 0; i<=40; i++) {
			noPro += i;
			System.out.println("Product Name : ");
			ProName[i]= scan.next();
			System.out.println("Price : ");
			price [i] = scan.nextInt();
			System.out.println("Quantity : ");
			quantity [i] = scan.nextInt();
			totUP[i]=price[i] * quantity[i];
			tot += totUP[i];
			System.out.println("Do you want to add more ? Yes = 1 No = 2");
			int qs =scan.nextInt();
			if (qs==1) {
				continue;
			}else if(qs==2) {
				make_sales ();
			}else {
				login();
			}
			
		}  
		System.out.println("Succuss ");
		login ();
	}
	void make_sales () {
		
		System.out.println("Total Price = " +tot);
		System.out.println("Cash ?");
		int amount=scan.nextInt();
		if (amount>tot) {
			int balance= amount - tot ;
			System.out.println("No of Product : " +noPro);
			System.out.println("Total Amount : "+tot );
			System.out.println("Balance : "+balance);
		}else {
			System.out.println("Your cash is not");
			 make_sales ();
		}
		System.out.println("Succuss ");
		login ();
		
	}
	void admin () {
		System.out.println("______________________________________________");
		
		
		System.out.println("Total Summary = 1 | ADD & Remove Users = 2 ");
		int u2 = scan.nextInt();
	

		switch (u2) {
		case 1:
			summary();
			break;
		case 2:
			System.out.println("____________________Users_________________"); 
			System.out.println("Use Add = 1 | User Remove =2");
			int ub = scan.nextInt();
			if (ub==1) {
				add_user();
			}else if (ub==2) {
				remove_user();
			}
			break;
		default:
			admin ();
			break;
		}
		
		
		
		System.out.println("______________________________________________");
	}
	void summary(){
		int i = 0;
		do {
		System.out.println("----------------------Sales----------------------------");
			
			System.out.println("Product Name :"+ProName[i]);
			System.out.println("Product Price : "+price[i]);
			System.out.println("Product Qusntity : "+quantity[i]);
		System.out.println("----------------------Stock----------------------------");
		} while (ProName==null);
		System.out.println("Total Cash : "+tot);
		System.out.println("Succuss ");
		login ();
	}
	void add_user(){
		user ();
		System.out.println("User Add ");
		System.out.println("Enter The user Name : ");
		String uname = scan.next();
		System.out.println("Password : ");
		String pass = scan.next();
		System.out.println("Conform Password : ");
		String Cpass= scan.next();
		
		if (pass==Cpass) {
		Cuser.add(uname);
		CPass.add(pass);
		System.out.println("Succuss ");
		login ();
		} else {
			System.out.println("Password Not Match ");
				admin();
		}
		System.out.println("User Add ");
		System.out.println();
		System.out.println("Succuss ");
		login ();
	}
	void remove_user() {
		user ();
		System.out.println("Remove Add ");
		System.out.println("Enter The user Name : ");
		String uname = scan.next();
		
		
		Cuser.remove(uname);
	
		
		System.out.println("Succuss ");
		login ();
		
	}
	public static void main(String[] args) {
		PosSales ps = new PosSales();
		ps.login();
		}
}
