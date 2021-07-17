package com.dws.productservice.service;

import java.util.List;

import com.dws.productservice.dto.Category;

public interface ServiceCategory {
	
	public List<Category> getCategories() throws Exception;
	
	public Category getCategory(int id) throws Exception;
	
	public void createCategory(Category category) throws Exception;
	
	public void updateCategory(Category category, int id) throws Exception;
	
	public void deleteCategory(int id) throws Exception;
}
