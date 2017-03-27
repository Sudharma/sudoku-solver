package com.profitbricks.sudoku.rest.model;

public class Error extends Result {

	private String error = "cannot be completed";

	public Error(String error) {
		super();
		this.error = error;
	}

	public Error() {
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
