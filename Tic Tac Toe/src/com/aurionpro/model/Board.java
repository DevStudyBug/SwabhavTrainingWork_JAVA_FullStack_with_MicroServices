package com.aurionpro.model;

public class Board {
	private char[][] grid;

	public Board() {
		grid = new char[3][3];
		initializeBoard();
	}

	private void initializeBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				grid[i][j] = '_';
			}
		}
	}

	// in this method the 1st line prints 0,1 and 2 in row
	// the second syso prints 0,1,2 in column
	// and then the grid[i][j] prints the board
	public void displayBoard() {
	    System.out.println("\n       0     1     2");
	    System.out.println("    ┌─────┬─────┬─────┐");
	    for (int i = 0; i < 3; i++) {
	        System.out.print("  " + i + " │");
	        for (int j = 0; j < 3; j++) {
	            char symbol = (grid[i][j] == '_') ? ' ' : grid[i][j];
	            System.out.print("  " + symbol + "  │");
	        }
	        System.out.println();
	        if (i < 2) {
	            System.out.println("    ├─────┼─────┼─────┤");
	        }
	    }
	    System.out.println("    └─────┴─────┴─────┘");
	}


	public boolean isCellEmpty(int row, int col) {
		return grid[row][col] == '_';
	}

	public boolean isfull() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (grid[i][j] == '_')
					return false;
			}
		}
		return true;
	}
	
	public void placeSymbol(int row, int col, Symbol symbol) {
		grid[row][col]= symbol.toString().charAt(0);
	}
	
	public char[][] getGrid(){
		return grid;
	}
}
