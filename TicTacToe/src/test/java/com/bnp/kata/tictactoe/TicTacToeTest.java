package com.bnp.kata.tictactoe;

import static org.junit.Assert.assertThat;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

public class TicTacToeTest {

	TicTacToe ticTac;
	Board board;

	@Before
	public void setUp() {
		ticTac = new TicTacToe();
		board=new Board();
		
	}

	@Test
	public void playerPlaceXInBoard() throws Exception {

		ticTac.addPlayer(1, 1);

		assertThat(ticTac.getPlayerPosition(1, 1), CoreMatchers.is('X'));
	}

	@Test
	public void playersShouldPlayAlternatively() {

		board.addPlayer(0, 0);
		assertThat(board.getCurrentPlayer(), CoreMatchers.is('X'));
		board.addPlayer(1, 1);
		assertThat(board.getCurrentPlayer(), CoreMatchers.is('O'));
	}

	@Test
	public void shouldReturnTrueWhenSelectedPositionisEmptyAndNotOccupiedByAnyPlayer() {

		assertThat(board.checkSelectedPositionIsEmpty(0, 0), CoreMatchers.is(true));
	}

	@Test(expected = Exception.class)
	public void shouldThroughExceptionWhenUserTryToFillAlreadyFilledPosition() throws Exception {

		ticTac.addPlayer(2, 0);
		ticTac.addPlayer(2, 0);

	}

	@Test
	public void shouldReturnTrueWhenThePlayerGivenCorrectInputData() {

		assertThat(board.validateuserInputData(2, 0), CoreMatchers.is(true));

	}

	@Test(expected = Exception.class)
	public void shouldReturnExceptionWhenThePlayerGivenInCorrectInputData() throws Exception {
		ticTac.addPlayer(2, 0);
		ticTac.addPlayer(3, 0);

	}

	@Test
	public void shouldReturnTrueIfAnyHorizontalRowsAreSame() throws Exception {

		board.addPlayer(0, 0);
		board.addPlayer(2, 1);
		board.addPlayer(0, 1);
		board.addPlayer(1, 2);
		board.addPlayer(0, 2);

		assertThat(board.checkRowsForWin(), CoreMatchers.is(true));

	}

	@Test
	public void shouldReturnTrueIfAnyVerticalRowsAreSame() throws Exception {

		board.addPlayer(0, 0);
		board.addPlayer(2, 2);
		board.addPlayer(1, 0);
		board.addPlayer(1, 2);
		board.addPlayer(2, 0);

		assertThat(board.checkColumnsForWin(), CoreMatchers.is(true));

	}

	@Test
	public void shouldReturnTrueIfAnyDiagonalsPositionsAreSame() throws Exception {
		Board leftDiagonalCheck = new Board();
		leftDiagonalCheck.addPlayer(0, 0);
		leftDiagonalCheck.addPlayer(1, 2);
		leftDiagonalCheck.addPlayer(1, 1);
		leftDiagonalCheck.addPlayer(2, 1);
		leftDiagonalCheck.addPlayer(2, 2);
		assertThat(leftDiagonalCheck.checkDiagonalsForWin(), CoreMatchers.is(true));

		Board rightDiagonalCheck = new Board();
		rightDiagonalCheck.addPlayer(0, 2);
		rightDiagonalCheck.addPlayer(0, 0);
		rightDiagonalCheck.addPlayer(1, 1);
		rightDiagonalCheck.addPlayer(1, 2);
		rightDiagonalCheck.addPlayer(2, 0);
		assertThat(rightDiagonalCheck.checkDiagonalsForWin(), CoreMatchers.is(true));

	}
	
	@Test
	public void checkIsBoardFullyOccupied() {

		board.addPlayer(1, 1);
		board.addPlayer(0, 2);
		board.addPlayer(1, 2);
		board.addPlayer(1, 0);
		board.addPlayer(0, 0);
		board.addPlayer(2, 2);
		board.addPlayer(2, 1);
		board.addPlayer(0, 1);
		board.addPlayer(2, 0);
		assertThat(board.checkIfBoardFullyOccupied(), CoreMatchers.is(true));

	}
	
	@Test
	public void shouldDeclareWinnerIfAnyHorizontalMatchOccurOnTheBoard() throws Exception {
		ticTac.addPlayer(0, 0);
		ticTac.addPlayer(2, 1);
		ticTac.addPlayer(0, 1);
		ticTac.addPlayer(1, 2);
		assertThat(ticTac.addPlayer(0, 2), CoreMatchers.is("X is Winner of the Game"));

	}
	
	@Test
	public void shouldDeclareWinnerIfAnyVerticalMatchOccurOnTheBoard() throws Exception {
		ticTac.addPlayer(0, 0);
		ticTac.addPlayer(1, 2);
		ticTac.addPlayer(1, 0);
		ticTac.addPlayer(0, 2);
		assertThat(ticTac.addPlayer(2, 0), CoreMatchers.is("X is Winner of the Game"));

	}

}

