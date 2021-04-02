package com.bnp.kata.tictactoe;

public class TicTacToe {
	private char[][] board = new char[3][3];
	private char currentPlayer;

	public void play(int row, int column, char inputChar) {
		board[row][column] = inputChar;

	}

	public void addPlayer(int row, int column) {

		currentPlayer = getNextPlayer();
		board[row][column] = currentPlayer;
	}

	public char getNextPlayer() {
		if ('X' == currentPlayer) {

			return 'O';
		} else {
			return 'X';
		}
	}

	public char getPosition(int row, int column) {
		return board[row][column];
	}

	public char getCurrentPlayer() {
		return currentPlayer;
	}
}
