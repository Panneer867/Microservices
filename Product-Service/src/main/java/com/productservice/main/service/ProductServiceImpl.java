package com.productservice.main.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productservice.main.entity.Product;
import com.productservice.main.exception.ProductServiceCustomException;
import com.productservice.main.model.ProductRequest;
import com.productservice.main.model.ProductResponse;
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

		Product product = Product.builder().productName(productRequest.getName()).quantity(productRequest.getPrice())
				.price(productRequest.getQuantity()).build();

		productRepository.save(product);

		log.info("Product Created");

		return product.getProductId();
	}

	@Override
	public ProductResponse getProductById(long productId) {

		log.info("Get the Product By ID: " + productId);

		Product product = productRepository.findById(productId).orElseThrow(
				() -> new ProductServiceCustomException("Product with the given Id not found", "PRODUCT_NOT_FOUND"));

		ProductResponse productResponse = new ProductResponse();

		BeanUtils.copyProperties(product, productResponse);

		return productResponse;
	}

	@Override
	public void reduceQuantity(long productId, long quantity) {

		log.info("Reduce Quantity {} for ID: {}" + quantity, productId);

		Product product = productRepository.findById(productId).orElseThrow(
				() -> new ProductServiceCustomException("Product with given Id not found", "PRODUCT_NOT_FOUND"));

		if (product.getQuantity() < quantity) {
			throw new ProductServiceCustomException("Product does not have Sufficient Quantity",
					"INSUFFICIENT_QUANTITY");
		}

		product.setQuantity(product.getQuantity() - quantity);
		productRepository.save(product);
		log.info("Product Quantity updated successfully");

	}

}
