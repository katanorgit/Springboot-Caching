package com.rkatanor.springbootrestapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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
	@Cacheable(cacheNames="products")
	public List<Product> getListOfProducts() {
		// TODO Auto-generated method stub
		System.out.println("connecting to repo");
		return productRepository.findAll();
	}

	@Override
	@Cacheable(cacheNames = "products",key = "#id")
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id)
				.orElseThrow(() -> new ProductNotFoundException("product not found with id : " + id));

	}

	@Override
	@CacheEvict(value = "products",allEntries = true)
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		if (productRepository.existsById(product.getId())) {
			throw new ProductFoundException("Cannot add ! product already exist with id : " + product.getId());
		}
		productRepository.saveAndFlush(product);
	}

	@Override
	@CacheEvict(cacheNames = "products",key = "#id",allEntries = true)
	public void purgeProduct(int id) {
		// TODO Auto-generated method stub
		if (productRepository.existsById(id)) {
			productRepository.deleteById(id);
		} else {
			throw new ProductNotFoundException("product not found with id : " + id);
		}

	}

}
