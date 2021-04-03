package com.bnp.kata.tictactoe;

public class Board {

	private static final int THREE = 3;
	private char[][] board;
	private static final char FIRST_PLAYER = 'X';
	private static final char SECOND_PLAYER = 'O';
	private char currentPlayer;

	public Board() {
		board = new char[THREE][THREE];
	}

	public void addPlayer(int row, int column) {

		currentPlayer = getNextPlayer();
		board[row][column] = currentPlayer;
	}

	public char getNextPlayer() {
		if (FIRST_PLAYER == currentPlayer) {

			return SECOND_PLAYER;
		} else {
			return FIRST_PLAYER;
		}
	}

	public char getPosition(int row, int column) {
		return board[row][column];
	}

	public char getCurrentPlayer() {
		return currentPlayer;
	}

	public boolean checkSelectedPositionIsEmpty(int row, int column) {
		return board[row][column] == '\0';
	}

	public boolean validateuserInputData(int row, int column) {
		if (row > 2 || row < 0 || column > 2 || column < 0) {
			return false;
		}
		return true;
	}

	boolean checkRowsForWin() {

		for (int row = 0; row < 3; row++) {

			if ((board[row][0] != '\0') && (board[row][0] == board[row][1]) && (board[row][1] == board[row][2])) {
				return true;
			}
		}
		return false;

	}



}
