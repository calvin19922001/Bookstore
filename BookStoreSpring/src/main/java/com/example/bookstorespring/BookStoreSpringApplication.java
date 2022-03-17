package com.example.bookstorespring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.*;
import com.example.checking.*;
import com.example.entity.Book;
import com.example.entity.BookStore;

@SpringBootApplication
public class BookStoreSpringApplication {
	
	public static final String BOOK_AVAILABLE = "Available";
    public static final String BOOK_NO_COPY = "No copy";
    public static final String BOOK_NOT_EXIST = "Not exist";

    @SuppressWarnings("resource")
	public static void main(String[] args) {
		SpringApplication.run(BookStoreSpringApplication.class, args);
		Scanner s = new Scanner(System.in);
	    BookStore myBkStore = new BookStore();
	    int amount = 0;
	    int user_choice = -1;
	    boolean quit = false;
	    String title = "";
	    String author = "";
	    String publisher = "";

	    do {
	        System.out.println();
	        System.out.println("Total number of books: " + myBkStore.getTotalBooks());
	        System.out.println("1) Add a book to the stock");
	        System.out.println("2) Sell a book in stock");
	        System.out.println("3) List all titles of books");
	        System.out.println("4) List all titles of books by author");
	        System.out.println("5) List all titles of books by pubisher");
	        System.out.println("6) List all authors");
	        System.out.println("7) List all pubishers");
	        System.out.println("8) List all the information about the books in stock");
	        System.out.println("9) Delete a book");
	        System.out.println("10) Print out the gross income of the bookstore");
	        System.out.println("11) Quit");
	        System.out.println();
	        System.out.print("Enter choice [1-11]: ");
	        while (!s.hasNextInt()) {
        		System.out.println("Please input integer: ");
        		s.next();
        	}
	        user_choice = s.nextInt();
	        switch (user_choice) {
	            case 1: 
	            	System.out.println("Enter a book title: ");
	            	
	            	while (!StringCheck.isNotNullOrEmpty(s.next())) {
            			System.out.println("Book title cannot be empty. Please input again: ");
            			s.next();
            		}
	            	title = s.nextLine();
	                if (myBkStore.inStock(title, amount).equals(BOOK_AVAILABLE) || myBkStore.inStock(title, amount).equals(BOOK_NO_COPY))
	                {
	                    System.out.println("Title is already exist. How many more to add to the stock?");
	                    amount = s.nextInt();
	                    myBkStore.addBookQuantity(title, amount);
	                }
	                else
	                {
	                	System.out.println("Enter the author of the book: ");
	                	
	                	while (!StringCheck.isNotNullOrEmpty(s.next())) {
	                		System.out.println("Book author cannot be empty. Please input again: ");
	                		s.next();
	                	}
	                	author = s.nextLine();
	                	
	                	System.out.println("Enter the publisher of the book: ");
	                	while (!StringCheck.isNotNullOrEmpty(s.next())) {
	                		System.out.println("Book publisher cannot be empty. Please input again: ");
	                		s.next();
	                	}
	                	publisher = s.nextLine();
	                    System.out.println("Enter the amount of pages of the book: ");
	                    while (!s.hasNextInt()) {
	                		System.out.println("Pages need to be an integer. Please input again: ");
	                		s.next();
	                	}
	                    int pages = s.nextInt();
	                    System.out.println("Enter the price of the book: ");
	                    while (!s.hasNextDouble()) {
	                		System.out.println("Price needs to be an integer or double. Please input again: ");
	                		s.next();
	                	}
	                    double price = s.nextDouble();
	                    System.out.println("Enter the quantity to add: ");
	                    while (!s.hasNextInt()) {
	                		System.out.println("Quantity needs to be an integer. Please input again: ");
	                		s.next();
	                	}
	                    int quant = s.nextInt();
	                    Book book = new Book();
	                    book.setBook(title, author, publisher, pages, price, quant);
	                    myBkStore.addNewBook(book);
	                } 
	                break;
	            case 2:	
	            	System.out.println("Enter book title to sell: ");
	            	while (!StringCheck.isNotNullOrEmpty(s.next())) {
            			System.out.println("Book title cannot be empty. Please input again: ");
            			s.next();
            		}
		            title = s.nextLine();
		            System.out.println("Enter amount to sell: ");
		            amount = s.nextInt();
		            String message = myBkStore.sellBook(title, amount);
		            if(message.equals(BOOK_AVAILABLE)) {
		            	System.out.println("Book sold successfully");
		            } else if(message.equals(BOOK_NO_COPY)) {
		            	System.out.println("Not enough copy");
		            } else if(message.equals(BOOK_NOT_EXIST)) {
		            	System.out.println("Book not exist");
		            }
		            break;
	            case 3: 
	        		myBkStore.listTitles();
	        		break;
	            case 4:
	        		System.out.println("Enter the author of the book: ");
	        		while (!StringCheck.isNotNullOrEmpty(s.next())) {
                		System.out.println("Book author cannot be empty. Please input again: ");
                		s.next();
                	}
	        		author = s.nextLine();
	        		myBkStore.listTitlesByAuthor(author);
	        		break;
	            case 5:	
	        		System.out.println("Enter the publisher of the book: ");
	        		while (!StringCheck.isNotNullOrEmpty(s.next())) {
                		System.out.println("Book publisher cannot be empty. Please input again: ");
                		s.next();
                	}
	        		publisher = s.nextLine();
	        		myBkStore.listTitlesByPublisher(publisher);
	        		break;
	            
	            case 6: 
	            	myBkStore.listAuthors();
	                break;
	            case 7: 
	            	myBkStore.listPublishers();
	                break;
	            case 8: 
	            	myBkStore.listBooks();
	                break;
	            case 9:
	            	System.out.println("Enter a book title");
	            	while (!StringCheck.isNotNullOrEmpty(s.next())) {
            			System.out.println("Book title cannot be empty. Please input again: ");
            			s.next();
            		}
	            	title = s.next();
	            	myBkStore.deleteBook(title);
	            	break;
	            case 10:
	            	System.out.println("Total income: " + myBkStore.getIncome());
	            	break;
	            case 11:
	            	System.out.println("Thanks for using the system");
	                quit = true;
	            	break;
	            default: 
	            	System.out.println("\nInvalid Choice");
	        }
	}
	while (!quit);
	}
}
