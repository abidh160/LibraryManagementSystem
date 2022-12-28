package com.application.librarymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.librarymanagementsystem.entity.Author;
import com.application.librarymanagementsystem.repository.AuthorRepository;

@Service
public class AuthorService {
	@Autowired
	private AuthorRepository authorRepository;
	
	public List<Author> findAllAuthors() {
		return authorRepository.findAll();
	}
	
	public Author findAuthorById(Long id) {
		Author author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
		return author;
	}
	
	public void createAuthor(Author author) {
		authorRepository.save(author);
	}
	
	public void updateAuthor(Author author) {
		authorRepository.save(author);
	}
	
	public void deleteAuthor(Long id) {
		Author author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
		authorRepository.deleteById(author.getId());
	}
}
