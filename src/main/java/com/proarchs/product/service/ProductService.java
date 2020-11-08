package com.proarchs.product.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proarchs.product.model.Product;
import com.proarchs.product.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Product save(Product product) {
		return productRepository.save(product);
	}
	
	public Product get(Integer productId) {
		return productRepository.findById(productId).get();
	}

	public Iterable<Product> get() {
		return productRepository.findAll();
	}

	public void delete(Integer productId) {
		productRepository.deleteById(productId);;
	}
}
