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
				if (checkRowColumnContent(board[row][0], board[row][1], board[row][2]))
					return true;
			}
		}
		return false;

	}

	boolean checkColumnsForWin() {

		for (int column = 0; column < 3; column++) {

			if ((board[column][0] != '\0') && (board[0][column] == board[1][column]) && (board[1][column] == board[2][column])) {
				if (checkRowColumnContent(board[0][column], board[1][column], board[2][column]))
					return true;
			}
		}
		return false;

	}

	public boolean checkDiagonalsForWin() {
		return ((checkRowColumnContent(board[0][0], board[1][1], board[2][2]) == true)|| (checkRowColumnContent(board[0][2], board[1][1], board[2][0]) == true));
	}

	private boolean checkRowColumnContent(char c1, char c2, char c3) {

		return ((c1 != '\0') && (c1 == c2) && (c2 == c3));

	}
	
	public boolean checkIfBoardFullyOccupied() {
		boolean isFull = true;

		for (int i = 0; i < 3; i++) {

			for (int j = 0; j < 3; j++) {

				if (board[i][j] == '\0') {

					isFull = false;
				}
			}
		}
		return isFull;
	}

}
