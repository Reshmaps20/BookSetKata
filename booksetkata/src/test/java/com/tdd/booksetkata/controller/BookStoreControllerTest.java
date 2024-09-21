package com.tdd.booksetkata.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.tdd.booksetkata.service.BookStoreService;

@SpringBootTest
@AutoConfigureMockMvc
public class BookStoreControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Mock
	private BookStoreService bookStoreService;

	@Test
	void testFetchAvailableBooks_ShouldRetreiveTheBooks_RetrunsBookList() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/bookstore/fetchbooks").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(5));
	}

	@Test
	void testCalculatePrice_ShouldCalculateThePriceOfBookPurchased_RetrunsBookPrice() throws Exception {

		when(bookStoreService.calculatePrice(anyList())).thenReturn(95.0);

		mockMvc.perform(post("/bookstore/calculateprice").contentType(MediaType.APPLICATION_JSON)
				.content("[\"CLEAN_CODE\", \"CLEAN_CODER\"]"))
				.andExpect(status().isOk()).andExpect(content().string("95.0"));
	}

}
