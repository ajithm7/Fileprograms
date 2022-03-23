package com.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CreateNewFile {

	public static void main(String[] args) throws FileNotFoundException {
		
		//1.Using File
		String path="C:\\Users\\Vasantha Kumar\\Downloads\\account.txt";
		File file=new File(path);
		try {
			boolean i=file.createNewFile();
			if(i) {
				 System.out.println("File is craeted succesfully.");
			}else {
				System.out.println("File was already created"+"\n"+"File isn't craeted.");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//Using File Output Stream along with Scanner
		try{Scanner scan=new Scanner(System.in);
		System.out.println("Enter your file name with file path :");
		String filepath=scan.nextLine();//C:\\Users\\Vasantha Kumar\\Downloads\\sriram.txt"
		FileOutputStream fos=new FileOutputStream(filepath, true);
		System.out.println("Enter the file content :");
	     String content=scan.nextLine();
	     byte byteArray[]=content.getBytes();
	     fos.write(byteArray);
	     fos.close();
	     System.out.println("file saved in given locations ");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		//3.Java nio package
		try {
		Path pathLocation=Paths.get("C:\\Users\\Vasantha Kumar\\Downloads\\text.txt");
		Files.createFile(pathLocation);}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
