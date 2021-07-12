package com.dws.productservice.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dws.productservice.dto.Category;

@Repository
public class RepositoryCategory {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Category> getCategories() throws Exception {
		try {
			return jdbcTemplate.query("SELECT * FROM category;", new BeanPropertyRowMapper<Category>(Category.class));			
		} catch(Exception e) {
			throw new Exception(e.getLocalizedMessage());
		}
	}
	
	public Category getCategory(int id) throws Exception {
		try {
			return jdbcTemplate.queryForObject("SELECT * FROM category WHERE id = " + id + ";", new BeanPropertyRowMapper<Category>(Category.class));
		} catch(Exception e) {
			throw new Exception(e.getLocalizedMessage());
		}
	}
	
	public void createCategory(Category categoria) throws Exception {
		try {
			jdbcTemplate.update("{CALL st_create_category(?)}", categoria.getCategoria());
		} catch(UncategorizedSQLException e) {
			throw new Exception(e.getSQLException().getLocalizedMessage());
		}
	}
	
	public void updateCategory(Category categoria, int id) throws Exception {
		
	}
	
	public void deleteCategory(int id) throws Exception {
		try {
			jdbcTemplate.update("DELETE FROM category WHERE id = " + id + ";");
		} catch(Exception e) {
			throw new Exception(e.getLocalizedMessage());
		}
	}
}
