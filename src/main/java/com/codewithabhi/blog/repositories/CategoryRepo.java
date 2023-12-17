package com.codewithabhi.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithabhi.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category,Integer> {
	
}
