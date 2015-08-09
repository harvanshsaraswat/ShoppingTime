package com.technozip.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.technozip.dto.ProductDetail;

@Repository ("productDeatilDAO")
public class ProductDeatilDAOImpl implements ProductDeatilDAO {
	
	 private static final Logger logger = LoggerFactory.getLogger(ProductDeatilDAOImpl.class);
	 
	 @Autowired
    private SessionFactory sessionFactory;
	 
	

	@Transactional
	public void addProductDetail(ProductDetail productDetail) {
		System.out.println("IN SIDE DAO ============");
		 Session session = this.sessionFactory.getCurrentSession();
		 Transaction tx = null;
	     try{
	     tx = session.beginTransaction();
	     session.save(productDetail);   
	     tx.commit();
	       }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	        System.out.println("jjjjjjjjj");
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
