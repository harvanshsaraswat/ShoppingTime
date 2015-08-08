package com.technozip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
	    public String adminNewProduct() {	    	
	    	System.out.println("INSIDE admin New Product ");
	        return "admin/addProduct";
	    }
	    
	    
	    @RequestMapping(value = "/", method = RequestMethod.GET)
	    public String welcomePage(Model model) {
	        model.addAttribute("productDetail", new ProductDetail()); // the ProductDetail object is used as a template to generate the form
	        return "helloworld";
	    }
	    
	    @RequestMapping(value = "/addNewProduct", method = RequestMethod.POST)
	    public String addNewProduct(@Validated   @ModelAttribute("productDetail")
	    ProductDetail productDetail,BindingResult result) {	 
	    	
	    	System.out.println(" Category:" + productDetail.getProductCategory() + 
                    "Product Cost:" + productDetail.getProductCost());
	    	//productDeatilService.addProductDetail(productDetail);
	    	System.out.println("INSIDE New Product ");
	        return "admin/test";
	    }
}
