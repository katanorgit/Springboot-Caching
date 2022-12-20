package com.rkatanor.springbootrestapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rkatanor.springbootrestapi.exceptions.ProductFoundException;
import com.rkatanor.springbootrestapi.exceptions.ProductNotFoundException;
import com.rkatanor.springbootrestapi.models.Product;
import com.rkatanor.springbootrestapi.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@Override
	public List<Product> getListOfProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id)
				.orElseThrow(() -> new ProductNotFoundException("product not found with id : " + id));

	}

	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		if (productRepository.existsById(product.getId())) {
			throw new ProductFoundException("Cannot add ! product already exist with id : " + product.getId());
		}
		productRepository.saveAndFlush(product);
	}

	@Override
	public void purgeProduct(int id) {
		// TODO Auto-generated method stub
		if (productRepository.existsById(id)) {
			productRepository.deleteById(id);
		} else {
			throw new ProductNotFoundException("product not found with id : " + id);
		}

	}

}
