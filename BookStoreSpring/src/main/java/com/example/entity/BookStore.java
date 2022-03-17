package com.example.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BookStore {
	
	public static final String BOOK_AVAILABLE = "Available";
    public static final String BOOK_NO_COPY = "No copy";
    public static final String BOOK_NOT_EXIST = "Not exist";

	private List<Book> books;
	private int totalBooks;
	private double grossIncome;
	
	public BookStore() {
	    books = new ArrayList<Book>(100);
	    totalBooks = 0;
	    grossIncome = 0;
	}
	
	public void addNewBook(Book b) {
	    books.add(b);
	    this.totalBooks++;
	}
	
	
	public void addBookQuantity(String title, int quantity) {
		for (Book b : books) {
			if (title.equals(b.getTitle())) {
				b.setQuantity(b.getQuantity() + quantity);
				System.out.println("Quantity added successfully");
			}
		}
	
	}

	public String inStock (String title, int quantity) {
		for (Book b : books) {
			if (title.equals(b.getTitle())) {
	            if (quantity <= b.getQuantity()) 
	            	return BOOK_AVAILABLE;
	            else 
	            	return BOOK_NO_COPY;
	        }
	    }
	    return BOOK_NOT_EXIST;
	
	}

	public String sellBook(String title, int quantity){
        // Checks to see if the books are in stock.
        String retval = inStock(title, quantity);

        if (retval.equals(BOOK_AVAILABLE)) {
	    	for (Book b : books) {
	    		if (title.equals(b.getTitle())) {
	    			b.setQuantity(b.getQuantity() - quantity);
	    			this.grossIncome += (b.getPrice() * quantity);
	    		}
	    	}
        }
        return retval;
        }


	public void listTitlesByAuthor(String author)
	{
		List<Book> filteredList = books.stream()
				.filter(book -> book.getAuthor().equals(author))
				.collect(Collectors.toList());
		for (Book b : filteredList) {
			System.out.println(b.getTitle());
		}
	
	}

	public void listTitlesByPublisher(String publisher)
	{
		List<Book> filteredList = books.stream()
				.filter(book -> book.getPublisher().equals(publisher))
				.collect(Collectors.toList());
		for (Book b : filteredList) {
			System.out.println(b.getTitle());
		}
	
	}
	
	
	public void listAuthors()
	{
		List<String> filteredList = new ArrayList<>();
		for (Book b : books) {
			filteredList.add(b.getAuthor());
		}
		filteredList = filteredList.stream().distinct().collect(Collectors.toList());
		Collections.sort(filteredList);
		for (String s : filteredList) {
			System.out.println(s);
		}
	
	}
	
	public void listPublishers()
	{
		List<String> filteredList = new ArrayList<>();
		for (Book b : books) {
			filteredList.add(b.getPublisher());
		}
		filteredList = filteredList.stream().distinct().collect(Collectors.toList());
		Collections.sort(filteredList);
		for (String s : filteredList) {
			System.out.println(s);
		}
	
	}

	public void listTitles()
	{
		for (Book b : books) {
			System.out.println(b.getTitle());
		}
	
	}
	
	public void listBooks()
	{
		System.out.println("\nList of Books\n======");
		for (Book b : books) {
			System.out.println(b);
		}
	    System.out.println();
	}
	
	public void deleteBook(String title)
	{
		if(books.removeIf(book -> book.getTitle().equals(title))) {
			totalBooks--;
		}
	}
	
	public List<Book> getBooks() {
		return books;
	}
	
	public double getIncome()
	{
	    return grossIncome;
	}
	
	public void setIncome(double grossIncome)
	{
	    this.grossIncome = grossIncome;
	}
	
	public int getTotalBooks()
	{
		return totalBooks;
	}
	
	public void setTotalBooks(int totalBooks)
	{
	    this.totalBooks = totalBooks;
	}
}
