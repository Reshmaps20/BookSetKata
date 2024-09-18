package com.tdd.booksetkata.service;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import com.tdd.booksetkata.model.Book;

public class BookStoreServiceTest {

	@Test
	void testFetchBooks_ShouldFetchAllTheAvailableBooks_ReturnsBooksList() {

		BookStoreService bookStoreService = new BookStoreService();
		List<Book> books = bookStoreService.fetchBooks();
		assertEquals(5, books.size());
	}

}
