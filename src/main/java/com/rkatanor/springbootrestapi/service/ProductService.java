package com.rkatanor.springbootrestapi.service;

import java.util.List;

import com.rkatanor.springbootrestapi.models.Product;

public interface ProductService {
	public List<Product> getListOfProducts();

	public Product getProductById(int id);

	public void addProduct(Product product);

	public void purgeProduct(int id);
}
