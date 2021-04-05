package com.bnp.kata.tictactoe;

import static org.junit.Assert.assertThat;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import com.bnpp.kata.tictactoe.bean.Board;
import com.bnpp.kata.tictactoe.bean.TicTacToe;
import com.bnpp.kata.tictactoe.exception.PositionNotAvailableException;
import com.bnpp.kata.tictactoe.exception.PositionOutOfRangeException;

public class TicTacToeTest {

	private static final int INDEX_ZERO = 0;
	private static final int INDEX_ONE = 1;
	private static final int INDEX_TWO = 2;
	private static final int INDEX_THREE = 3;
	private static final String GAME_DRAW = "The Game is Draw";
	private static final String PLAYER_X = "X";
	private static final String PLAYER_O = "O";

	TicTacToe ticTacToe;
	Board board;

	@Before
	public void setUp() {
		ticTacToe = new TicTacToe();
		board = new Board();
	}

	@Test
	public void playerPlaceXInBoard() throws Exception {
		ticTacToe.addPlayer(INDEX_ONE, INDEX_ONE);
		assertThat(ticTacToe.getPlayerPosition(INDEX_ONE, INDEX_ONE), CoreMatchers.is('X'));
	}

	@Test
	public void playersShouldPlayAlternatively() {
		board.addPlayer(INDEX_ZERO, INDEX_ZERO);
		assertThat(board.getCurrentPlayer(), CoreMatchers.is('X'));
		board.addPlayer(INDEX_ONE, INDEX_ONE);
		assertThat(board.getCurrentPlayer(), CoreMatchers.is('O'));
	}

	@Test
	public void shouldReturnTrueWhenSelectedPositionisEmptyAndNotOccupiedByAnyPlayer() {
		assertThat(board.checkSelectedPositionIsEmpty(INDEX_ZERO, INDEX_ZERO), CoreMatchers.is(true));
	}

	@Test(expected = PositionNotAvailableException.class)
	public void shouldThroughExceptionWhenUserTryToFillAlreadyFilledPosition()
			throws PositionNotAvailableException, PositionOutOfRangeException {
		ticTacToe.addPlayer(INDEX_TWO, INDEX_ZERO);
		ticTacToe.addPlayer(INDEX_TWO, INDEX_ZERO);
	}

	@Test
	public void shouldReturnTrueWhenThePlayerGivenCorrectInputData() {
		assertThat(board.validateUserInputData(INDEX_TWO, INDEX_ZERO), CoreMatchers.is(true));
	}

	@Test(expected = PositionOutOfRangeException.class)
	public void shouldReturnExceptionWhenThePlayerGivenInCorrectInputData()
			throws PositionOutOfRangeException, PositionNotAvailableException {
		ticTacToe.addPlayer(INDEX_TWO, INDEX_ZERO);
		ticTacToe.addPlayer(INDEX_THREE, INDEX_ZERO);
	}

	@Test
	public void shouldReturnTrueIfAnyHorizontalRowsAreSame() throws Exception {
		board.addPlayer(INDEX_ZERO, INDEX_ZERO);
		board.addPlayer(INDEX_TWO, INDEX_ONE);
		board.addPlayer(INDEX_ZERO, INDEX_ONE);
		board.addPlayer(INDEX_ONE, INDEX_TWO);
		board.addPlayer(INDEX_ZERO, INDEX_TWO);
		assertThat(board.checkRowsForWin(), CoreMatchers.is(true));
	}

	@Test
	public void shouldReturnTrueIfAnyVerticalRowsAreSame() throws Exception {
		board.addPlayer(INDEX_ZERO, INDEX_ZERO);
		board.addPlayer(INDEX_TWO, INDEX_TWO);
		board.addPlayer(INDEX_ONE, INDEX_ZERO);
		board.addPlayer(INDEX_ONE, INDEX_TWO);
		board.addPlayer(INDEX_TWO, INDEX_ZERO);
		assertThat(board.checkColumnsForWin(), CoreMatchers.is(true));
	}

	@Test
	public void shouldReturnTrueIfLeftDiagonalsPositionsAreSame() throws Exception {
		board.addPlayer(INDEX_ZERO, INDEX_ZERO);
		board.addPlayer(INDEX_ONE, INDEX_TWO);
		board.addPlayer(INDEX_ONE, INDEX_ONE);
		board.addPlayer(INDEX_TWO, INDEX_ONE);
		board.addPlayer(INDEX_TWO, INDEX_TWO);
		assertThat(board.checkDiagonalsForWin(), CoreMatchers.is(true));
	}

