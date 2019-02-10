package com.yassine.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	@Id
	@GeneratedValue
	private Long idCategory;
	private String nomCategory;
	@OneToMany(mappedBy="category")
	List<Article> articles ;
}
