package com.rkatanor.springbootrestapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rkatanor.springbootrestapi.exceptions.ProductNotFoundException;
import com.rkatanor.springbootrestapi.models.Product;
import com.rkatanor.springbootrestapi.service.ProductService;

@RestController
@RequestMapping("api/v2")
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping(value = "/products")
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> listOfProducts = productService.getListOfProducts();
		return new ResponseEntity<List<Product>>(listOfProducts, HttpStatus.OK);
	}

	@GetMapping(value = "/products/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") int id) {
		Product productById = productService.getProductById(id);
		return new ResponseEntity<Product>(productById, HttpStatus.OK);
	}

	@PostMapping(value = "/products/add")
	public ResponseEntity<String> addProduct(@RequestBody Product product) {
		productService.addProduct(product);
		return new ResponseEntity<String>("Product added", HttpStatus.OK);
	}

	@DeleteMapping(value = "/products/delete/{id}")
	public ResponseEntity<Object> deleteProductById(@PathVariable("id") int id) {
		productService.purgeProduct(id);
		return new ResponseEntity<Object>("product deleted", HttpStatus.OK);
	}
}
