package com.bnp.kata.tictactoe;

public class TicTacToe {
	private static final char THREE = 3;
	private static final char PLAYER_X = 'X';
	private static final char PLAYER_O = 'O';
	private char[][] board = new char[THREE][THREE];
	private char currentPlayer;
    
	public void play(int row, int column, char inputChar) {
		board[row][column] = inputChar;

	}

	public void addPlayer(int row, int column) {

		currentPlayer = getNextPlayer();
		board[row][column] = currentPlayer;
	}

	public char getNextPlayer() {
		if (PLAYER_X == currentPlayer) {

			return PLAYER_O;
		} else {
			return PLAYER_X;
		}
	}

	public char getPosition(int row, int column) {
		return board[row][column];
	}

	public char getCurrentPlayer() {
		return currentPlayer;
	}
	public boolean checkSelectedPositionIsEmpty(int row,int column) {
		return board[row][column] == '\0';
	}
}
