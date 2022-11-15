package emailapp;
import java.util.*;
import java.io.*;

public class Email {
	public Scanner s = new Scanner(System.in); //Scanner class global
	
	// Setting variables as private to not give access directly
	private String fname;
	private String lname;
	private String dept;
	private String email;
	private String password;
	private int mailCapacity = 500;
	private String alter_email;
	
	// Constructor to receive first name, last name
	public Email(String fname, String lname) {
		this.fname = fname;
		this.lname = lname;
		System.out.println("----------------------");
		System.out.println("New Employee: " + this.fname + " " + this.lname);
		//calling methods
		this.dept = this.setDept(); // department
		this.password = this.generate_password(8); // password
		this.email = this.generate_email();
		
	}
	
	// Generate mail method
	private String generate_email() {
		return this.fname.toLowerCase()+"."+this.lname.toLowerCase()+"@"+this.dept.toLowerCase()+"."+"company.com";		
	}
	
	// Asking for dept
	private String setDept() {
		System.out.println("----------------------");
		System.out.println("Deparment codes\n1 for Sales \n2 for Developemnt \n3 for Accounting \n4 for IT \n0 for none");
		boolean flag = false;
		do {
			System.out.println("Enter Department code: ");
			int choice = s.nextInt();
			switch (choice) {
			case 1: 
				return "Sales";
			case 2:
				return "Development";
			case 3:
				return "Accounting";
			case 4:
				return "IT";
			case 0:
				return "None";
			default:
				System.out.println("Invalid choice please choose it again");
			}
		}while(!flag); 
			return null;
	}

	// Generate random password method
	private String generate_password(int length) {
		Random r = new Random();
		String Capital_char="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String Small_chars="abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		String symbols="!@#$%&?";
		String values = Capital_char+Small_chars+numbers+symbols;
		String password ="";
		for (int i=0;i<length;i++) {
			password = password + values.charAt(r.nextInt(values.length()));
		}
		return password;
	}
	
	// change password method
	public void set_password() {
		boolean flag = false;
		do {
			System.out.println("Do you want to change your password! (Y/N)");
			char choice = s.next().charAt(0);
			if(choice == 'Y' || choice == 'y') {
				flag = true;
				System.out.println("Enter current password:");
				String tem = s.next();
				if(tem.equals(this.password)) {
					System.out.println("Enter new password:");
					this.password = s.next();
					System.out.println("Password changed successfully");
				}
				else {
					System.out.println("Incorrect password");
				}
			}else if(choice == 'N' || choice == 'n') {
				flag = true;
				System.out.println("Password change option cancelled!");
			}else {
				System.out.println("Enter Valid choice");
			}
		}while(!flag); 
	}
	
	// Set mail box capacity method
	public void set_mailCap() {
		System.out.println("Current capacity= "+this.mailCapacity+"mb");
		System.out.println("Enter new mailbox capcity: ");
		this.mailCapacity = s.nextInt();
		System.out.println("Mailbox capacity is Successfully changed");
		}
	
	// Set alternate mail
	public void alternate_email() {
		System.out.println("Enter new alternate mail: ");
		this.alter_email = s.next();
		System.out.println("Alternate Email is set");
	}
	
	//Display user information method
	public void getInfo() {
		System.out.println("Name: "+this.fname+" "+this.lname);
		System.out.println("Department: "+this.dept);
		System.out.println("Email: "+this.email);
		System.out.println("Password: "+this.password);
		System.out.println("Mailbox capacity: "+this.mailCapacity+"mb");
		System.out.println("Alternate email: "+this.alter_email);
	}
	
	// store void storefile(){
	public void storefile() {
		try {
			FileWriter in = new FileWriter("C:\\Users\\Acer\\Desktop\\info.txt");
			in.write("First name: "+this.fname);
			in.append("\nLast name: "+this.lname);
			in.append("\nEmail: "+this.email);
			in.append("\nPassword: "+this.password);
			in.append("\nCapacity: "+this.mailCapacity);
			in.append("\nAlternate mail: "+this.alter_email);
			in.close();
			System.out.println("Data Stored...");
		}catch (Exception e){
			System.out.println(e);
		}
	}

	// reading file method
	public void read_file() {
		try {
			FileReader f1 = new FileReader("C:\\Users\\Acer\\Desktop\\info.txt");
			int i;
			while((i=f1.read())!=-1) {
				System.out.print((char)i);
			}
			//System.out.println();
			f1.close();	
		}catch(Exception e) {
			System.out.println(e);
		}
	}


}
