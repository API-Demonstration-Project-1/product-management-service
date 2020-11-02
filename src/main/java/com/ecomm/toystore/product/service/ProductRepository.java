package com.ecomm.toystore.product.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import io.swagger.model.Product;




@Repository
public interface ProductRepository  extends CrudRepository<Product, Integer> {
	
	
}
