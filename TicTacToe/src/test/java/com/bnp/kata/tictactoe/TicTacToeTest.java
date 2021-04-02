package com.bnp.kata.tictactoe;

import static org.junit.Assert.assertThat;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

public class TicTacToeTest {
	@Test
	public void testPlayerPlaceXInBoard() {
		TicTacToe ticTac = new TicTacToe();
		ticTac.play(1, 1, 'X');

		assertThat(ticTac.getPosition(1, 1), CoreMatchers.is('X'));
	}

}
