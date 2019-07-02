package com.app.service;

import java.util.List;

import com.app.model.Categories;

public interface CategoriesService {
	public Integer saveCategory(Categories c);
	public List<Categories> getAllCategories();
	public void deleteCategory(Integer id);
}
