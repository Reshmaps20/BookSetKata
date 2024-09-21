package com.tdd.booksetkata.model;

public enum Book {

	CLEAN_CODE("Clean Code"), 
	CLEAN_CODER("The Clean Coder"), 
	CLEAN_ARCHITECTURE("Clean Architecture"),
	TDD_BY_EXAMPLE("Test Driven Development by Example"),
	WORKING_WITH_LEGACY_CODE("Working Effectively with Legacy Code");

	private final String title;
	public static final double PRICE = 50.0;

	Book(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	 public static Book mapToBook(String title) {
	        return Book.valueOf(title);
	  }
}
