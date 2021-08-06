package com.multiplicandin.productcentral.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Product {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String productName;

    private String productCode; // Ministry of Health Medicine Code

    @Column(name = "category")
   
    private String category;
    
    public long getId() {
		return id;
	}





	public void setId(long id) {
		this.id = id;
	}



	@Column(name = "quantity")
    // @NotEmpty(message = "*Can't be blank")
     private int quantity=0;


   
	public Product() {}





	public String getProductName() {
		return productName;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}



	public String getProductCode() {
		return productCode;
	}



	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public Product(long id, String productName, String productCode,
			 String category, int quantity) {
		super();
		this.id = id;
		this.productName = productName;
		this.productCode = productCode;
		this.category = category;
		this.quantity = quantity;
	}



	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", productCode=" + productCode + ", category="
				+ category + ", quantity=" + quantity + "]";
	}

}
