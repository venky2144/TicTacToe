package com.bnp.kata.tictactoe;

public class TicTacToe {

	Board board;

	public TicTacToe() {
		board = new Board();
	}

	public void addPlayer(int row, int column) throws Exception {

		if (!board.validateuserInputData(row, column)) {
			throw new Exception("The given  input data is not in the range of 0 to 2 ");
		}

		if (!board.checkSelectedPositionIsEmpty(row, column)) {
			throw new Exception("The given position is occupied by another player");
		}
		board.addPlayer(row, column);
	}

	public char getPlayerPosition(int row, int column) {
		return board.getPosition(row, column);
	}

}
