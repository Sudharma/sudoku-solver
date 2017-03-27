package com.profitbricks.sudoku.processor;

import java.util.stream.IntStream;

/**
 * Implementing the Sudoku class
 * @author sudharmapuranik
 *
 */
public class MySudoku implements ISudoku {

	/**Sudo Board size N xN */
	private static final int N = 9;
    
	/** state of row and column for unoccupied*/
	private int globalRow = 0, globalCol = 0;

	@Override
	public boolean checkIfUnallocated(int[][] board, int row, int col) {

		for (row = 0; row < N; row++)
			for (col = 0; col < N; col++)
				if (board[row][col] == 0) {
					globalRow = row;
					globalCol = col;
					return true;
				}
		return false;

	}

	@Override
	public boolean isSafePosition(int[][] board, int row, int column, int num) {

		return !isUsedInRow(board, row, num) && !isUsedInCol(board, column, num)
				&& !isUsedInBox(board, row - row % 3, column - column % 3, num);
	}

	@Override
	public boolean solve(int[][] board) {

		
		int row = 0 , column = 0;

		// exit point
		if (!checkIfUnallocated(board, row, column))
			return true; 
		
		 row = globalRow; column = globalCol;
		 
		// using digits 1 to 9
		for (int num = 1; num <= N; num++) {
			
			if (isSafePosition(board, row, column, num)) {
				// assign temporarily
				board[row][column] = num;

				// recursive check with back tracking
				if (solve(board))
					return true;

				// if comes out then its reset to 0
				board[row][column] = 0;
			}
		}
		return false; 

	}

	
	private boolean isUsedInRow(int board[][], int row, int num) {
		return IntStream.range(0, N - 1).anyMatch(col -> board[row][col] == num);
		
	}

	
	private boolean isUsedInCol(int board[][], int col, int num) {
		return IntStream.range(0, N - 1).anyMatch(r -> board[r][col] == num);
	}

	private boolean isUsedInBox(int board[][], int indexRow, int indexCol, int num) {
		for (int row = 0; row < 3; row++)
			for (int col = 0; col < 3; col++)
				if (board[row + indexRow][col + indexCol] == num)
					return true;
		return false;
	}
}
