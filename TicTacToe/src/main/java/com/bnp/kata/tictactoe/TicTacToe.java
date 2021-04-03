package com.bnp.kata.tictactoe;

public class TicTacToe {

	Board board;

	public TicTacToe() {
		board = new Board();
	}

	public void addPlayer(int row, int column) {
		board.addPlayer(row, column);
	}

	public char getPlayerPosition(int row, int column) {
		return board.getPosition(row, column);
	}

}
