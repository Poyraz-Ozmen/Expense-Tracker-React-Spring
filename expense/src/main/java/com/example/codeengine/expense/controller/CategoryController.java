package com.example.codeengine.expense.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.codeengine.expense.model.Category;
import com.example.codeengine.expense.repository.CategoryRepository;

@RestController
@RequestMapping("/api")
public class CategoryController {
	private CategoryRepository categoryRepository;

	public CategoryController(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}
	
	 @GetMapping("/categories")
	 Collection<Category> categories(){
		 return categoryRepository.findAll(); // select * from category
		 // pre build JPA repository function
		 
	 }
	 
	 // category/2
	 @GetMapping("/category/{id}")
	 ResponseEntity<?> getCategory(@PathVariable Long id){
	 	Optional<Category> category = categoryRepository.findById(id);
	 	return category.map(response -> ResponseEntity.ok().body(response))
	 			.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	 }

	 @PostMapping("/category")
	 ResponseEntity<Category> createCategory(@Valid @RequestBody Category category) throws URISyntaxException{
		 Category result = categoryRepository.save(category); // insert into table .....
		 return ResponseEntity.created(new URI("/api/category" + result.getId())).body(result) ; 
		 // in getID() function lombok has been imported to category.java as @Data so we can use Getters and setters
		 // but it did not work on my category.java class
		// in body we are expecting to see category that we named it as "category"
		 // you are expecting a valid request body so you are expecting well formatted data coming into your application
	 }
	 @PutMapping("/category/{id}")
	 ResponseEntity<Category> updateCategory(@Valid @RequestBody Category category){
		 Category result = categoryRepository.save(category);
		 return ResponseEntity.ok(result);
	 }
	 
	 @DeleteMapping("/category/{id}")
	 ResponseEntity<?> deleteCategory(@PathVariable long id){
		 categoryRepository.deleteById(id);
		 return ResponseEntity.ok().build();// return a builted object
	 }
	 
}
