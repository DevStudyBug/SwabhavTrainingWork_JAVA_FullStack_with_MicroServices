package com.aurionpro.test;

import java.io.File;
import java.io.IOException;

public class CreateDemoFile {
	public static void main(String[] args) throws IOException {
		File file = new File("Demo.txt");
		if(file.createNewFile()){
			System.out.println("File Created Successfull!");
		}
		else {
			System.out.println("File already exist");
		}
	}
}
