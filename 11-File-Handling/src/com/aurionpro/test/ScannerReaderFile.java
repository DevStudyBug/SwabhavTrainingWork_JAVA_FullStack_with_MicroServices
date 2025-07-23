package com.aurionpro.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerReaderFile {

	public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("demo.txt"));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }
        scanner.close();
	}
}
