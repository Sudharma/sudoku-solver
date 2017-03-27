package com.profitbricks.sudoku.controller;

import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.profitbricks.sudoku.processor.ISudoku;
import com.profitbricks.sudoku.processor.MySudoku;
import com.profitbricks.sudoku.rest.model.Error;
import com.profitbricks.sudoku.rest.model.Solution;
import com.profitbricks.sudoku.util.BoardUtil;

@Path("/solve")
public class SudokuController {
	
	private static Logger log = Logger.getLogger(SudokuController.class.getName());

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response solve(@QueryParam("input") String input) {
		
		log.info("Solving sudoku");

		ISudoku sudoku = new MySudoku();
		int[][] board = null;
		try {
			board = BoardUtil.convertInputToBoard(input);
		} catch (Exception e) {
			 return Response.status(Status.BAD_REQUEST).entity(new Error(e.getMessage())).build();
			
		}

		if (sudoku.solve(board) == true) {
			String result = BoardUtil.convertBoardToOutput(board);
			return Response.status(Status.ACCEPTED).entity(new Solution(result)).build();
		} else
			return Response.status(Status.BAD_REQUEST).entity(new Error()).build();


	}

}
