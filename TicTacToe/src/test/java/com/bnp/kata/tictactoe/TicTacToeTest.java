package com.bnp.kata.tictactoe;

import static org.junit.Assert.assertThat;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

public class TicTacToeTest {

	TicTacToe ticTac;

	@Before
	public void setUp() {
		ticTac = new TicTacToe();
	}

	@Test
	public void playerPlaceXInBoard() throws Exception {

		ticTac.addPlayer(1, 1);

		assertThat(ticTac.getPlayerPosition(1, 1), CoreMatchers.is('X'));
	}

	@Test
	public void playersShouldPlayAlternatively() {

		Board board = new Board();
		board.addPlayer(0, 0);

		assertThat(board.getCurrentPlayer(), CoreMatchers.is('X'));

		board.addPlayer(1, 1);

		assertThat(board.getCurrentPlayer(), CoreMatchers.is('O'));
	}

	@Test
	public void shouldReturnTrueWhenSelectedPositionisEmptyAndNotOccupiedByAnyPlayer() {
		Board board = new Board();
		assertThat(board.checkSelectedPositionIsEmpty(0, 0), CoreMatchers.is(true));
	}

	@Test(expected = Exception.class)
	public void shouldThroughExceptionWhenUserTryToFillAlreadyFilledPosition() throws Exception {

		ticTac.addPlayer(2, 0);
		ticTac.addPlayer(2, 0);

	}

	@Test
	public void shouldReturnTrueWhenThePlayerGivenCorrectInputData() {
		Board board = new Board();
		assertThat(board.validateuserInputData(2, 0), CoreMatchers.is(true));

	}

	@Test(expected = Exception.class)
	public void shouldReturnExceptionWhenThePlayerGivenInCorrectInputData() throws Exception {
		ticTac.addPlayer(2, 0);
		ticTac.addPlayer(3, 0);

	}

	@Test
	public void shouldReturnWinnerNameIfAnyHorizontalRowsIsSame() {
		Board board = new Board();
		board.addPlayer(0, 0);
		board.addPlayer(2, 1);
		board.addPlayer(0, 1);
		board.addPlayer(1, 2);
		board.addPlayer(0, 2);

		assertThat(board.checkRowsForWin(), CoreMatchers.is(true));

	}
}
