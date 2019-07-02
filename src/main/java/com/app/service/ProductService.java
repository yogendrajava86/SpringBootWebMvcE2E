package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.model.Product;

public interface ProductService {
	public Integer saveProduct(Product p);
	public List<Product> getAllProducts();
	public void deleteProduct(Integer id);
	public Optional<Product> getProductById(Integer id);
}
