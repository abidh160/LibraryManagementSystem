package com.application.librarymanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.application.librarymanagementsystem.entity.Publisher;
import com.application.librarymanagementsystem.service.PublisherService;

@Controller
public class PublisherController {

	@Autowired
	private PublisherService publisherService;
	
	@GetMapping("/publishers")
	public String findAllPublishers(Model model) {
		List<Publisher> publisher = publisherService.findAllPublishers();
		model.addAttribute("publishers", publisher);
		return "publishers";
	}
	
	@GetMapping("/remove-publisher/{id}")
	public String removePublisher(@PathVariable Long id, Model model) {
		publisherService.deletePublisher(id);
		model.addAttribute("publishers", publisherService.findAllPublishers());
		return "publishers";
	}
	
	@GetMapping("/update-publisher/{id}")
	public String updatePublisher(@PathVariable Long id, Model model) {
		Publisher publisher = publisherService.findPublisherById(id);
		model.addAttribute("publisher", publisher);
		return "update-publisher";
	}
	
	@PostMapping("/save-updated-publisher/{id}")
	public String updatePublisher(@PathVariable Long id, Publisher publisher, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "update-publisher";
		}
		publisherService.updatePublisher(publisher);
		model.addAttribute("publishers", publisherService.findAllPublishers());
		return "redirect:/publishers";
	}
	
	@GetMapping("/add-publisher")
	public String addPublisher(Publisher publisher) {
		return "add-publisher";
	}
	
	@PostMapping("/save-publisher")
	public String savePublisher(Publisher publisher, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "add-publisher";
		}
		publisherService.createPublisher(publisher);
		model.addAttribute("publishers", publisherService.findAllPublishers());
		return "redirect:/publishers";
	}
}
