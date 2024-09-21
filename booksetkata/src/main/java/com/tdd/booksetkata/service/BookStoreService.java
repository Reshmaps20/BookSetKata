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

		long uniqueBookCount = books.stream().distinct().count();
		double discount = getDiscount(uniqueBookCount);
		return books.size() * Book.PRICE * (1 - discount);
	}

	private double getDiscount(long uniqueBookCount) {

		if (uniqueBookCount == 3) {
			return 0.10;
		} else if (uniqueBookCount == 2) {
			return 0.05;
		} else {
			return 0.0;
		}
	}

}
