package com.productservice.main.service;

import com.productservice.main.model.ProductRequest;
import com.productservice.main.model.ProductResponse;

public interface ProductService {

	long addProduct(ProductRequest productRequest);

	ProductResponse getProductById(long productId);

}
