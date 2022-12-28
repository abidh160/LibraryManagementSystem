package com.application.librarymanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.librarymanagementsystem.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
