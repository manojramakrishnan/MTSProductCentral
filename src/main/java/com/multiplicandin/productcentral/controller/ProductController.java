package com.multiplicandin.productcentral.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.multiplicandin.productcentral.model.Product;
import com.multiplicandin.productcentral.service.ProductService;


@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping (value = {"admin/products"}, method=RequestMethod.GET)
	public ModelAndView productScreen() {
		ModelAndView modelAndView=new ModelAndView();
    	Authentication auth= SecurityContextHolder.getContext().getAuthentication();
    	
    	modelAndView.addObject("outOfStockProducts",productService.findAllOutOfStock().size());
    	List<Product> products= productService.findAll();
    	modelAndView.addObject("products", products);
    	modelAndView.setViewName("/admin/products.html");
    	return modelAndView;

	}
	@RequestMapping(value = { "/admin/products/add" }, method = RequestMethod.GET)
	public ModelAndView productAdd() {
    	ModelAndView modelAndView = new ModelAndView();
        Product product = new Product();
         Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.err.println("auth name :: "+auth.getName());
     
        

         modelAndView.setViewName("/admin/add-product");
        return modelAndView;
	}
	
	@RequestMapping(value={"/admin/products/add"}, method = RequestMethod.POST)
    public ModelAndView addProduct(@Valid Product product, BindingResult result){
        ModelAndView modelAndView = new ModelAndView();
        if(result.hasErrors()) {
			modelAndView.setViewName("/admin/add-product.html");
		}
        else
        {
        	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//    		Store store = customer.getStore();
//			storeProduct.setStore(store);
//    		product=productService.findById(product.getId());
    		Product product1 = productService.createNewProduct(product);
    		Product products = productService.findAllByProductId(product1.getId());
            modelAndView.addObject("totalProducts", productService.findAll().size());
            modelAndView.addObject("outOfStockProducts", productService.findAllOutOfStock().size());
            List<Product> products1=productService.findAll();
            modelAndView.addObject("products", products1);
    		modelAndView.setViewName("redirect:/admin/products");
        	}
		return modelAndView;
        }
	
	@RequestMapping(value="/admin/products/edit", method = RequestMethod.POST)
    public ModelAndView editProduct(@RequestParam(name="productId") String productId) {
        ModelAndView modelAndView = new ModelAndView();
        Product product = productService.findById(Integer.valueOf(productId));
        

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        modelAndView.addObject("product", product);
        modelAndView.addObject("productName",product.getProductName());

        

        modelAndView.setViewName("/admin/edit-product");
        return modelAndView;
    }

	@RequestMapping(value = "/admin/products/save", method = RequestMethod.POST)
    public ModelAndView saveProductDetails(@RequestParam(name="productId")String productId,
                                        @RequestParam(name="productName")String productName,
                                        @RequestParam(name="productCode")String productCode,
                                        @RequestParam(name="category") String category,
                                        @RequestParam(name="quantity") Integer quantity)
                               
                                       {
		
		ModelAndView modelAndView = new ModelAndView();

        
         
         Authentication auth = SecurityContextHolder.getContext().getAuthentication();
         
         
         Product product = productService.getOne(Integer.valueOf(productId));
         product.setProductName(productName);
         product.setProductCode(productCode);
         product.setCategory(category);
         product.setQuantity(quantity);
         productService.update(product);

         

         modelAndView.setViewName("redirect:/admin/products");

        return modelAndView;
    }


}
