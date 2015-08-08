package com.technozip.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.technozip.dto.ProductDetail;

@Repository ("productDeatilDAO")
public class ProductDeatilDAOImpl implements ProductDeatilDAO {
	
	 private static final Logger logger = LoggerFactory.getLogger(ProductDeatilDAOImpl.class);
	 
	    private SessionFactory sessionFactory;

	@Override
	public void addProductDetail(ProductDetail productDetail) {
		 Session session = this.sessionFactory.getCurrentSession();
	        session.persist(productDetail);
	        logger.info("Product saved successfully, Product Details="+productDetail);		
	}

	@Override
	public void updateProductDetail(ProductDetail p) {
		Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
        logger.info("Product updated successfully, Product Details="+p);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ProductDetail> listProducts() {
		Session session = this.sessionFactory.getCurrentSession();
        List<ProductDetail> productList = session.createQuery("from ProductDetail").list();
        for(ProductDetail product : productList){
            logger.info("Product List::"+product);
        }
        return productList;
	}

	@Override
	public ProductDetail getProductDetailById(int id) {
		 Session session = this.sessionFactory.getCurrentSession();     
		 ProductDetail product = (ProductDetail) session.load(ProductDetail.class, new Integer(id));
	        logger.info("Product loaded successfully, Product details="+product);
	        return product;
	}

	@Override
	public void removeProductDetail(int id) {
		  Session session = this.sessionFactory.getCurrentSession();
		  ProductDetail product = (ProductDetail) session.load(ProductDetail.class, new Integer(id));
	        if(null != product){
	            session.delete(product);
	        }
	        logger.info("Product deleted successfully, product details="+product);		
	}
	
	

}
