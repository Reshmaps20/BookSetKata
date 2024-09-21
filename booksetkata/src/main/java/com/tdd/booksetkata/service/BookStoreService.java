package com.tdd.booksetkata.service;

import java.util.ArrayList;
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

		addBook(books);

		List<Double> possiblePrices = new ArrayList<>();
		int[] copyOfBookList = bookCounts.values().stream().mapToInt(Integer::intValue).toArray();

		double totalPriceFor5Books = calculateCombinationPrice(copyOfBookList, 5);
		possiblePrices.add(totalPriceFor5Books);

		double totalPriceFor4Books = calculateCombinationPrice(copyOfBookList, 4);
		possiblePrices.add(totalPriceFor4Books);

		double totalPriceFor3Books = calculateCombinationPrice(copyOfBookList, 3);
		possiblePrices.add(totalPriceFor3Books);

		return possiblePrices.stream().min(Double::compare).orElse(0.0);

	}

	private double calculateCombinationPrice(int[] book, int numberOfBooks) {

		int[] copyOfBookList = Arrays.copyOf(book, book.length);
		double totalPrice = 0.0;

		while (Arrays.stream(copyOfBookList).sum() > 0) {
			int uniqueBooks = 0;
			for (int i = 0; i < copyOfBookList.length; i++) {
				if (copyOfBookList[i] > 0 && uniqueBooks < numberOfBooks) {
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

	private void addBook(List<Book> books) {
		
		for (Book book : books) {
			bookCounts.put(book, bookCounts.getOrDefault(book, 0) + 1);
		}
	}

	private double getDiscount(int uniqueBookCount) {

		return switch (uniqueBookCount) {
			case 2 -> 0.05;
			case 3 -> 0.10;
			case 4 -> 0.20;
			case 5 -> 0.25;
			default -> 0.0;
		};
	}

}
