package com.example.codeengine.expense.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@NoArgsConstructor
@Data
@Table(name="category")
public class Category {
	
	@Id
	private long id;
	
	@NonNull
	private String name; //travel,grocery...
/*
	@ManyToOne(cascade=CascadeType.PERSIST) //persist operation is basically cascaded through this operation
	private User user; // many categories is under one user
*/

	public long getId() {
		// TODO Auto-generated method stub
		return id;
	}	
}
