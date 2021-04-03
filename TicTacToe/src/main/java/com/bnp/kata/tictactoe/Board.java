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

}
