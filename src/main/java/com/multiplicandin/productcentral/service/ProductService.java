package com.multiplicandin.productcentral.service;

import java.util.List;

import javax.validation.Valid;

import com.multiplicandin.productcentral.model.Product;


public interface ProductService {

	List<Product> findAll();

	List<Product> findAllOutOfStock();
	
	public Product findById(Integer id);

	public Product createNewProduct(@Valid Product product);

	Product findAllByProductId(Integer id);

	Product getOne(Integer valueOf);

	Product update(Product product);

	void deleteById(Integer valueOf);

	List<Product> findAllByProductId(@Valid Product product);

}
