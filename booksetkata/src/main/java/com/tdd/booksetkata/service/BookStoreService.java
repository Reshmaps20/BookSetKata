package com.tdd.booksetkata.service;

import java.util.Arrays;
import java.util.List;
import com.tdd.booksetkata.model.Book;

public class BookStoreService {

	public List<Book> fetchBooks() {
		return Arrays.asList(Book.values());
	}

}
