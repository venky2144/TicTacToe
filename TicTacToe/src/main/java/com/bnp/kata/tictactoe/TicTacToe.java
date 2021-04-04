package com.bnp.kata.tictactoe;

import com.bnp.kata.tictactoe.exception.PositionNotAvailableException;
import com.bnp.kata.tictactoe.exception.PositionOutOfRangeException;

public class TicTacToe {

	private static final String GAME_DRAW = "The Game is Draw";
	private static final String GAME_CONTINOUS = "Game Continues";
	private static final String GAME_WINNER = "The Winner of the Game is %s";
	private static final String INPUT_DATA_EXCEPTION = "The given  input data is not in the range of 0 to 2 ";
	private static final String POSITION_NOT_EMPTY_EXCEPTION = "The given position is occupied by another player";

	Board board;

	public TicTacToe() {
		board = new Board();
	}

	public String addPlayer(int row, int column) throws PositionOutOfRangeException,PositionNotAvailableException {

		if (!board.validateUserInputData(row, column)) {
			throw new PositionOutOfRangeException(INPUT_DATA_EXCEPTION);
		}

		if (!board.checkSelectedPositionIsEmpty(row, column)) {
			throw new PositionNotAvailableException(POSITION_NOT_EMPTY_EXCEPTION);
		}
		board.addPlayer(row, column);
		String gameResult;
		if (checkWinner()) {
			String winner = String.valueOf(board.getCurrentPlayer());
			gameResult = String.format(GAME_WINNER,winner);
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
