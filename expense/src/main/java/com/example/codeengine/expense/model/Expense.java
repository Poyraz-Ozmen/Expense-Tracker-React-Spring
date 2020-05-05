package com.example.codeengine.expense.model;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@Data
@Table(name="expense")
public class Expense {
	@Id
	private Long id;
	
	private Instant expensedate;
	
	private String descript;
	
	// we need to connect expense to both user and category
	//1000, 6/16/2019, 'visiting NY', 1 (user) , 10 (category)
	// 
	
	@ManyToOne // How to read this is many expenses can go to one category
	private Category category;
	
	@ManyToOne // how to read this is : Many Expenses goes to one user
	private User user;
}
