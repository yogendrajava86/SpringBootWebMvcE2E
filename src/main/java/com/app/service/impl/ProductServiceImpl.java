package com.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.Product;
import com.app.repo.ProductRepository;
import com.app.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository repo;

	@Transactional
	public Integer saveProduct(Product p) {
		//calculations here..
		//gstAmt= cost*gst/100
		//totalAmt=cost+ gstAmt - disc
		p=repo.save(p);
		return p.getProdId();
	}
	
	
	@Transactional(readOnly= true)
	public List<Product> getAllProducts() {
		return repo.findAll();
	}
	
	@Transactional
	public void deleteProduct(Integer id) {
		repo.deleteById(id);
	}
	@Override
	public Product getProductById(Integer id) {
		Optional<Product> p=repo.findById(id);
		return p.get();
	}
}
