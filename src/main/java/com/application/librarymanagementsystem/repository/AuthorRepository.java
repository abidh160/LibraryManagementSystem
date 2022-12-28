package com.application.librarymanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.librarymanagementsystem.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
