package com.technozip.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.technozip.dao.ProductDeatilDAO;
import com.technozip.dto.ProductDetail;

@Service("productDeatilService")
public class ProductDeatilServiceImpl  implements ProductDeatilService{

	
	  private ProductDeatilDAO productDeatilDAO;
	  
	  @Autowired(required=true)
	  @Qualifier(value="productDeatilDAO")
	  public void setPersonDAO(ProductDeatilDAO productDeatilDAO) {
	        this.productDeatilDAO = productDeatilDAO;
	    }
	 
	    
	    @Transactional
		public void addProductDetail(ProductDetail productDetail) {
			 this.productDeatilDAO.addProductDetail(productDetail);			
		}


	    @Transactional
		public void updateProductDetail(ProductDetail productDetail) {
			this.productDeatilDAO.updateProductDetail(productDetail);
			
		}


	    @Transactional
	    public List<ProductDetail> listProducts() {
			return this.productDeatilDAO.listProducts();
		}



	    @Transactional
	    public ProductDetail getProductDetailById(int id) {
			 return this.productDeatilDAO.getProductDetailById(id);
		}


	    @Transactional
		public void removeProductDetail(int id) {
			this.productDeatilDAO.removeProductDetail(id);
			
		}
	 
	
}
