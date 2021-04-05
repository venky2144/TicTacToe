package com.bnpp.kata.tictactoe.bean;

import java.util.logging.Logger;

import org.springframework.stereotype.Component;

@Component
public class Board {

	private static final int INDEX_ZERO = 0;
	private static final int INDEX_ONE = 1;
	private static final int INDEX_TWO = 2;
	private static final int INDEX_THREE = 3;
	private char[][] gameBoard = new char[INDEX_THREE][INDEX_THREE];
	private static final char FIRST_PLAYER = 'X';
	private static final char SECOND_PLAYER = 'O';
	private char currentPlayer;
	private static final Logger logger = Logger.getLogger(Board.class.getName());


	public void addPlayer(int row, int column) {

		currentPlayer = getNextPlayer();
		gameBoard[row][column] = currentPlayer;
	}

	public char getNextPlayer() {

		return (FIRST_PLAYER == currentPlayer) ? SECOND_PLAYER : FIRST_PLAYER;

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
		if (row > INDEX_TWO || row < INDEX_ZERO || column > INDEX_TWO || column < INDEX_ZERO) {
			result = false;
		} else {

			result = true;
		}
		return result;

	}

	public boolean checkRowsForWin() {

		for (int row = INDEX_ZERO; row < INDEX_THREE; row++) {

			if ((gameBoard[row][INDEX_ZERO] != '\0') && (gameBoard[row][INDEX_ZERO] == gameBoard[row][INDEX_ONE]) && (gameBoard[row][INDEX_ONE] == gameBoard[row][INDEX_TWO])) {
				if (checkRowColumnContent(gameBoard[row][INDEX_ZERO], gameBoard[row][INDEX_ONE],
						gameBoard[row][INDEX_TWO])) {
					return true;
				}
			}
		}
		return false;

	}

	public boolean checkColumnsForWin() {

		for (int column = INDEX_ZERO; column < INDEX_THREE; column++) {
			if ((gameBoard[column][INDEX_ZERO] != '\0') && (gameBoard[INDEX_ZERO][column] == gameBoard[INDEX_ONE][column]) && (gameBoard[INDEX_ONE][column] == gameBoard[INDEX_TWO][column])) {
				if (checkRowColumnContent(gameBoard[INDEX_ZERO][column], gameBoard[INDEX_ONE][column],
						gameBoard[INDEX_TWO][column])) {
					return true;
				}
			}
		}
		return false;

	}

	public boolean checkDiagonalsForWin() {
		boolean isTrue = true;
		return ((checkRowColumnContent(gameBoard[INDEX_ZERO][INDEX_ZERO], gameBoard[INDEX_ONE][INDEX_ONE], gameBoard[INDEX_TWO][INDEX_TWO]) == isTrue)
				|| (checkRowColumnContent(gameBoard[INDEX_ZERO][INDEX_TWO], gameBoard[INDEX_ONE][INDEX_ONE], gameBoard[INDEX_TWO][INDEX_ZERO]) == isTrue));
	}

	private boolean checkRowColumnContent(char c1, char c2, char c3) {

		return ((c1 != '\0') && (c1 == c2) && (c2 == c3));

	}

	public boolean checkIfBoardFullyOccupied() {
		boolean isFull = true;
		for (int i = INDEX_ZERO; i < INDEX_THREE; i++) {
			for (int j = INDEX_ZERO; j < INDEX_THREE; j++) {
				if (gameBoard[i][j] == '\0') {
					isFull = false;
				}
			}
		}
		return isFull;
	}

	public void printBoard() {

		StringBuilder builder = new StringBuilder();
		builder.append("\n-------------\n");
		for (int row = INDEX_ZERO; row < INDEX_THREE; row++) {
			builder.append("| ");
			for (int column = INDEX_ZERO; column < INDEX_THREE; column++) {
				builder.append(gameBoard[row][column] + " | ");
			}
			builder.append("\n");
			builder.append("-------------\n");
			logger.info(builder.toString());
		}
	}

}
