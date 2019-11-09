package com.cg.SpringBootDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.SpringBootDemo.dto.Product;
import com.cg.SpringBootDemo.service.ProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

	@Autowired
	ProductService prodservice;
	//@RequestMapping(value = "/getall", method = RequestMethod.GET)
	@GetMapping(value = "/getall")
	public List<Product> getAllProduct() {
		return (prodservice.listAllProduct());
	}
	
	@PostMapping(value = "/add")
	public Product addProduct(@RequestBody Product pro) {
		return prodservice.addProduct(pro);
	}
	
	@DeleteMapping(value = "/delete")
	public String deleteProduct(@RequestParam int prodId) {
		Product pro = prodservice.removeProduct(prodId);
		if(pro != null)
			return pro.toString();
		else return "WRONG";
	}
	
	@PostMapping(value = "/update")
	public Product updateProduct(@RequestBody Product pro) {
		return prodservice.updateProduct(pro);
	}
}
