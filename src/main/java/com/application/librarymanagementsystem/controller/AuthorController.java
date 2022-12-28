package com.application.librarymanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.application.librarymanagementsystem.entity.Author;
import com.application.librarymanagementsystem.service.AuthorService;

@Controller
public class AuthorController {
	@Autowired
	private AuthorService authorService;
	
	@GetMapping("/authors")
	public String findAllAuthors(Model model) {
		List<Author> authors = authorService.findAllAuthors();
		model.addAttribute("authors", authors);
		return "authors";
	}
	
	@GetMapping("/remove-author/{id}") 
	public String deleteAuthor(@PathVariable Long id, Model model) {
		authorService.deleteAuthor(id);
		model.addAttribute("authors", authorService.findAllAuthors());
		return "redirect:/authors";
	}
	
	@GetMapping("/update-author/{id}")
	public String updateAuthor(@PathVariable Long id, Model model) {
		Author author = authorService.findAuthorById(id);
		model.addAttribute("author", author);
		return "update-author";
	}
	
	@PostMapping("/save-updated-author/{id}") 
	public String updateAuthor(@PathVariable Long id, Author author, Model model, BindingResult result) {
		if(result.hasErrors()) {
			return "update-author";
		}
		authorService.updateAuthor(author);
		return "redirect:/authors";
	}
	
	@GetMapping("/add-author")
	public String updateAuthor(Author author) {
		return "add-author";
	}
	
	@PostMapping("/save-author")
	public String saveAuthor(Author author, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "add-author";
		}
		authorService.createAuthor(author);
		model.addAttribute("authors", authorService.findAllAuthors());
		return "redirect:/authors";
	}
}
