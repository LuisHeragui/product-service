package com.dws.productservice.dto;

public class Category {

	private int id;
	private String categoria;
	
	public Category() {
		super();
	}

	public Category(int id, String categoria) {
		super();
		this.id = id;
		this.categoria = categoria;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}
