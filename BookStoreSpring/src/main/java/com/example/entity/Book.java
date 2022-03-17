package com.example.entity;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Book {
	private String title;
    private String author;
    private String publisher;
    private int numOfPages;
    private double price;
    private int quantity;
    private Book book;

    public String toString(){
        return "Title: " + title + "\nAuthor: " + author + "\nPublisher: " + publisher + "\nNumber of pages: " + numOfPages + "\nPrice: $" + price +"\nQuantity: " + quantity + "\n";
    }

    public Book getBook() {
 	   return book;
    }
    
    public void setBook(String title, String author, String publisher, int numOfPages, double price, int quantity){
      this.title = title;
      this.author = author;
      this.publisher = publisher;
      this.numOfPages = numOfPages;
      this.price = price;
      this.quantity = quantity;

    }
    
    public String getTitle(){
        return title;
    }
    
    public void setTitle(String title) {
 	   this.title = title;
    }
    
    public String getAuthor() {
 	   return author;
    }
    
    public void setAuthor(String author) {
 	   this.author = author;
    }

    public String getPublisher(){
        return publisher;
    }
    
    public void setPublisher(String publisher) {
 	   this.publisher = publisher;
    }

    public double getPrice(){
      return price;
    }
    
    public void setPrice(double price) {
 	   this.price = price;
    }
    
    public int getNumOfPages() {
    	return numOfPages;
    }
    
    public void setNumOfPages(int numOfPages) {
    	this.numOfPages = numOfPages;
    }

    public int getQuantity(){
      return quantity;
    }
    
    public void setQuantity(int quantity) {
 	   this.quantity = quantity;
    }
}
