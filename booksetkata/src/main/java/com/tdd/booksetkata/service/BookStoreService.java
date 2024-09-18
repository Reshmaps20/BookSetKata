package com.tdd.booksetkata.service;

import java.util.Arrays;
import java.util.List;

public class BookStoreService {

	private final List<String> books = Arrays.asList("Clean Code", "The Clean Coder", "Clean Architecture",
			"Test Driven Development by Example", "Working Effectively with Legacy Code");

	public List<String> fetchBooks() {
		return books;
	}

}
