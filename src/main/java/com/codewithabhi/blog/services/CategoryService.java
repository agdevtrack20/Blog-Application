package com.codewithabhi.blog.services;

import com.codewithabhi.blog.payloads.CategoryDto;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public interface CategoryService {
	

	CategoryDto createCategory(CategoryDto categoryDto);
	CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);
	public void deleteCategory(Integer categoryId);
	CategoryDto getCategory(Integer categoryId);
	List<CategoryDto> getCategories();
	
}
