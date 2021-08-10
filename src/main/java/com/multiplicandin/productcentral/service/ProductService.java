package com.multiplicandin.productcentral.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.multiplicandin.productcentral.model.Product;


public interface ProductService {

	List<Product> getAllProducts();
	Product saveProduct(Product product);
	Product getProductById(long id);
	void deleteProductById(long id);
	Page<Product> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}

