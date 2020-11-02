package com.ecomm.toystore.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.swagger.model.Product;



@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepo;
	
	public void saveProduct(Product product) {
		productRepo.save(product);
	}

}

