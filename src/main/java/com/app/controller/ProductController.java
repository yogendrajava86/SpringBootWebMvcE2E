package com.app.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.app.model.Categories;
import com.app.model.Product;
import com.app.service.CategoriesService;
import com.app.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService service;
	
	@Autowired	
	private CategoriesService cservice;
	
    private static String UPLOADED_FOLDER = "D://JavaApp//SpringBootWorkStation//SpringBootWebMvcE2E//src//main//resources//static//images//uploadingDir//";
    
	//1. Show Product Form with Backing Object
	@RequestMapping("/add")
	public String showReg(Model map) {
		//Form Backing Object
		List<Categories> cats=cservice.getAllCategories();
		map.addAttribute("product", new Product());
		map.addAttribute("categories",cats);
		
		return "AddProduct";
	}
	
	//https://www.mkyong.com/spring-boot/spring-boot-file-upload-example/
	//2. Read Form Data on click submit
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveData(
			@ModelAttribute Product product,			
			Model map)
	{
		List<Categories> cats=cservice.getAllCategories();
		map.addAttribute("categories",cats);
		
		List<MultipartFile> files = product.getFiles();
		
		List<String> fileNames = new ArrayList<String>();
		
		
		String fileName = null;
		
		if(null != files && files.size() > 0) {
			for (MultipartFile multipartFile : files) {

				 fileName = multipartFile.getOriginalFilename();
				fileNames.add(fileName);
				//Handle file content - multipartFile.getInputStream()
				try {

		            // Get the file and save it somewhere
		            byte[] bytes = multipartFile.getBytes();
		            UUID uuid = UUID.randomUUID();
		            String extension = FilenameUtils.getExtension(multipartFile.getOriginalFilename());
		            String newImgName=uuid+"."+extension;
		            Path path = Paths.get(UPLOADED_FOLDER + newImgName);
		            //Path path = Paths.get(UPLOADED_FOLDER + multipartFile.getOriginalFilename());
		            Files.write(path, bytes);
		            product.getImages().add(newImgName);
		            	
		        } catch (IOException e) {
		            e.printStackTrace();
		        }


			}
		}
					
		//call service layer
		Integer id=service.saveProduct(product);
		map.addAttribute("message", "Product '"+id+"' created!!");
		//clean Form Backing Object
		map.addAttribute("product", new Product());
		return "AddProduct";
	}
	
	
	//3. Fetch all Rows from DB to UI
	@RequestMapping("/all")
	public String showAll(Model map) {
		//fetch all rows from DB
		List<Product> obs=service.getAllProducts();
		
		//send to UI
		map.addAttribute("list", obs);
		//obs.forEach(System.out::println);
		return "ProductList";
	}
	
	//4. Delete row based on ID
	@RequestMapping("/delete")
	public String remove(@RequestParam Integer id) {
		//delete row based on ID
		Optional<Product> p=service.getProductById(id);
		if(p.isPresent()) {
		List<String> prd = p.get().getImages();
			if(null != prd && prd.size() > 0) {
			for (String pd:prd) {
				try{
		             
		                 Path path=Paths.get(UPLOADED_FOLDER+ pd);
		                 Files.delete(path);
		                 System.out.println("Product Image Deleted !!!");
		             
		         }
		         catch(Exception e)
		         {
		             System.out.println("Failed to Delete image !!");
		         }
				
			}
			}
		 
		}
		service.deleteProduct(id);
		//response.sendRedirect
		return "redirect:all";
	}
	//5. Update Product
	
	
}



