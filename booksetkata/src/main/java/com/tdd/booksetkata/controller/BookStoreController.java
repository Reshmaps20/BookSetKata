package com.tdd.booksetkata.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tdd.booksetkata.model.Book;
import com.tdd.booksetkata.service.BookStoreService;

@RestController
@RequestMapping("/bookstore")
public class BookStoreController {

	@Autowired
	BookStoreService bookStoreService;

	@GetMapping("/fetchbooks")
	public List<Book> fetchAvailableBooks() {
		return bookStoreService.fetchBooks();
	}

	@PostMapping("/calculateprice")
	public double calculatePrice(@RequestBody List<String> request) {
		List<Book> books = request.stream()
								.map(Book::mapToBook)
								.collect(Collectors.toList());
		return bookStoreService.calculatePrice(books);
	}
}
