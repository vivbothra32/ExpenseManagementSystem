package com.cg.SpringBootDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.SpringBootDemo.dao.ProductDao;
import com.cg.SpringBootDemo.dto.Product;

@Service("productservice")
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productdao;
	
	@Override
	public Product addProduct(Product pro) {
		// TODO Auto-generated method stub
		return productdao.addProduct(pro);
	}

	@Override
	public Product removeProduct(int prodId) {
		// TODO Auto-generated method stub
		return productdao.removeProduct(prodId);
	}

	@Override
	public Product searchProduct(int prodId) {
		// TODO Auto-generated method stub
		return productdao.searchProduct(prodId);
	}

	@Override
	public List<Product> listAllProduct() {
		// TODO Auto-generated method stub
		return productdao.listAllProduct();
	}

	@Override
	public Product updateProduct(Product prod) {
		// TODO Auto-generated method stub
		return productdao.updateProduct(prod);
	}
	
}
