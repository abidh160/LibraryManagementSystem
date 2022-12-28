package com.application.librarymanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.application.librarymanagementsystem.entity.Category;
import com.application.librarymanagementsystem.service.CategoryService;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/categories")
	public String findAllCategories(Model model) {
		List<Category> categories = categoryService.findAllCategories();
		model.addAttribute("categories", categories);
		return "/categories";
	}
	
	@GetMapping("/remove-category/{id}")
	public String removeCategory(@PathVariable Long id, Model model) {
		categoryService.deleteCategory(id);
		return "redirect:/categories";
	}
	
	@GetMapping("/update-category/{id}") 
	public String updateCategory(@PathVariable Long id, Model model) {
		Category category = categoryService.findCategoryById(id);
		model.addAttribute("category", category);
		return "update-category";
	}
	
	@PostMapping("/save-updated-category/{id}")
	public String saveUpdateCategory(@PathVariable Long id, Category category, Model model, BindingResult result) {
		if(result.hasErrors()) {
			return "update-category";
		}
		categoryService.updateCategory(category);
		model.addAttribute("categories", categoryService.findAllCategories());
		return "redirect:/categories";
		
	}
	
	@GetMapping("/add-category") 
	public String updateCategory(Category category) {
		return "add-category";
	}
	
	@PostMapping("/save-category") 
	public String saveCategory(Category category, Model model, BindingResult result) {
		if(result.hasErrors()) {
			return "add-category";
		}
		categoryService.createCategory(category);
		model.addAttribute("categories", categoryService.findAllCategories());
		return "redirect:/categories";
	}
}
