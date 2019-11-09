package com.cg.SpringBootDemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cg.SpringBootDemo.dto.Product;

@Repository("productdao")
public class ProductDaoImpl implements ProductDao{

	List<Product> prodList = new ArrayList<Product>();
	
	@Override
	public Product addProduct(Product pro) {
		// TODO Auto-generated method stub
		prodList.add(pro);
		return pro;
	}

	@Override
	public Product removeProduct(int prodId) {
		// TODO Auto-generated method stub
		Product deleteProduct = null;
		for (Product product : prodList) {
			if(prodId == product.getProdId()) {
				deleteProduct = product;
				break;
			}
		}
		if(deleteProduct != null) {
			prodList.remove(deleteProduct);
		}
		return deleteProduct;

	}

	@Override
	public Product searchProduct(int prodId) {
		for (Product product : prodList) {
			if(prodId == product.getProdId()) {
				return product;
			}
		}
		return null;
	}

	@Override
	public List<Product> listAllProduct() {
		// TODO Auto-generated method stub
		return prodList;
	}

	@Override
	public Product updateProduct(Product prod) {
		for (Product product : prodList) {
			if(prod.getProdId() == product.getProdId()) {
				product.setProdCost(prod.getProdCost());
				product.setProdDescription(prod.getProdDescription());
				product.setProdName(prod.getProdName());
				return prod;
			}
		}
		return null;
	}

}
