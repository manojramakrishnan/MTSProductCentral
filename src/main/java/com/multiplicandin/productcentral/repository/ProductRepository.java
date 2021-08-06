package com.multiplicandin.productcentral.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multiplicandin.productcentral.model.Product;


@Repository("productRepository")
public interface ProductRepository extends JpaRepository<Product, Long> {

	

}
