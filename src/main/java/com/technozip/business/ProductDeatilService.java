package com.technozip.business;

import java.util.List;

import com.technozip.dto.ProductDetail;


public interface ProductDeatilService {

	
	public void addProductDetail(ProductDetail  productDetail);
    public void updateProductDetail(ProductDetail p);
    public List<ProductDetail> listProducts();
    public ProductDetail getProductDetailById(int id);
    public void removeProductDetail(int id);
}
