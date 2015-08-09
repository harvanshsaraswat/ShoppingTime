package com.technozip.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="product_details")
public class ProductDetail {
	
	@Id
    @Column(name="product_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int productId;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="product_cate")
	private String productCategory;
	
	@Column(name="product_cost")
	private String productCost;
	
	@Column(name="product_use")
	private String productUse;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductCost() {
		return productCost;
	}

	public void setProductCost(String productCost) {
		this.productCost = productCost;
	}

	public String getProductUse() {
		return productUse;
	}

	public void setProductUse(String productUse) {
		this.productUse = productUse;
	}
	
	
	

}
