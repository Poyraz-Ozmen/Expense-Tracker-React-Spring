package com.example.codeengine.expense.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.codeengine.expense.model.Category;

public interface CategoryRepository extends JpaRepository<Category,Long>{
	
	// findBy + field
	Category  findByName(String name);
}
