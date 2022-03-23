package com.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
public class FileCopy {

	public static void main(String[] args) {
		FileCopy fc=new FileCopy();
		fc.copy();
	}
	public void copy() {
		File inputFile=new File("C:\\Users\\Vasantha Kumar\\Downloads\\zs.pdf");//input file object
		File outputFile=new File("C:\\Users\\Vasantha Kumar\\Downloads\\zs_copy.pdf");
		FileInputStream fileInputStream=null;
		FileOutputStream fileOutputStream=null;
		
		try {
			fileInputStream=new FileInputStream(inputFile);
			fileOutputStream=new FileOutputStream (outputFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//try {
			//System.out.println(fileInputStream.available());//this available method is used to find the memory size of input file in Bytes
		//} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
	     int i=0;
		try {
			while((i=fileInputStream.read())!=-1) {
				fileOutputStream.write(i);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(fileOutputStream!=null) {
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
            if(fileInputStream!=null) {
            	try {
					fileInputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
