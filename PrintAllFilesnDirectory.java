package com.file;

import java.io.File;
import java.util.Arrays;

public class PrintAllFilesnDirectory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path="C:\\Users\\Vasantha Kumar\\Downloads";
		File file=new File(path);
		File downloadDirectory[]=file.listFiles();
		Arrays.sort(downloadDirectory);
		for(File filesOrFolders:downloadDirectory) {
			
			if(filesOrFolders.isFile()) {
				System.out.println("File  : "+filesOrFolders.getName());
			}
			if(filesOrFolders.isDirectory()) {
				System.out.println("Directory  :"+filesOrFolders.getName());
				
			}
			else {
				System.out.println("Unknown File Name  : "+filesOrFolders.getName());
			}
		}

	}

}
