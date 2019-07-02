package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Categories;
import com.app.model.Product;
import com.app.service.CategoriesService;
import com.app.service.ProductService;

@Controller
@RequestMapping("/category")
public class CategoriesController {
	@Autowired
	private ProductService pservice;
	
	@Autowired	
	private CategoriesService service;
	//1. Show Category Form with Backing Object
		@RequestMapping("/addcat")
		public String showAddFrm(Model map) {
			//Form Backing Object			
			map.addAttribute("categories",new Categories());			
			return "AddCategory";
		}
		
		//2. Read Form Data on click submit
		@RequestMapping(value="/savecat",method=RequestMethod.POST)
		public String saveCate(
				@ModelAttribute Categories categories,
				Model map)
		{
			//call service layer
			Integer id=service.saveCategory(categories);
			map.addAttribute("message", "Category '"+id+"' created!!");
			//clean Form Backing Object
			map.addAttribute("categories",new Categories());
			return "AddCategory";
		}
		
		
		//3. Fetch all Rows from DB to UI
		@RequestMapping("/allcat")
		public String showAllCat(Model map) {
			//fetch all rows from DB
			List<Categories> obs=service.getAllCategories();
			//send to UI
			map.addAttribute("list", obs);
			return "CategoriesList";
		}
		
		//4. Delete row based on ID
		@RequestMapping("/deletecat")
		public String remove(@RequestParam Integer id) {
			//delete row based on ID
			service.deleteCategory(id);
			//response.sendRedirect
			return "redirect:allcat";
		}
		
}
