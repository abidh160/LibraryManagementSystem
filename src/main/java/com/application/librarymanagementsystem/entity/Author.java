package com.application.librarymanagementsystem.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "authors")
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", length = 100, nullable = false, unique = true)
	private String name;
	
	@Column(name = "description", length = 250, nullable = false)
	private String description;
	
	@ManyToMany(mappedBy = "authors", cascade = CascadeType.ALL)
	private Set<Book> books = new HashSet<Book>();

	public Author(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	
}
