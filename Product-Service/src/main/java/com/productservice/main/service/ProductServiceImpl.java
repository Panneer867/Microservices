package com.productservice.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productservice.main.entity.Product;
import com.productservice.main.model.ProductRequest;
import com.productservice.main.repository.ProductRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public long addProduct(ProductRequest productRequest) {
		
		log.info("Adding Product..");
		
		Product product = Product.builder().productName(productRequest.getName())
				.quantity(productRequest.getPrice())
				.price(productRequest.getQuantity()).build();
		
		productRepository.save(product);
		
		log.info("Product Created");
		
		return product.getProductId();
	}

}
