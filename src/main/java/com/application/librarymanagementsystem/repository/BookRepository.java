package com.application.librarymanagementsystem.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.application.librarymanagementsystem.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
