package com.bnp.kata.tictactoe;

public class TicTacToe {

	Board board;

	public TicTacToe() {
		board = new Board();
	}

	public String addPlayer(int row, int column) throws Exception {

		if (!board.validateuserInputData(row, column)) {
			throw new Exception("The given  input data is not in the range of 0 to 2 ");
		}

		if (!board.checkSelectedPositionIsEmpty(row, column)) {
			throw new Exception("The given position is occupied by another player");
		}
		board.addPlayer(row, column);
		String gameResult;
		if (checkWinner()) {
			String winner = String.valueOf(board.getCurrentPlayer());
			gameResult = winner + " is Winner of the Game";
		} else if (isGameDraw()) {
			gameResult = "The Game is Draw";
		} else {
			gameResult = "Game Continues";
		}
		return gameResult;
		
	}

	public char getPlayerPosition(int row, int column) {
		return board.getPosition(row, column);
	}

	public boolean checkWinner() {
		return board.checkColumnsForWin() || board.checkRowsForWin() || board.checkDiagonalsForWin();
	}

	public boolean isGameDraw() {
		return board.checkIfBoardFullyOccupied();
	}

}
