package com.application.librarymanagementsystem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.application.librarymanagementsystem.entity.Author;
import com.application.librarymanagementsystem.entity.Book;
import com.application.librarymanagementsystem.entity.Category;
import com.application.librarymanagementsystem.entity.Publisher;
import com.application.librarymanagementsystem.service.BookService;

@SpringBootApplication
public class LibrarymanagementsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibrarymanagementsystemApplication.class, args);
	}

	@Bean
	public CommandLineRunner initialCreate(BookService bookService) {
		return (args) -> {
			Book book1 = new Book("ABC", "Book Name", "My first book");
			Author author1 = new Author("Test Name 1", "Test Desc.");
			Category category1 = new Category("Business book");
			Publisher publisher1 = new Publisher("First publisher");
			book1.addAuthor(author1);
			book1.addCategory(category1);
			book1.addPublisher(publisher1);
			bookService.createBook(book1);
			
			Book book2 = new Book("ABC2", "Book Name2", "My second book");
			Author author2 = new Author("Test Name 2", "Test Desc. 2");
			Category category2 = new Category("Science book");
			Publisher publisher2 = new Publisher("Second publisher");
			book2.addAuthor(author2);
			book2.addCategory(category2);
			book2.addPublisher(publisher2);
			bookService.createBook(book2);
			
			Book book3 = new Book("ABC3", "Book Name3", "My third book");
			Author author3 = new Author("Test Name 3", "Test Desc. 3");
			Category category3 = new Category("fiction book");
			Publisher publisher3 = new Publisher("third publisher");
			book3.addAuthor(author3);
			book3.addCategory(category3);
			book3.addPublisher(publisher3);
			bookService.createBook(book3);
		};
	}
	
}
