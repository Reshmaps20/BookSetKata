package com.tdd.booksetkata.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.tdd.booksetkata.model.Book;

public class BookStoreServiceTest {

	BookStoreService bookStoreService;

	@BeforeEach
	public void setup() {
		bookStoreService = new BookStoreService();
	}

	@Test
	void testFetchBooks_ShouldFetchAllTheAvailableBooks_ReturnsBooksList() {

		List<Book> books = bookStoreService.fetchBooks();
		assertEquals(5, books.size());
	}

	@Test
	public void testCalculatePrice_CalculatePriceForSingleBookPurchase_ReturnsPriceOfSingleBook() {

		List<Book> books = Arrays.asList(Book.CLEAN_CODE);
		double price = bookStoreService.calculatePrice(books);
		assertEquals(50.0, price);
	}

	@Test
	public void testCalculatePrice_TwoDifferentBookPurchaseShouldGive5PercentDiscount_RetrunsTotalPrice() {

		List<Book> books = Arrays.asList(Book.CLEAN_CODE, Book.CLEAN_CODER);
		double price = bookStoreService.calculatePrice(books);
		assertEquals(95.0, price);
	}

	@Test
	public void testCalculatePrice_ThreeDifferentBookPurchaseShouldGive10PercentDiscount_RetrunsTotalPrice() {

		List<Book> books = Arrays.asList(Book.CLEAN_CODE, Book.CLEAN_CODER, Book.CLEAN_ARCHITECTURE);
		double price = bookStoreService.calculatePrice(books);
		assertEquals(135.0, price);
	}
	
	@Test
	public void testCalculatePrice_ThreeDifferentBookWithMutlipleCopyOfFirstTwoBook_RetrunsMinimumTotalPrice() {

		List<Book> books = Arrays.asList(Book.CLEAN_CODE, Book.CLEAN_CODE, Book.CLEAN_CODER, Book.CLEAN_CODER, Book.CLEAN_ARCHITECTURE);
		double price = bookStoreService.calculatePrice(books);
		assertEquals(230.0, price);
	}

}
