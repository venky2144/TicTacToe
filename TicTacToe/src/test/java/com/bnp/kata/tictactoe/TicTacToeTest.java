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
	public void playerPlaceXInBoard() {

		ticTac.play(1, 1, 'X');

		assertThat(ticTac.getPosition(1, 1), CoreMatchers.is('X'));
	}

	@Test
	public void playersShouldPlayAlternatively() {

		ticTac.addPlayer(0, 0);

		assertThat(ticTac.getCurrentPlayer(), CoreMatchers.is('X'));

		ticTac.addPlayer(1, 1);

		assertThat(ticTac.getCurrentPlayer(), CoreMatchers.is('O'));
	}

	@Test
	public void shouldReturnTrueWhenSelectedPositionisEmptyAndNotOccupiedByAnyPlayer() {

		assertThat(ticTac.checkSelectedPositionIsEmpty(0, 0), CoreMatchers.is(true));
	}
}
