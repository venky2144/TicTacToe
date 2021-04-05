package com.bnpp.kata.tictactoe.bean;

import java.util.Scanner;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bnpp.kata.tictactoe.exception.PositionNotAvailableException;
import com.bnpp.kata.tictactoe.exception.PositionOutOfRangeException;

@Component
public class TicTacToeMain {

	private static final String SUCCESS_MESSAGE = "Congratulations! ";
	private static final String SUCCESS_MESSAGE_EXTENSION = "'s have won! Thanks for playing.";
	private static final String ENTER_SLOT_FOR_PLYER_X = "Enter a slot number to place X in:";
	private static final String ENTER_SLOT_FOR_PLYER_O = "Enter a slot number to place O in:";
	private static final String INITIAL_RESULT_MESSAGE = "Game Started";
	private static final String GAME_CONTINUES = "Game Continues";
	private static final String PLAYER_X = "X";
	private static final String PLAYER_O = "O";

	private static final Logger logger = Logger.getLogger(TicTacToeMain.class.getName());

	@Autowired
	TicTacToe ticTacToe;

	public void playGame() throws PositionOutOfRangeException, PositionNotAvailableException {

		Scanner scanner = new Scanner(System.in);
		String result = INITIAL_RESULT_MESSAGE;

		do {
			logger.info(ENTER_SLOT_FOR_PLYER_X);
			String firstPlayer = scanner.next();
			String inputArray[] = firstPlayer.split(",");
			result = ticTacToe.addPlayer(Integer.parseInt(inputArray[0]), Integer.parseInt(inputArray[1]));
			ticTacToe.board.printBoard();

			if (result.equals(PLAYER_X) || result.equals(PLAYER_O)) {

				logger.info(SUCCESS_MESSAGE + result + SUCCESS_MESSAGE_EXTENSION);
				break;

			}

			logger.info(ENTER_SLOT_FOR_PLYER_O);
			String secondPlayer = scanner.next();
			String input[] = secondPlayer.split(",");
			result = ticTacToe.addPlayer(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
			ticTacToe.board.printBoard();

			if (result.equals(PLAYER_X) || result.equals(PLAYER_O)) {

				logger.info(SUCCESS_MESSAGE + result + SUCCESS_MESSAGE_EXTENSION);
				break;
			}

		} while (result.equals(GAME_CONTINUES));

	}

}
