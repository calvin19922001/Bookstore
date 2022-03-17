package com.example.bookstorespring;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import com.example.entity.Book;
import com.example.entity.BookStore;
import com.example.repo.BookRepo;
import com.example.repo.BookStoreRepo;

@SpringBootTest
public class BookStoreTest {

	@Autowired
	private BookRepo bRepo;
	
	@Autowired
	private BookStoreRepo bsRepo;
	
	@Test
	@Order(1)
	public void testAddBookToBootStore() {
		// Create a Book Store
		BookStore bookstore = new BookStore();
		Book book = new Book();
		book.setTitle("Testing Title 1");
		book.setAuthor("Testing Author 1");
		book.setPublisher("Testing Publisher 1");
		book.setPrice(32.5);
		book.setNumOfPages(100);
		book.setQuantity(10);
		bookstore.addNewBook(book);
		bRepo.save(book);
		bsRepo.save(bookstore);
		assertNotNull(bRepo);
		assertNotNull(bRepo.findById(1L).get());
	}
	
	@Test
	@Order(2)
	public void testRetrieveAll() {
		List<Book> bList = bRepo.findAll();
		assertThat(bList).size().isGreaterThan(0);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	@Order(3)
	public void testRetrieve() {
		Book b = bRepo.findById(1L).get();
		assertEquals("Testing Title 1", b.getTitle());
		assertEquals("Testing Author 1", b.getAuthor());
		assertEquals("Testing Publisher 1", b.getPublisher());
		assertEquals((double)32.5, (double)b.getPrice());
		assertEquals(100, b.getNumOfPages());
		assertEquals(10, b.getQuantity());
	}
	
	@Test
	@Order(4)
	public void testDelete() {
		bRepo.deleteById(1L);
		assertThat(bRepo.existsById(1L)).isFalse();
	}

}
