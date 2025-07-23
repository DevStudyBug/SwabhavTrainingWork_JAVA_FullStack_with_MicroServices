package com.aurionpro.test;

import java.util.Scanner;

public class Array2D {
	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		System.out.println("Enter the size of row");
		int rowSize  = scanner.nextInt();
		
		System.out.println("Enter the size of column");
		int columnSize  = scanner.nextInt();
		
		int[][] matrix = new int[rowSize][columnSize];
		System.out.println("enter the elements ");
		for(int i =0; i< rowSize; i++) {
			for (int j =0; j< columnSize; j++) {
				matrix[i][j] =scanner.nextInt();
				
			}
		
		} System.out.println("Elements are ");
		for(int[] row: matrix) {
			for(int element : row) {
				System.out.print(element+" ");
			}
			System.out.println();
		}
	}
	
}
