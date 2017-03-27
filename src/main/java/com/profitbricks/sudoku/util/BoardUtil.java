package com.profitbricks.sudoku.util;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/***
 * Utility for any board related functionalities
 * @author sudharmapuranik
 *
 */
public class BoardUtil {

	public static int[][] convertInputToBoard(String input) throws Exception {

		int[][] board = new int[9][9];
		// prepare for the sudoku board from input parameters
		int[] array = Arrays.stream(input.replace("x", "0").split(",")).mapToInt(n -> Integer.parseInt(n)).toArray();
		validateInput(array);
		//convert prepared board to actually as indices
		for (int index = 0, i = 0, j = 0; j < 9 && index <= 80; index++, i++) {
			if (i == 0 || index % 9 != 0) {
				board[j][i] = array[index];
				continue;
			}
			index--;
			j++;
			i = -1;
		}
		return board;
	}

	public static String convertBoardToOutput(int[][] board) {
		return Stream.of(board).flatMapToInt(x -> Arrays.stream(x)).mapToObj(x -> String.valueOf(x))
				.collect(Collectors.joining(","));
	}

	private static void validateInput(int[] input) throws Exception {
		if (input.length != 81) {
			throw new Exception("Incorrect Input, Sudoku board cannot be formed");
		}
	}

	public static void printBoard(int board[][]) {

		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++)
				System.out.format("%2d", board[row][col]);
			System.out.format("\n");
		}
	}

	/**
	 * for Testing only
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		String input = "x,x,x,2,6,x,7,x,1,6,8,x,x,7,x,x,9,x,1,9,x,x,x,4,5,x,x,8,2,x,1,x,x,x,4,x,x,x,4,6,x,2,9,x,x,x,5,x,x,x,3,x,2,8,x,x,9,3,x,x,x,7,4,x,4,8,9,5,x,x,3,6,7,x,3,x,1,8,x,x,x";
		BoardUtil.convertInputToBoard(input);
	}
}
