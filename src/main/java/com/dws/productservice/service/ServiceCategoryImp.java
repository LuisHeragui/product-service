package com.dws.productservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dws.productservice.dto.Category;
import com.dws.productservice.repository.RepositoryCategory;

@Service
public class ServiceCategoryImp implements ServiceCategory {

	@Autowired
	RepositoryCategory repositoryCategory;
	
	@Override
	public List<Category> getCategories() throws Exception {
		return repositoryCategory.getCategories();
	}

	@Override
	public Category getCategory(int id) throws Exception {
		try {
			return repositoryCategory.getCategory(id);			
		} catch(Exception e) {
			throw new Exception("La categoría no existe");
		}
	}

	@Override
	public void createCategory(Category category) throws Exception {
		repositoryCategory.createCategory(category);
	}

	@Override
	public void updateCategory(Category category, int id) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteCategory(int id) throws Exception {
		repositoryCategory.deleteCategory(id);
	}

}
