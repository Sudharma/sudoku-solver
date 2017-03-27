package com.profitbricks.sudoku.rest.model;

public class Solution extends Result{
	
	public Solution(String solution) {
		super();
		this.solution = solution;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	private String solution;

	
	

}
