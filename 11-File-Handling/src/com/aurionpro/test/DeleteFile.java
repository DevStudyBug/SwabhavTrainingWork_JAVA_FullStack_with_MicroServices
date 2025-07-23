package com.aurionpro.test;

import java.io.File;

public class DeleteFile {
	public static void main(String[] args) {
		File file = new File("demo.txt");
//	file.delete();
//	System.out.println(file.delete());
		if (file.delete()) {
			System.out.println("Deleted : " + file.getName());
		} else {
			System.out.println("File does not exist");
		}
	}
}
