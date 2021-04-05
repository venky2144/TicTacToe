package com.bnpp.kata.tictactoe.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.bnpp.kata.tictactoe.bean.TicTacToeMain;
import com.bnpp.kata.tictactoe.exception.PositionNotAvailableException;
import com.bnpp.kata.tictactoe.exception.PositionOutOfRangeException;
@Configuration
@ComponentScan({ "com.bnpp.kata.tictactoe.bean"})
public class SpringConfigMain {

	public static void main(String a[]) throws PositionOutOfRangeException, PositionNotAvailableException {

		ApplicationContext appContext = new AnnotationConfigApplicationContext(SpringConfigMain.class);
		TicTacToeMain ticTacToe = (TicTacToeMain) appContext.getBean("ticTacToeMain");
		ticTacToe.playGame();

	}
}
