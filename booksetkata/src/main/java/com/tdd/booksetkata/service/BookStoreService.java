package com.tdd.booksetkata.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import com.tdd.booksetkata.model.Book;

@Service
public class BookStoreService {

	private Map<Book, Integer> bookCounts;

	public BookStoreService() {
		this.bookCounts = new HashMap<>();
	}

	public List<Book> fetchBooks() {
		return Arrays.asList(Book.values());
	}

	public double calculatePrice(List<Book> books) {

		double totalPrice = 0.0;
		for (Book book : books) {
			bookCounts.put(book, bookCounts.getOrDefault(book, 0) + 1);
		}

		int[] copyOfBookList = bookCounts.values().stream().mapToInt(Integer::intValue).toArray();

		while (Arrays.stream(copyOfBookList).sum() > 0) {
			int uniqueBooks = 0;
			for (int i = 0; i < copyOfBookList.length; i++) {
				if (copyOfBookList[i] > 0) {
					uniqueBooks++;
					copyOfBookList[i]--;
				}
			}

			if (uniqueBooks == 0) {
				break;
			}

			double discount = getDiscount(uniqueBooks);
			totalPrice += Book.PRICE * uniqueBooks * (1 - discount);
		}
		return totalPrice;
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
