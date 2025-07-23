package com.aurionpro.test;

import java.io.FileWriter;
import java.io.IOException;

public class WriteDemoFile {
	public static void main(String[] args) throws IOException {
		FileWriter writer = new FileWriter("Demo.txt" , true); //object
		FileWriter writer1 = new FileWriter("D:\\JAVA\\10-Serialization\\demo.txt" , true); // different directory 

		writer.write("Hello world , 3st time\n");
		writer.append("Hello world , new  line\n");
		writer.close();
		System.out.println("Write operation done successfully");
	}
}

/*public static void main(String[] args) throws IOException {
    FileWriter writer = new FileWriter("demo.docx", true);
    writer.append("\nHello world. \nSecond write operation");
    writer.close();
}*/