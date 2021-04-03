package com.bnp.kata.tictactoe;

public class TicTacToe {

	private static final String GAME_DRAW = "The Game is Draw";
	private static final String GAME_CONTINOUS = "Game Continues";
	private static final String GAME_WINNER = " is Winner of he Game";
	private static final String INPUT_DATA_EXCEPTION = "The given  input data is not in the range of 0 to 2 ";
	private static final String POSITION_NOT_EMPTY_EXCEPTION = "The given position is occupied by another player";

	Board board;

	public TicTacToe() {
		board = new Board();
	}

	public String addPlayer(int row, int column) throws Exception {

		if (!board.validateuserInputData(row, column)) {
			throw new Exception(INPUT_DATA_EXCEPTION);
		}

		if (!board.checkSelectedPositionIsEmpty(row, column)) {
			throw new Exception(POSITION_NOT_EMPTY_EXCEPTION);
		}
		board.addPlayer(row, column);
		String gameResult;
		if (checkWinner()) {
			String winner = String.valueOf(board.getCurrentPlayer());
			gameResult = winner + GAME_WINNER;
		} else if (isGameDraw()) {
			gameResult = GAME_DRAW;
		} else {
			gameResult = GAME_CONTINOUS;
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
