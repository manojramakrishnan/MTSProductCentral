package com.multiplicandin.productcentral.dao;

import java.util.List;

import javax.validation.Valid;

import com.multiplicandin.productcentral.model.Product;


public interface ProductDAO {
	
	List<Product> findAll();

	List<Product> findAllOutOfstock();
	
	Product findById(Integer id);

	Product createNewProduct(@Valid Product product);

	Product findAllByProductId(Integer productId);

	Product getOne(Integer id);

	Product update(Product product);

	void deleteById(Integer id);

	List<Product> fidnAllByProductId(@Valid Product product);

}
