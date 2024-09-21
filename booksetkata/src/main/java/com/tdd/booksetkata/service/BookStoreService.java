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

	public double calculatePrice(List<Book> books) {

		double discount = 0.0;
		long uniqueBookCount = books.stream().distinct().count();
		if (uniqueBookCount == 2) {
			discount = 0.05;
		}
		return books.size() * Book.PRICE * (1 - discount);
	}

}
