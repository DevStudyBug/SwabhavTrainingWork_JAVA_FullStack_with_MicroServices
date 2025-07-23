package com.aurionpro.test;

import java.util.Scanner;

public class TransposeOf2x3Matrix {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the size of row =2 ");
		int rowSize = scanner.nextInt();

		System.out.println("Enter the size of column = 3");
		int columnSize = scanner.nextInt();

		int[][] matrix = new int[rowSize][columnSize];
		int[][] transpose = new int[columnSize][rowSize];
		int transposeRow=columnSize;
		int transposeColumn=rowSize;
		
		System.out.println("enter the elements ");
		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < columnSize; j++) {
				matrix[i][j] = scanner.nextInt();
			}
		}

		System.out.println("Original Matrix is:  ");
		for (int[] row : matrix) {
			for (int element : row) {
				System.out.print(element + " ");
			}
			System.out.println();	
		}
		for (int i = 0; i < transposeRow ; i++) {
			for (int j = 0; j < transposeColumn
					; j++) {
				transpose[j][i] = matrix[i][j];
			
		}
		System.out.println("transpose are  ");
		for (int[] cloumn : transpose) {
			for (int trans : cloumn) {
				System.out.print(trans + " ");
			}
			System.out.println();	
		}
		
		
		//start
		
	}
	}
}
