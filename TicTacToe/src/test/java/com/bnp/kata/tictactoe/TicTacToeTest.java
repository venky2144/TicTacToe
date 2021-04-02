package com.bnp.kata.tictactoe;

import static org.junit.Assert.assertThat;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

public class TicTacToeTest {
	@Test
	public void playerPlaceXInBoard() {
		TicTacToe ticTac = new TicTacToe();
		ticTac.play(1, 1, 'X');

		assertThat(ticTac.getPosition(1, 1), CoreMatchers.is('X'));
	}

	@Test
	public void playersShouldPlayAlternatively() {
		TicTacToe ticTac = new TicTacToe();

		ticTac.addPlayer(0, 0);

		assertThat(ticTac.getCurrentPlayer(), CoreMatchers.is('X'));

		ticTac.addPlayer(1, 1);

		assertThat(ticTac.getCurrentPlayer(), CoreMatchers.is('O'));
	}

}
