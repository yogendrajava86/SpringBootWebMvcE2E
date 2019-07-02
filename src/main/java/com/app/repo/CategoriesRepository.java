package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Categories;

public interface CategoriesRepository extends JpaRepository<Categories, Integer> {

}
