package com.multiplicandin.productcentral.repository;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.multiplicandin.productcentral.model.Product;


@Repository("productRepository")
public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query("SELECT p FROM Product p WHERE p.quantity=0")
	List<Product> findAllOutOfStock();


	Product findProductById(Integer id);

	@Query("SELECT p FROM Product p where p.id = :productId")
	Product findAllByProductId(Integer productId);

	@Query("SELECT p FROM Product p where p.id = :productId")
	List<Product> findAllByProductId(@Valid Product product);

}
