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

}
