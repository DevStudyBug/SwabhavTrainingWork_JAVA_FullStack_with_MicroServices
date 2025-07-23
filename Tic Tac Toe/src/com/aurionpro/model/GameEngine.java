package com.aurionpro.model;

public class GameEngine {
	private Player currentPlayer;

	public GameEngine(Player player1) {
		this.currentPlayer = player1;
	}

	public Player getCurrPlayer() {
		return currentPlayer;
	}

	public void switchPlayer(Player player1, Player player2) {
		currentPlayer = (currentPlayer == player1) ? player2 : player1;
	}

	public boolean isWinningMove(Board board, Symbol symbol) {
		char[][] grid = board.getGrid();
		char s = symbol.toString().charAt(0);

		for (int i = 0; i < 3; i++)
			if ((grid[i][0] == s && grid[i][1] == s && grid[i][2] == s) || // rows
					(grid[0][i] == s && grid[1][i] == s && grid[2][i] == s)) // columns
				return true;

		if ((grid[0][0] == s && grid[1][1] == s && grid[2][2] == s) || // main diagonal
				(grid[0][2] == s && grid[1][1] == s && grid[2][0] == s)) // anti diagonal
			return true;

		return false;
	}
}
