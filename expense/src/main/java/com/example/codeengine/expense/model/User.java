package com.example.codeengine.expense.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Getter @Setter //instead of writing getters, setters lombok creates it
	private String name;
	
	private String email;
	
	
	@OneToMany
	private Set<Category> category; // connected with category.java  In category.jav it will be manToOne
	

}
