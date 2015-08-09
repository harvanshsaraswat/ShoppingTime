package com.technozip.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.technozip.business.ProductDeatilService;
import com.technozip.dto.ProductDetail;


@Controller
public class AllProductController {
	
	 private ProductDeatilService productDeatilService;
     
	    @Autowired(required=true)
	    @Qualifier(value="productDeatilService")
	    public void setPersonService(ProductDeatilService productDeatilService){
	    	System.out.println("Setting Product Service Object");
	        this.productDeatilService = productDeatilService;
	    }
	    
	   
	    
	    @RequestMapping(value = "/login", method = RequestMethod.GET)
	    public String login() {
	    	System.out.println("INSIDE LOGIN ");
	        return "login";
	    }
	    
	    
	    @RequestMapping(value = "/adminLogin", method = RequestMethod.GET)
	    public String adminLogin() {
	    	System.out.println("INSIDE Admin LOGIN ");
	        return "admin/adminLogin";
	    }
	    
	    @RequestMapping(value = "/adminNewProduct", method = RequestMethod.GET)
	    public String adminNewProduct(@ModelAttribute("productDetail") ProductDetail productDetail) {	    	
	    	System.out.println("INSIDE NEW ADMIN PROJECT");
	    	return "admin/addProduct";
	        
	    }
	    
	    



		@RequestMapping(value = "/index", method = RequestMethod.GET)
	    public String welcome() {
	    	System.out.println("INSIDE Welcome ");
	        return "helloworld";
	    }
	   
	    
	    @RequestMapping(value = "/addNewProduct", method = RequestMethod.POST)
	    public String addNewProduct(@ModelAttribute("productDetail")ProductDetail productDetail) {	 
	    	
	    	System.out.println(" Category:" + productDetail.getProductCategory() + 
                    "Product Cost:" + productDetail.getProductCost());
	    	productDeatilService.addProductDetail(productDetail);
	    	System.out.println("INSIDE New Product ");
	        return "admin/test";
	    }
}
