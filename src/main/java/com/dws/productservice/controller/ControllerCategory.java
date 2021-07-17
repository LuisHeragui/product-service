package com.dws.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dws.productservice.dto.Category;
import com.dws.productservice.exceptionHandler.ApiException;
import com.dws.productservice.service.ServiceCategory;

@RestController
@RequestMapping("/category")
public class ControllerCategory {

	@Autowired
	ServiceCategory serviceCategory;
		
	@GetMapping
	public ResponseEntity<Object> getCategories() throws Exception {
		try {
			return new ResponseEntity<>(serviceCategory.getCategories(), HttpStatus.OK);			
		} catch(Exception e) {
			throw new ApiException(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
		}
	}
		
	@GetMapping("/{id}")
	public ResponseEntity<Object> getCategory(@PathVariable("id") int id) throws Exception {
		try {
			return new ResponseEntity<>(serviceCategory.getCategory(id), HttpStatus.OK);			
		} catch(Exception e) {
			throw new ApiException(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
		}
	}
		
	@PostMapping
	public ResponseEntity<Object> createCategory(@RequestBody Category categoria) throws Exception {
		try {
			serviceCategory.createCategory(categoria);
			return new ResponseEntity<>(HttpStatus.CREATED);			
		} catch(Exception e) {
			throw new ApiException(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
		}
	}
		
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateCategory(@RequestBody Category categoria, @PathVariable("id") int id) throws Exception {
		try {
			serviceCategory.updateCategory(categoria, id);
			return new ResponseEntity<>(HttpStatus.OK);			
		} catch(Exception e) {
			if (e.getMessage().equals("La categoría no existe")) {
				throw new ApiException(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
			} else {				
				throw new ApiException(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
			}
		} 
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteCategory(@PathVariable("id") int id) throws Exception {
		try {
			serviceCategory.deleteCategory(id);
			return new ResponseEntity<>(HttpStatus.OK);			
		} catch(Exception e) {
			throw new ApiException(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
		}
	}
}
