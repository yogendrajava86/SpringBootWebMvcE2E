package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.Categories;
import com.app.repo.CategoriesRepository;
import com.app.service.CategoriesService;
@Service
public class CategoriesServiceImpl implements CategoriesService {

	@Autowired
	private CategoriesRepository repo;
	
	@Override
	public Integer saveCategory(Categories c) {
		c=repo.save(c);
		return c.getCatId();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Categories> getAllCategories() {
		return repo.findAll();
	}

	@Override
	@Transactional
	public void deleteCategory(Integer id) {
		repo.deleteById(id);
	}

}
