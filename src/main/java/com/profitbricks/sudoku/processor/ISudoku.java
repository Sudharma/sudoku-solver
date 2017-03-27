package com.profitbricks.sudoku.processor;

public interface ISudoku {

	boolean checkIfUnallocated(int[][] board, int row, int column);

	boolean isSafePosition(int[][] board, int row, int column, int num);

	boolean solve(int[][] board);

}
