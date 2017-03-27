package com.profitbricks.sudoku.processor.main;

import com.profitbricks.sudoku.processor.ISudoku;
import com.profitbricks.sudoku.processor.MySudoku;
import com.profitbricks.sudoku.util.BoardUtil;

public class Execute {

	public static void main(String[] args) {
		
		int board[][] = 
			   {
			    {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 7, 6, 8},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
                };
		
		ISudoku sudoku = new MySudoku();

		
		if (sudoku.solve(board) == true)
			BoardUtil.printBoard(board);
		else
			System.out.format("No solution exists");
		
	}
	
	
	
}