	@Test
	public void shouldReturnTrueIfRightDiagonalsPositionsAreSame() throws Exception {
		board.addPlayer(INDEX_ZERO, INDEX_TWO);
		board.addPlayer(INDEX_ZERO, INDEX_ZERO);
		board.addPlayer(INDEX_ONE, INDEX_ONE);
		board.addPlayer(INDEX_ONE, INDEX_TWO);
		board.addPlayer(INDEX_TWO, INDEX_ZERO);
		assertThat(board.checkDiagonalsForWin(), CoreMatchers.is(true));
	}

	@Test
	public void checkIsBoardFullyOccupied() {
		board.addPlayer(INDEX_ONE, INDEX_ONE);
		board.addPlayer(INDEX_ZERO, INDEX_TWO);
		board.addPlayer(INDEX_ONE, INDEX_TWO);
		board.addPlayer(INDEX_ONE, INDEX_ZERO);
		board.addPlayer(INDEX_ZERO, INDEX_ZERO);
		board.addPlayer(INDEX_TWO, INDEX_TWO);
		board.addPlayer(INDEX_TWO, INDEX_ONE);
		board.addPlayer(INDEX_ZERO, INDEX_ONE);
		board.addPlayer(INDEX_TWO, INDEX_ZERO);
		assertThat(board.checkIfBoardFullyOccupied(), CoreMatchers.is(true));
	}

	@Test
	public void shouldDeclareWinnerIfAnyHorizontalMatchOccurOnTheBoard() throws Exception {
		ticTacToe.addPlayer(INDEX_ZERO, INDEX_ZERO);
		ticTacToe.addPlayer(INDEX_TWO, INDEX_ONE);
		ticTacToe.addPlayer(INDEX_ZERO, INDEX_ONE);
		ticTacToe.addPlayer(INDEX_ONE, INDEX_TWO);
		assertThat(ticTacToe.addPlayer(INDEX_ZERO, INDEX_TWO), CoreMatchers.is(PLAYER_X));
	}

	@Test
	public void shouldDeclareWinnerIfAnyVerticalMatchOccurOnTheBoard() throws Exception {
		ticTacToe.addPlayer(INDEX_ZERO, INDEX_ZERO);
		ticTacToe.addPlayer(INDEX_ONE, INDEX_TWO);
		ticTacToe.addPlayer(INDEX_ONE, INDEX_ZERO);
		ticTacToe.addPlayer(INDEX_ZERO, INDEX_TWO);
		assertThat(ticTacToe.addPlayer(INDEX_TWO, INDEX_ZERO), CoreMatchers.is(PLAYER_X));
	}

	@Test
	public void shouldDeclareWinnerIfAnyDiagonalMatchOccurOnTheBoard() throws Exception {
		ticTacToe.addPlayer(INDEX_ZERO, INDEX_ZERO);
		ticTacToe.addPlayer(INDEX_TWO, INDEX_ZERO);
		ticTacToe.addPlayer(INDEX_ZERO, INDEX_ONE);
		ticTacToe.addPlayer(INDEX_ONE, INDEX_ONE);
		ticTacToe.addPlayer(INDEX_ONE, INDEX_TWO);
		assertThat(ticTacToe.addPlayer(INDEX_ZERO, INDEX_TWO), CoreMatchers.is(PLAYER_O));
	}

	@Test
	public void declareGameDrawWhenBoardIsFilledAndthereIsNoWinConditions() throws Exception {
		ticTacToe.addPlayer(INDEX_ONE, INDEX_ONE);
		ticTacToe.addPlayer(INDEX_ZERO, INDEX_TWO);
		ticTacToe.addPlayer(INDEX_ONE, INDEX_TWO);
		ticTacToe.addPlayer(INDEX_ONE, INDEX_ZERO);
		ticTacToe.addPlayer(INDEX_ZERO, INDEX_ZERO);
		ticTacToe.addPlayer(INDEX_TWO, INDEX_TWO);
		ticTacToe.addPlayer(INDEX_TWO, INDEX_ONE);
		ticTacToe.addPlayer(INDEX_ZERO, INDEX_ONE);
		assertThat(ticTacToe.addPlayer(INDEX_TWO, INDEX_ZERO), CoreMatchers.is(GAME_DRAW));
	}

	@Test
	public void checkPrintBoard() throws Exception {
		board.addPlayer(INDEX_ONE, INDEX_ONE);
		board.addPlayer(INDEX_ZERO, INDEX_TWO);
		board.addPlayer(INDEX_ONE, INDEX_TWO);
		board.printBoard();
	}
}
