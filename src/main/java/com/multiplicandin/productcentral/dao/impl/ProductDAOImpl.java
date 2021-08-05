package com.multiplicandin.productcentral.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.multiplicandin.productcentral.dao.ProductDAO;
import com.multiplicandin.productcentral.model.Product;
import com.multiplicandin.productcentral.repository.ProductRepository;

@Component("productDAO")
public class ProductDAOImpl implements ProductDAO {

	@PersistenceContext
    private EntityManager entityManager;
	
	
	private ProductRepository productRepository;
	
	public ProductDAOImpl(@Qualifier("productRepository") ProductRepository productRepository) {
		this.productRepository=productRepository;
		
	}
	
	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public List<Product> findAllOutOfstock() {
		// TODO Auto-generated method stub
		return productRepository.findAllOutOfStock();
	}

	@Override
	public Product findById(Integer id) {
		return productRepository.findProductById(id);
	}
	@Override
	public Product createNewProduct(@Valid Product product) {
		
		return productRepository.save(product);
	}
	@Override
	public Product findAllByProductId(Integer productId) {
		return productRepository.findAllByProductId(productId);
	}
	
	@Override
	public Product getOne(Integer id) {
		
		return productRepository.getOne(id);
	}
	@Override
	@Transactional
	public Product update(Product product) {
		
		Product persistedProduct = entityManager.find(Product.class, product.getId());

		persistedProduct.setCategory(product.getCategory());
		persistedProduct.setQuantity(product.getQuantity());
		persistedProduct.setProductName(product.getProductName());
        entityManager.merge(persistedProduct);
        return persistedProduct;
		
	
	}
	@Override
	public void deleteById(Integer id) {
		
		productRepository.deleteById(id);
		
	}

	@Override
	public List<Product> fidnAllByProductId(@Valid Product product) {
		// TODO Auto-generated method stub
		return productRepository.findAllByProductId(product);
	}

}
