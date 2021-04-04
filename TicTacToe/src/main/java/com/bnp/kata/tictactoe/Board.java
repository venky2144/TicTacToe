package com.bnp.kata.tictactoe;

import java.util.logging.Logger;

public class Board {

	private static final int THREE = 3;
	private char[][] gameBoard;
	private static final char FIRST_PLAYER = 'X';
	private static final char SECOND_PLAYER = 'O';
	private char currentPlayer;
	private static final Logger logger = Logger.getLogger(Board.class.getName());


	public Board() {
		gameBoard = new char[THREE][THREE];
	}

	public void addPlayer(int row, int column) {

		currentPlayer = getNextPlayer();
		gameBoard[row][column] = currentPlayer;
	}

	public char getNextPlayer() {
		if (FIRST_PLAYER == currentPlayer) {

			return SECOND_PLAYER;
		} else {
			return FIRST_PLAYER;
		}
	}

	public char getPosition(int row, int column) {
		return gameBoard[row][column];
	}

	public char getCurrentPlayer() {
		return currentPlayer;
	}

	public boolean checkSelectedPositionIsEmpty(int row, int column) {
		return gameBoard[row][column] == '\0';
	}

	public boolean validateUserInputData(int row, int column) {
		boolean result;
		if (row > 2 || row < 0 || column > 2 || column < 0) {
			result = false;
		} else {

			result = true;
		}
		return result;
	}

	boolean checkRowsForWin() {

		for (int row = 0; row < 3; row++) {

			if ((gameBoard[row][0] != '\0') && (gameBoard[row][0] == gameBoard[row][1]) && (gameBoard[row][1] == gameBoard[row][2])) {
				if (checkRowColumnContent(gameBoard[row][0], gameBoard[row][1], gameBoard[row][2])) {
					return true;
				}
			}
		}
		return false;

	}

	boolean checkColumnsForWin() {

		for (int column = 0; column < 3; column++) {

			if ((gameBoard[column][0] != '\0') && (gameBoard[0][column] == gameBoard[1][column])
					&& (gameBoard[1][column] == gameBoard[2][column])) {
				if (checkRowColumnContent(gameBoard[0][column], gameBoard[1][column], gameBoard[2][column])) {
					return true;
				}
			}
		}
		return false;

	}

	public boolean checkDiagonalsForWin() {
		boolean isTrue=true;
		return ((checkRowColumnContent(gameBoard[0][0], gameBoard[1][1], gameBoard[2][2]) == isTrue)|| (checkRowColumnContent(gameBoard[0][2], gameBoard[1][1], gameBoard[2][0]) == isTrue));
	}

	private boolean checkRowColumnContent(char c1, char c2, char c3) {

		return ((c1 != '\0') && (c1 == c2) && (c2 == c3));

	}
	
	public boolean checkIfBoardFullyOccupied() {
		boolean isFull = true;

		for (int i = 0; i < 3; i++) {

			for (int j = 0; j < 3; j++) {

				if (gameBoard[i][j] == '\0') {

					isFull = false;
				}
			}
		}
		return isFull;
	}
	
	public void printBoard() {
		System.out.println("-------------");

		for (int row = 0; row < THREE; row++) {
			System.out.print("| ");
			for (int column = 0; column < 3; column++) {
				System.out.print(gameBoard[row][column] + " | ");
			}
			System.out.println();
			System.out.println("-------------");
		}
	}

}
