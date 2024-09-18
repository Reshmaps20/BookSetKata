package com.tdd.booksetkata.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import com.tdd.booksetkata.model.Book;

@Service
public class BookStoreService {

	public List<Book> fetchBooks() {
		return Arrays.asList(Book.values());
	}

}
