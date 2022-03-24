package com.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
//Maintain Details
//program done by the using file 
class PersonDetails implements Serializable {//pojo class

	private String name;
	private String tokenNo;
	private String maritalStatus;
	private String mobileNumber;
	private String systemNumber;

	public String getName() {
		return this.name;
	}

	public String getMobileNum() {
		return this.mobileNumber;
	}

	public String getMaritalStatus() {
		return this.maritalStatus;
	}

	public String gettokenNo() {
		return this.tokenNo;
	}

	public String getSystemNum() {
		return this.systemNumber;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMobileNum(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public void setTokenNo(String tokenNo) {
		this.tokenNo = "TK" + tokenNo;
	}

	public void setSystemNumber(String systemNumber) {
		this.systemNumber = systemNumber;
	}

}

public class MaintainStudentDetails {
	static Scanner scan = new Scanner(System.in);
	ArrayList<PersonDetails> list = new ArrayList<PersonDetails>();
	static String path = "//C:\\Users\\Vasantha Kumar\\Downloads\\Student.txt";

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		MaintainStudentDetails obj = new MaintainStudentDetails();
		obj.acccess();

	}

	public void acccess() throws IOException {

		while (true) {
			System.out.println("Enter any One of below:" + "\n" + "1-->Create new " + "\n" + "2-->Add details" + "\n"
					+ "3-->Get all details " + "\n" + "4-->Get details by token number" + "\n"
					+ "5-->Change individual details by token number" + "\n" + "6-->Exit");
			char choice = scan.next().charAt(0);
			System.out.println();
			switch (choice) {
			case '1' -> createNew();
			case '2' -> register();
			case '3' -> getAllDetails();
			case '4' -> getDetailsByTokenNumber();
			case '5' -> editDetailsByTokenNumber();
			case '6' -> System.exit(0);
			default -> System.err.println("Enter valid input");
			}

		}

	}

	public void createNew() throws IOException {
		FileOutputStream fos = new FileOutputStream(path);
		ObjectOutputStream Oos = new ObjectOutputStream(fos);
		ArrayList<PersonDetails> Newlist = new ArrayList<PersonDetails>();
		Oos.writeObject(Newlist);
		Oos.flush();
		Oos.close();
	}

	@SuppressWarnings("unchecked")
	public void register() throws IOException {

		try {
			FileInputStream fis = new FileInputStream(path);
			ObjectInputStream Ois = new ObjectInputStream(fis);
			list = (ArrayList<PersonDetails>) Ois.readObject();

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("How many you wanted enter : ");
		int numOfPeople = scan.nextInt();
		scan.nextLine();
		while (numOfPeople-- > 0) {
			PersonDetails register = new PersonDetails();
			System.out.print("Enter your Name           : ");
			register.setName(scan.nextLine());
			System.out.print("Enter your Mobile Number  : ");
			register.setMobileNum(scan.nextLine());
			System.out.print("Enter your Marital Status : ");
			register.setMaritalStatus(scan.nextLine());
			System.out.print("Enter your Token Number   : ");
			register.setTokenNo(scan.nextLine());
			System.out.print("Enter your System Number  : ");
			register.setSystemNumber(scan.nextLine());
			System.out.println("\n\n");
			list.add(register);
		}
		FileOutputStream fos = new FileOutputStream(path);
		ObjectOutputStream Oos = new ObjectOutputStream(fos);
		Oos.writeObject(list);
		Oos.flush();
		Oos.close();

	}

	@SuppressWarnings("unchecked")
	public void editDetailsByTokenNumber() throws IOException {
		int count = 0;
		try {
			FileInputStream fis = new FileInputStream(path);
			ObjectInputStream Ois = new ObjectInputStream(fis);
			list = (ArrayList<PersonDetails>) Ois.readObject();

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (list.isEmpty()) {
			System.err.println("Please enter the data");
			return;
		}

		System.out.println("Enter Token Number : ");
		String tokenNum = scan.next();
		int n = tokenNum.length();
		tokenNum = "TK" + tokenNum.substring(n - 2, n);
		for (PersonDetails token : list) {
			String currentToken = token.gettokenNo();
			if (currentToken.equalsIgnoreCase(tokenNum)) {
				count++;
				System.out.print("Pick anyone below :" + "\n" + "1-->Name" + "\n" + "2-->Mobile number" + "\n"
						+ "3-->Marital status" + "\n" + "4-->Token number" + "\n" + "5-->System number" + "\n"
						+ "6-->Exit");
				char choice = scan.next().charAt(0);
				scan.nextLine();
				switch (choice) {
				case '1' -> {
					System.out.print("Enter your new name number : ");
					token.setName(scan.nextLine());
				}
				case '2' -> {
					System.out.print("Enter your Mobile Number  : ");
					token.setMobileNum(scan.next());
				}
				case '3' -> {
					System.out.print("Enter your Marital Status : ");
					token.setMaritalStatus(scan.next());
				}
				case '4' -> {
					System.out.print("Enter your Token Number       : ");
					token.setTokenNo(scan.next());
				}
				case '5' -> {
					System.out.print("Enter your System Number  : ");
					token.setSystemNumber(scan.next());
				}
				case '6' -> System.exit(0);
				default -> System.err.println("Enter valid input");

				}// System.out.println();
			}
		}
		if (count == 0) {
			System.err.println("Enter valid token number:");
			editDetailsByTokenNumber();
		}
		System.out.println();
		FileOutputStream fos = new FileOutputStream(path);
		ObjectOutputStream Oos = new ObjectOutputStream(fos);
		Oos.writeObject(list);
		Oos.flush();
		Oos.close();

	}

	@SuppressWarnings("unchecked")
	public void getAllDetails() throws IOException {
		try {
			FileInputStream fis = new FileInputStream(path);
			ObjectInputStream Ois = new ObjectInputStream(fis);
			list = (ArrayList<PersonDetails>) Ois.readObject();

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (list.isEmpty()) {
			System.err.println("You didn't enter the data");
			return;
		}

		for (PersonDetails token : list) {

			System.out.println("Name           : " + token.getName());

			System.out.println("Mobile Number  : " + token.getMobileNum());

			System.out.println("Marital Status : " + token.getMaritalStatus());

			System.out.println("Token Number   : " + token.gettokenNo());

			System.out.println("System Number  : " + token.getSystemNum());

		}
		System.out.println();
		FileOutputStream fos = new FileOutputStream(path);
		ObjectOutputStream Oos = new ObjectOutputStream(fos);
		Oos.writeObject(list);
		Oos.flush();
		Oos.close();

	}

	@SuppressWarnings("unchecked")
	public void getDetailsByTokenNumber() throws IOException {
		int count = 0;

		try {
			FileInputStream fis = new FileInputStream(path);
			ObjectInputStream Ois = new ObjectInputStream(fis);
			list = (ArrayList<PersonDetails>) Ois.readObject();

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (list.isEmpty()) {
			System.err.println("Please enter the data");
			return;
		}

		System.out.println("Enter Token Number : ");
		String tokenNum = scan.next();
		int n = tokenNum.length();
		tokenNum = "TK" + tokenNum.substring(n - 2, n);
		for (PersonDetails token : list) {
			String currentToken = token.gettokenNo();
			if (currentToken.equalsIgnoreCase(tokenNum)) {
				count++;

				System.out.println("Name           : " + token.getName());

				System.out.println("Mobile Number  : " + token.getMobileNum());

				System.out.println("Marital Status : " + token.getMaritalStatus());

				System.out.println("Token Number   : " + token.gettokenNo());

				System.out.println("System Number  : " + token.getSystemNum());

			}
		}
		if (count == 0) {
			System.err.println("Enter valid token number:");
			getDetailsByTokenNumber();
		}
		System.out.println();
		FileOutputStream fos = new FileOutputStream(path);
		ObjectOutputStream Oos = new ObjectOutputStream(fos);
		Oos.writeObject(list);
		Oos.flush();
		Oos.close();

	}

}
